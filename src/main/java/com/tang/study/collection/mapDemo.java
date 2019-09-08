package com.tang.study.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class mapDemo {

    public static void main(String[] args) {

        Map map = new Hashtable();
        Map map1 = new HashMap();
        map1.put("","");
        Map map2 = new ConcurrentHashMap();
        Map map3 = new TreeMap();
    }
}
