package com.ade.demo.server.modules.tools.service.impl;

import com.ade.demo.server.exception.ReturnException;
import com.ade.demo.server.modules.tools.service.SortService;
import com.ade.demo.server.modules.tools.sorter.SorterManager;
import com.ade.demo.server.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public List<Object> sort(List<Object> list) {
        // 判断集合中是否是相同类型数据
        if (!CollectionUtils.isClassConsistent(list)) {
            // 有不同的class对象，返回提示，如果有转化策略可以尝试转化
            throw ReturnException.SORT_ERROR_NOT_SUPPORTED_HETEROGENEOUS_DATA;
        }
        // 查找对应数据类型的排序器
        final Comparator<?> sorter = list.stream()
                // 拿出任意一个元素
                .findAny()
                // 转换 -> class -> className -> service
                .map(Object::getClass)
                .map(Class::getName)
                .map(SorterManager::get)
                // 没找到service：不支持该种数据排序
                .orElseThrow(() -> ReturnException.SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT);
        LOG.info("sorter: {}", sorter.getClass());
        // switch (sortType) {
        // case "ase":
        // Collections.sort(list, sorter);
        // }

        return null;
    }

}
