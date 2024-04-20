package com.alura.screenmatch.screematch.calculos;

public class FiltroRecomendacion {

    public void filtra(Clasificable clasificacion) {
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Título recomendado.");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("Títulos Populares del momento.");
        } else {
            System.out.println("Agregalo a tú lista!");
        }
    }
}
