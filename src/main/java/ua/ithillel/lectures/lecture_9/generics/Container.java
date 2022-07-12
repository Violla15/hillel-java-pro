package ua.ithillel.lectures.lecture_9.generics;

import java.util.ArrayList;
import java.util.List;

public class Container <T extends Product>{
    private List<T>items ;

    public Container() {
        items = new ArrayList<>();
    }

    public <E> Container(E item){
        System.out.println("Type of item "+ item.getClass().getSimpleName());
    }
    public void add (T item){
        items.add(item);
    }
}
