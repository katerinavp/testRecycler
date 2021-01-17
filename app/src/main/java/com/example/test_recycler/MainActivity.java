package com.example.test_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Element> list = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterElement adapter;
    ElementViewModel model;

    //Button btnDelete = findViewById(R.id.btnDelete);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        model = ViewModelProviders.of(this).get(ElementViewModel.class);
        model.getData().observe(this, list->{

                recyclerView.setAdapter(new AdapterElement(list));

        });



//        if(model.getData() == null){
//            System.out.println("model пустая");
//            setInitData();
//            adapter = new AdapterElement(this, list);
//            recyclerView.setAdapter(adapter);
//        }else{
        //recyclerView.setAdapter(new AdapterElement(this, model.getData()));
//        }
        // начальная инициализация списка
        //setInitData();

        // создаем адаптер

        //adapter = new AdapterElement(this, list);
        // устанавливаем для списка адаптер


//        List<Element> data = model.getData();

//       model(this, new Observer<List<Element>>() {
//            @Override
//            public void onChanged(List<Element> listNew) {
//                recyclerView.setAdapter(new AdapterElement(listNew));
//            }
//        });
        //recyclerView.setAdapter(adapter);

    }

//    public void setInitData() {
//        list.add(new Element(1));
//        list.add(new Element(2));
//        list.add(new Element(3));
//        list.add(new Element(4));
//    }


}