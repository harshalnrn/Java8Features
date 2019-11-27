package com.properties.functionalInterfaces;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 -o1;
    }
}
