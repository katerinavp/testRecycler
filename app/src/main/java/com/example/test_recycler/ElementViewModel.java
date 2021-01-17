package com.example.test_recycler;

import java.util.Random;
import java.util.concurrent.ExecutorService;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;


public class ElementViewModel extends ViewModel implements Runnable {
    ElementActionAsync elementActionAsync;
    //MutableLiveData<Integer> data;
    private MutableLiveData<List<Element>> data;
    //    private List<Element> data = new MutableLiveData<>();
    private List<Element> list = new ArrayList<>();

    public LiveData<List<Element>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            loadData();
        }
        return data;
    }

//    public void setData(List<Element> listNew) {
//        listViewModel = listNew;
//    }


    public void loadData() {

//        data.setValue(MainActivity.list);
//        data.setValue(repository.getElement());
        data.setValue(setInitData());
    }


    @Override
    protected void onCleared() {
        Log.e("ElementViewModel", "==========onCleared()==========");
        super.onCleared();
    }

    public List<Element> setInitData() {

        int id = 16;
        int minNumber = 1;
        while (list.size() < 15) {
            list.add(new Element(minNumber));
            minNumber++;

        }


        elementActionAsync = new ElementActionAsync();

        System.out.println("Начало ");
        elementActionAsync.start();


        return list;

        //return list;
    }


    @Override
    public void run() {


    }
}
