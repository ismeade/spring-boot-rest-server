package com.ade.demo.server.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class CollectionUtils {

    private static final Logger LOG = LoggerFactory.getLogger(CollectionUtils.class);

    /**
     * 检查集合中对象是否同一class
     *
     * @param collection 待检查集合
     * @return true-是相同class; false-不相同class
     */
    public static boolean isClassConsistent(Collection<?> collection) {
        if (collection.size() <= 1) {
            return true;
        }
        final Object[] objects = collection.toArray();
        for (int i = 1; i < objects.length; i++) {
            if (!objects[i - 1].getClass().equals(objects[i].getClass())) {
                return false;
            }
        }
        return true;
    }

}
