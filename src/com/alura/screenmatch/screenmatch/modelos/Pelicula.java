package com.alura.screenmatch.screenmatch.modelos;

import com.alura.screenmatch.screematch.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {

   private String director;


    public Pelicula(String nombre, int fechaLanzamiento) {
        super(nombre, fechaLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Película: " + this.getNombre() + " (" + getFechaLanzamiento() + ")";
    }
}
