package br.com.filmes.util;

import br.com.filmes.model.Titulo;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscritorDeArquivo {
    public void EscreverEmArquivo(List<Titulo> titulos, Gson gson) throws IOException {
        FileWriter escrever = new FileWriter("Filmes.json");
        escrever.write(gson.toJson(titulos));
        escrever.close();
    }
}
