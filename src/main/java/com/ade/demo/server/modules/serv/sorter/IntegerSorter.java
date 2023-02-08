package com.ade.demo.server.modules.serv.sorter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IntegerSorter implements Sorter, InitializingBean {

    @Override
    public void afterPropertiesSet() {
        // 放入排序器集合
        SorterManager.add(this);
    }

    @Override
    public boolean canSort(List<Object> list) {
        if (list == null) return false;
        return list.stream().allMatch(Integer.class::isInstance);
    }

    @Override
    public List<Object> sort(List<Object> list) {
        return list.stream()
                // 这里过滤掉不支持的的类型，根据业务也可以抛出异常
                .filter(Integer.class::isInstance)
                .map(Integer.class::cast)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

}
