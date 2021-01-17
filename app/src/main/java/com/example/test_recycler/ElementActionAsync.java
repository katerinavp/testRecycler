package com.example.test_recycler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ElementActionAsync extends Thread {
    public List<Element> listRandom = new ArrayList<>();

//    public ElementActionAsync(List<Element> list){
//        this.list = list;
//    }

    @Override
    public void run() {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                int id = 16;
                Random randomIndex = new Random();
                while (true) {
                    try {
                        listRandom.add(randomIndex.nextInt(), new Element(id));
                        System.out.println("Новая коллекция каждые 5 сек" );

                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                    listRandom.add(randomIndex.nextInt(), new Element(id));
                    System.out.println("Новая коллекция каждые 5 сек");
                }
            }
        }, 5000, 5000, TimeUnit.SECONDS);
    }

    //2 способ
//    @Override
//    public void run() {
//        while (true) {
//            int id = 16;
//            Random randomIndex = new Random();
//            try {
                //Thread.sleep(5000);
//                        System.out.println("Новая коллекция каждые 5 сек" );
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Ошибка " + e);
//                break;
//            }
//            listRandom.add(randomIndex.nextInt(), new Element(id));

           // System.out.println("Новая коллекция каждые 5 сек");
//        }

//    }
}





