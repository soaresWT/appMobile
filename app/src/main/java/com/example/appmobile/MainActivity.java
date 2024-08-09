package com.example.appmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.appmobile.DAO.tarefaDAO;
import com.example.appmobile.database.AppDatabase;
import com.example.appmobile.models.tarefa;
import com.example.appmobile.recycleView.ArrayAdapter;
import com.example.appmobile.recycleView.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView lista;
    ArrayList<Item> itemList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnCriar = findViewById(R.id.btn_nova);
        lista = findViewById(R.id.recyclerView);
        AppDatabase appDatabase = Room.databaseBuilder(this,
                        AppDatabase.class,
                        "db_name")
                .enableMultiInstanceInvalidation()
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration().build();

        tarefaDAO tarefaDAO = appDatabase.tarefaDao();
        List<tarefa> tarefas = tarefaDAO.getAll();

        for (tarefa t : tarefas) {
            itemList.add(new Item(t.titulo, t.descricao));
        }

        ArrayAdapter itemArrayAdapter = new ArrayAdapter(R.layout.activity_item, itemList);
        lista = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        lista.addItemDecoration(dividerItemDecoration);
        lista.setAdapter(itemArrayAdapter);
        btnCriar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, novaTarefa.class);
                        startActivity(intent) ;
                        }
                }
        );
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }


}