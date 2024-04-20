package com.alura.screenmatch.principal;

import com.alura.screenmatch.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.screenmatch.modelos.Serie;
import com.alura.screenmatch.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {

    public static void main(String[] args) {

        Pelicula miPelicula =  new Pelicula("NEED FOR SPEED", 2008);
        miPelicula.evalua(9.8);
        Pelicula otraPelicula = new Pelicula("LA VIDA ES BELLA", 1990);
        otraPelicula.evalua(9);
        var peliculaDeJoel = new Pelicula("El Astronauta", 2023);
        peliculaDeJoel.evalua(7.5);
        Serie Scorpion = new Serie("SCORPION", 2005);

//      Se utiliza la  interfaz "List" para añadirle mayor abstracción y referenciar LA INTERFAZ LIST
//      a nuestra instancia, y así poder utilizar los diferentes métodos que tiene nuestra interfaz
        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeJoel);
        lista.add(Scorpion);

        for (Titulo item: lista) {
            System.out.println("Nombre: " + item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3) {
                System.out.println("Clasificación: " + pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Zoé");
        listaDeArtistas.add("Colplay");
        listaDeArtistas.add("Sam Smith");
        listaDeArtistas.add("Rels B");
        System.out.println("Lista de Artistas No Ordenada: " + listaDeArtistas);


        Collections.sort(listaDeArtistas);
        System.out.println("Lista de Artistas Ordenada: " + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista Ordenada de Titulos: " + lista);

//       Otra FORMA utilizando la interfaz COMPARATOR con el método estático "comparing"
        lista.sort(Comparator.comparing(Titulo::getFechaLanzamiento));
        System.out.println("Lista Ordenada por Fecha: " + lista);
    }
}
