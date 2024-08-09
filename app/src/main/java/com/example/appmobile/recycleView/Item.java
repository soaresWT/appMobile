package com.example.appmobile.recycleView;

public class Item {
    private String titulo;
    private String descricao;

    public Item(String titulo, String descricao){
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
