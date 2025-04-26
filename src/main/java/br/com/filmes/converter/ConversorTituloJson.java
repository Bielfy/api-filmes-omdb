package br.com.filmes.converter;

import br.com.filmes.model.Titulo;
import br.com.filmes.model.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorTituloJson {
    private Gson gson;

    public Gson criaGsonConfigurado() {
        gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        return gson;
    }

    public Titulo converter(String json, Gson gson){
        TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
        if (json.contains("\"Response\":\"False\"")) {
            System.out.println("Filme não encontrado. Tente com o nome original em inglês.");
            return null;
        }
        if ((tituloOmdb.response() == null) || tituloOmdb.response().equalsIgnoreCase("False")) {
            System.out.println("Filme não encontrado!");
            return null;
        }
        return new Titulo(tituloOmdb);
    }
}
