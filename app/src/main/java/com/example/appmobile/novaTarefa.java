package com.example.appmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.appmobile.database.AppDatabase;
import com.example.appmobile.models.tarefa;
import com.example.appmobile.DAO.tarefaDAO;
import com.example.appmobile.database.AppDatabase;
import com.example.appmobile.recycleView.Item;

public class novaTarefa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nova_tarefa);

        Button btnSalvar = findViewById(R.id.btn_salvar);
        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_name")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

        tarefaDAO tarefaDAO = appDatabase.tarefaDao();


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            EditText titulo = findViewById(R.id.editTitutlo);
            EditText descricao = findViewById(R.id.editTDescricao);

            @Override
            public void onClick(View v) {
                tarefa taref = new tarefa(
                        titulo.getText().toString(),
                        descricao.getText().toString()

                );
                tarefaDAO.insertAll(taref);
                Intent intent = new Intent(novaTarefa.this, MainActivity.class);
                startActivity(intent) ;

            }

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}