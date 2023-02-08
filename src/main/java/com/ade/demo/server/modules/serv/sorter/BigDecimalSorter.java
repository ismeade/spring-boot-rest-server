package com.ade.demo.server.modules.serv.sorter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 支持Double 和 BigDecimal类型排序，先转成BigDecimal在进行排序
 */
@Component
public class BigDecimalSorter implements Sorter, InitializingBean {

    @Override
    public void afterPropertiesSet() {
        // 放入排序器集合
        SorterManager.add(this);
    }

    @Override
    public boolean canSort(List<Object> list) {
        if (list == null) return false;
        return list.stream()
                .allMatch(this::match);
    }

    @Override
    public List<Object> sort(List<Object> list) {
        return list.stream()
                .filter(this::match)
                .map(o -> {
                    if (o instanceof BigDecimal)
                        return (BigDecimal) o;
                    return new BigDecimal(o.toString());
                })
                .sorted(BigDecimal::compareTo)
                .collect(Collectors.toList());
    }

    private boolean match(Object o) {
        return o instanceof Double || o instanceof BigDecimal || o instanceof Integer;
    }
}
