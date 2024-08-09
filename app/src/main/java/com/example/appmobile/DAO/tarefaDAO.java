package com.example.appmobile.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.appmobile.models.tarefa;

import java.util.List;

@Dao
public interface tarefaDAO {

    @Insert
    void insert(tarefa tarefa);

    @Insert
    void insertAll(tarefa... tarefas);

    @Query("SELECT * FROM  tarefa")
    List<tarefa> getAll();
}
