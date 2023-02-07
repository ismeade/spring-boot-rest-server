package com.ade.demo.server.modules.tools.service;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SorterManager {

    private final static Map<String, Comparator<?>> manager = new ConcurrentHashMap<>();

    public static void register(String className, Comparator<?> sorter) {
        manager.put(className, sorter);
    }

    public static Comparator<?> get(String className) {
        return manager.get(className);
    }

}
