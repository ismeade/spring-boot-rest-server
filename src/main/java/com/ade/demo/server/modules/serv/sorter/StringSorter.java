package com.ade.demo.server.modules.serv.sorter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StringSorter implements Sorter, InitializingBean {

    @Override
    public void afterPropertiesSet() {
        // 放入排序器集合
        SorterManager.add(this);
    }

    @Override
    public boolean canSort(List<Object> list) {
        if (list == null) return false;
        return list.stream().allMatch(String.class::isInstance);
    }

    @Override
    public List<Object> sort(List<Object> list) {
        return list.stream()
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }
}
