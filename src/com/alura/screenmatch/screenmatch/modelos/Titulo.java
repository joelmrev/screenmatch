package com.alura.screenmatch.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    //Aviso a nuestro programa, para que convierta los datos de @SerializedName("")a variables
    // de nuestro programa
    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaLanzamiento;

    private int duracionEnMinutos;

    private boolean incluidoEnElPlan;

    private double sumaDeLasEvaluaciones;

    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.title();
        this.fechaLanzamiento = Integer.valueOf(miTituloOmdb.year());
        this.duracionEnMinutos = Integer.valueOf(miTituloOmdb.runtime().substring(0,2));
    }

    //-------------------------    GETTERS  ----------------------------------------//


    public String getNombre() {
        return nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    //-------------------------    SETTERS  ----------------------------------------//
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    //----------------------------------------------------------------------------

    public int getTotalDeLasEvaluaciones() {
        return totalDeLasEvaluaciones;
    }

    public void muestraFichaTecnica () {
        System.out.println("PELICULA: " + nombre);
        System.out.println("Fecha de Lanzamiento: " + fechaLanzamiento);
        System.out.println("Duración: " + getDuracionEnMinutos() + " minutos");
    }

    public void evalua(double nota) {
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    public double calculaMedia() {
        return sumaDeLasEvaluaciones/totalDeLasEvaluaciones;
    }


//    Sobreescritura del método COMPARABLE para forzar la comparación de un Titulo con otroTitulo
    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    //Modificación de toString() para que al imprimir nuestros datos desde "PrincipalConBusqueda"
    //nos aparece de acuerdo a este String
    @Override
    public String toString() {
        return  "Nombre: '" + nombre + '\'' +
                ", FechaLanzamiento: " + fechaLanzamiento + ",   " +
                "Duración: " + duracionEnMinutos;
    }
}
