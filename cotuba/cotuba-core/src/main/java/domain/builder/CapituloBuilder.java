package domain.builder;

import domain.Capitulo;

public class CapituloBuilder {

    private String titulo;
    private String conteudoHtml;

    public CapituloBuilder comTitulo(String titulo){
        this.titulo = titulo;
        return this;

    }

    public CapituloBuilder comConteudoHTML(String conteudoHtml){
        this.conteudoHtml = conteudoHtml;
        return this;
    }

    public Capitulo constroi(){
        return new Capitulo(titulo, conteudoHtml);
    }


}
