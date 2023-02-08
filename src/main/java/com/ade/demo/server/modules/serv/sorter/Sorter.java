package com.ade.demo.server.modules.serv.sorter;

import java.util.List;

/**
 * 排序器
 */
public interface Sorter {

    /**
     * 判断集合种所有的对象类型是否可以排序
     * @param list 待检查集合
     * @return true-所有元素都支持排序; false-含有不支持排序的元素
     */
    boolean canSort(List<Object> list);

    /**
     * 实现自定义排序逻辑
     * @param list
     * @return
     */
    List<Object> sort(List<Object> list);

}
