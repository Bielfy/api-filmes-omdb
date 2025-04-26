package br.com.filmes.model;

import br.com.filmes.exception.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        //Dois modos de fazer:
        if(meuTituloOmdb.year() == null || meuTituloOmdb.year().length() < 4){
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano "
                    +"porque tem mais de 04 caracteres");
        } else {
            this.anoDeLancamento = Integer.parseInt(meuTituloOmdb.year().substring(0, 4));
        }
        try {
            this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().replace("min", "").trim());
        } catch (NumberFormatException e){
            this.duracaoEmMinutos = 0;
        }

    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.nome.compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Nome= " + this.nome + ", Ano de lançamento= "+ this.anoDeLancamento + ", Duração em minutos= "+ this.duracaoEmMinutos;
    }
}
