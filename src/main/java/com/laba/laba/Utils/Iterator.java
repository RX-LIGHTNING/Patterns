package com.laba.laba.Utils;

import java.util.ArrayList;
import java.util.List;

public class Iterator<T> implements com.laba.laba.Utils.Impl.Iterator {
    
    List<T> Objects = new ArrayList<>();
    int currentPosition = 0;
    @Override
    public boolean hasNext() {
        if (currentPosition<Objects.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (hasNext()){
            T t = Objects.get(currentPosition);
            currentPosition++;
            return t;
        }
        else{
            return null;
        }
    }

    public Iterator(List<T> objects) {
        Objects = objects;
    }
}
