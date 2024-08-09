package com.example.appmobile.database;



import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.appmobile.DAO.tarefaDAO;
import com.example.appmobile.models.tarefa;

@Database(entities = {tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract tarefaDAO tarefaDao();
}

