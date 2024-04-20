package com.alura.screenmatch.principal;

import com.alura.screenmatch.screematch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.screematch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.screenmatch.modelos.Episodio;
import com.alura.screenmatch.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula =  new Pelicula("NEED FOR SPEED", 2008);
        miPelicula.setDuracionEnMinutos(160);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(8.8);

        System.out.println("Total de Evaluaciones: " + miPelicula.getTotalDeLasEvaluaciones());
        System.out.println("Media: " + miPelicula.calculaMedia());

        System.out.println("****************************************************");

            Serie Scorpion = new Serie("SCORPION", 2005);
        Scorpion.setTemporadas(4);
        Scorpion.setMinutosPorEpisodio(55);
        Scorpion.setEpisodiosPorTemporada(20);
        Scorpion.muestraFichaTecnica();
        System.out.println("Duración de la serie en minutos: " + Scorpion.getDuracionEnMinutos() + " minutos");

        Pelicula otraPelicula = new Pelicula("LA VIDA ES BELLA", 1990);
        otraPelicula.setDuracionEnMinutos(120);
        otraPelicula.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(Scorpion);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus títulos: " +
                calculadora.getTiempoTotal() + " minutos");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNombre("DRUGS, SEX AND ROCK AND ROLL");
        episodio.setNumero(7);
        episodio.setSerie(Scorpion);
        episodio.setTotalDeVisualizaciones(90);
        filtroRecomendacion.filtra(episodio);

        var peliculaDeJoel = new Pelicula("El Astronauta", 2023);
        peliculaDeJoel.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeJoel);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño del ARRAY: " + listaDePeliculas.size());
        System.out.println("La primera película es: " + listaDePeliculas.get(0).getNombre() + " (" +
                listaDePeliculas.get(0).getFechaLanzamiento() + ")");
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la película: " + listaDePeliculas.get(0).toString() );

    }
}
