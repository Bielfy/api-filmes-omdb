package br.com.filmes.app;

import br.com.filmes.api.ApiKey;
import br.com.filmes.api.ApiOmdbClient;
import br.com.filmes.converter.ConversorTituloJson;
import br.com.filmes.model.Titulo;
import br.com.filmes.util.EscritorDeArquivo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//ATENÇÃO, CASO NÃO ENCONTRE O FILME, TENTE EM INGLÊS.

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String nomeDoFilme = "";
        Gson gson = null;

        ApiOmdbClient apiOmdbClient = new ApiOmdbClient();
        ApiKey apiKey = new ApiKey();
        ConversorTituloJson conversorDeTitulo = new ConversorTituloJson();
        EscritorDeArquivo escritorDeArquivo = new EscritorDeArquivo();

        List<Titulo> titulosEncontrados = new ArrayList<>();


        while (!nomeDoFilme.equalsIgnoreCase("Sair")){
            System.out.println("Digite o filme que deseja buscar: ");
            nomeDoFilme = scanner.nextLine();

            if(nomeDoFilme.equalsIgnoreCase("sair")){
                break;
            }

            String json = apiOmdbClient.buscarDados(apiKey.montarURL(nomeDoFilme));
            System.out.println(json);
            gson = conversorDeTitulo.criaGsonConfigurado();
            Titulo tituloConvertido = conversorDeTitulo.converter(json,gson);
            if (tituloConvertido != null) {
                titulosEncontrados.add(tituloConvertido);
            }
        }

        Collections.sort(titulosEncontrados);
        escritorDeArquivo.EscreverEmArquivo(titulosEncontrados,gson);
    }
}
