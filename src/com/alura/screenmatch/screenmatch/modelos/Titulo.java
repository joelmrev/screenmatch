package com.alura.screenmatch.screenmatch.modelos;

public class Titulo implements Comparable<Titulo>{
    private String nombre;

    private int fechaLanzamiento;

    private int duracionEnMinutos;

    private boolean incluidoEnElPlan;

    private double sumaDeLasEvaluaciones;

    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
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
}
