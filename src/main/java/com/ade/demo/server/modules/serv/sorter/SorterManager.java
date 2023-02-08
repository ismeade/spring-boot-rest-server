package com.ade.demo.server.modules.serv.sorter;

import com.ade.demo.server.exception.ReturnException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 排序器管理器
 */
public class SorterManager {

    private final static ReadWriteLock lock = new ReentrantReadWriteLock();

    private final static List<Sorter> sorters = new ArrayList<>();

    public static void add(Sorter sorter) {
        lock.writeLock().lock();
        try {
            sorters.add(sorter);
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * 查找可用的排序器
     * @param list
     * @return
     */
    public static Sorter findSorter(List<Object> list) {
        lock.readLock().lock();
        try {
            return sorters.stream()
                    // 筛选排序器
                    .filter(sorter -> sorter.canSort(list))
                    // 返回符合的第一个排序器
                    .findFirst()
                    // 没匹配到排序器抛出不支持异常
                    .orElseThrow(() -> ReturnException.SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT);
        } finally {
            lock.readLock().unlock();
        }
    }

}
