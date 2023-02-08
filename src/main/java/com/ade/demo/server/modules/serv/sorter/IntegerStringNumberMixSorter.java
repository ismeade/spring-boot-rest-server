package com.ade.demo.server.modules.serv.sorter;

import com.ade.demo.server.utils.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Integer和String数据 混合排序器
 */
@Component
public class IntegerStringNumberMixSorter implements Sorter, InitializingBean {

    @Override
    public void afterPropertiesSet() {
        // 放入排序器集合
        SorterManager.add(this);
    }

    @Override
    public boolean canSort(List<Object> list) {
        if (list == null) return false;
        return list.stream().allMatch(this::match);
    }

    @Override
    public List<Object> sort(List<Object> list) {
        return list.stream()
                // 这里过滤掉不支持的的类型，根据业务也可以抛出异常
                .filter(this::match)
                .map(new Function<Object, Integer>() {
                    @Override
                    public Integer apply(Object o) {
                        if (o instanceof String)
                            return Integer.parseInt((String) o);
                        return (Integer) o;
                    }
                })
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    private boolean match(Object o) {
        return o instanceof Integer
                || (o instanceof String && StringUtils.isNumeric((String) o));
    }

}
