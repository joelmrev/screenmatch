package com.alura.screenmatch.principal;

import com.alura.screenmatch.screenmatch.modelos.Titulo;
import com.alura.screenmatch.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de una película: ");
        var busqueda = lectura.nextLine();

        //Personalización de nuestro link para que busqué según el usuario
        String direccion = "https://www.omdbapi.com/?t=" +busqueda+ "&apikey=3eb9c1a2";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        //Instanciar GsonBuilder para utilizar el Record-TituloOmdb
        // así como agregar la política, al decirle que los datos que va a recibir del Json
        //empiezan con mayúscula y los pase a minúscula para que el Record pueda utilizarlos
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        //Conversión de Json a nuestra clase
        TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(miTituloOmdb);

        Titulo miTitulo = new Titulo(miTituloOmdb);
        System.out.println(miTitulo);
    }
}
