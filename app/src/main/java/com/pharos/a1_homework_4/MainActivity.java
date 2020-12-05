package com.pharos.a1_homework_4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.ItemClickListener {

    public static final String KEY = "key" ;
    public RecyclerView recyclerView;
    private MainAdapter adapter;
    public List<Title> list;
    public static int REQUEST_CODE = 1;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Title("Item " + i + " Список заметок"));
        }


        adapter = new MainAdapter(list, this);
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(recyclerView);
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback
            (ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT |
                    ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };

    @Override
    public void onItemClick(Title title, int pos) {
        this.position = pos;
        Intent intent = new Intent(this,ActivityTwo.class);
        intent.putExtra(KEY, title);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            Title title = (Title) data.getSerializableExtra(ActivityTwo.KEY2);
            adapter.setElement(title, position);
        }
    }
}