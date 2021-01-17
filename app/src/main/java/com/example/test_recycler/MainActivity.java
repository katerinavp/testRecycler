package com.example.test_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        int numberOfColumns = getResources().getInteger(R.integer.tiles_rows);
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        ElementViewModel model = ViewModelProviders.of(this).get(ElementViewModel.class);
        final AdapterElement adapter = new AdapterElement(new ElementDiffItemCallback(), model::removeElementAt);
        recyclerView.setAdapter(adapter);
        model.getData().observe(this, adapter::submitList);


    }
}