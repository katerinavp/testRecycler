package com.example.test_recycler;

import java.util.Collections;
import java.util.List;

public abstract class RepoElement {
    private List<Element> elements = Collections.emptyList();

    public List<Element> getElement(){
        return elements;
    }

    public void saveElement(List<Element> listNew) {

    }
}
