package com.example.appmobile.models;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;



@Entity(tableName = "tarefa")
public class tarefa {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "titulo")
    public String titulo;

    @ColumnInfo(name = "descricao")
    public String descricao;

    public tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    @NonNull
    @Override
    public String toString() {
        return  this.titulo + " - " + this.descricao;
    }
}
