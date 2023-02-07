package com.ade.demo.server.modules.tools.sorter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Comparator;

@Component
public class IntegerSorter implements Comparator<Integer>, InitializingBean {

    @Override
    public int compare(Integer o1, Integer o2) {
        // 自定义排序方法
        return o1.compareTo(o2);
    }

    @Override
    public void afterPropertiesSet() {
        SorterManager.register(Integer.class.getName(), this);
    }

}
