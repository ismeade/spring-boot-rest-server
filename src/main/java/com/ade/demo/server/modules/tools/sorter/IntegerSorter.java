package com.ade.demo.server.modules.tools.sorter;

import java.util.Comparator;

public class IntegerSorter implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
//        if (Objects.equals(o1, o2)) return 0;
        return o1 - o2 ;
    }
}
