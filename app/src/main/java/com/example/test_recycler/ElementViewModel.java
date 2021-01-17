package com.example.test_recycler;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ElementViewModel extends ViewModel implements Runnable {

    private static final long DELAY_MILLIS = 5_000;
    private static final int DEFAULT_SIZE = 15;
    private MutableLiveData<List<Element>> data;
    private List<Element> list = new ArrayList<>();
    private final Handler handler = new Handler(Looper.myLooper());
    private final Random random = new Random();
    private int lastId = 14;
    private final LinkedList<Integer> removedIds = new LinkedList<>();

    public LiveData<List<Element>> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            loadData();
        }
        return data;
    }

    public void loadData() {
        data.setValue(setInitData());
    }


    @Override
    protected void onCleared() {
        handler.removeCallbacks(this);
    }

    public List<Element> setInitData() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            list.add(new Element(i));
        }
        handler.postDelayed(this, DELAY_MILLIS);

        return list;
    }


    public void removeElementAt(int index) {
        list = new ArrayList<>(list);
        Element removed = list.remove(index);
        removedIds.add(removed.number);
        data.setValue(list);
    }

    @Override
    public void run() {
        int nextInt = random.nextInt(list.size());
        list = new ArrayList<>(list);

        int elementId;
        if (removedIds.isEmpty()) {
            elementId = ++lastId;
        } else {
            elementId = removedIds.get(0);
            removedIds.remove(0);
        }

        list.add(nextInt, new Element(elementId));
        data.setValue(list);
        handler.postDelayed(this, DELAY_MILLIS);
    }
}
