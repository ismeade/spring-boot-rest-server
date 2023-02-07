package com.ade.demo.server.modules.tools.sorter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class StringSorter implements Comparator<String>, InitializingBean {

    @Override
    public int compare(String o1, String o2) {
        // 自定义排序方法
        return o1.compareTo(o2) ;
    }

    @Override
    public void afterPropertiesSet() {
        SorterManager.register(String.class.getName(), this);
    }

}
