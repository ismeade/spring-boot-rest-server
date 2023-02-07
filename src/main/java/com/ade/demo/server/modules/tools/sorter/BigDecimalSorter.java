package com.ade.demo.server.modules.tools.sorter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;

@Component
public class BigDecimalSorter implements Comparator<BigDecimal>, InitializingBean {

    @Override
    public int compare(BigDecimal o1, BigDecimal o2) {
        // 自定义排序方法
        return o1.compareTo(o2);
    }

    @Override
    public void afterPropertiesSet() {
        SorterManager.register(BigDecimal.class.getName(), this);
    }

}
