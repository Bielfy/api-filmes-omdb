package br.com.filmes.api;

public class ApiKey {
    private static final String API_KEY = "9ed33c7e";

    public String montarURL(String resposta) {
        return "https://www.omdbapi.com/?t=" + resposta.replace(" ", "+") + "&apikey="+ API_KEY;
    }
}
