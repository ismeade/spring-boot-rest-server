package com.ade.demo.server.modules.tools.service.impl;

import com.ade.demo.server.exception.ReturnException;
import com.ade.demo.server.exception.ReturnExceptionEnum;
import com.ade.demo.server.modules.tools.service.SortService;
import com.ade.demo.server.modules.tools.service.SorterManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SortServiceImpl implements SortService, InitializingBean {



    public void desc(List<Object> list) {
        final List<Integer> collect = list.stream()
                .filter(o -> o instanceof Integer)
                .map(Integer.class::cast)
                .sorted((o1, o2) -> {
                    if (Objects.equals(o1, o2)) return 0;
                    return o1 > o2 ? 1 : -1;
                }).collect(Collectors.toList());

    }

    public void aes(List<Object> list) {
        desc(list);
        Collections.reverse(list);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        SorterManager.register(Integer.class.toString(), this);
    }

    @Override
    public List<Object> sort(List<Object> list, String sortType) {

        // 查找对应数据类型的排序器
        final Comparator<?> sorter = list.stream()
                // 拿出任意一个元素
                .findAny()
                // 转换 -> class -> className -> service
                .map(Object::getClass)
                .map(Class::toString)
                .map(SorterManager::get)
                // 没找到service：不支持该种数据排序
                .orElseThrow(() -> new ReturnException(ReturnExceptionEnum.SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT));
//        switch (sortType) {
//            case "ase":
//                Collections.sort(list, sorter);
//        }

        return null;
    }
}
