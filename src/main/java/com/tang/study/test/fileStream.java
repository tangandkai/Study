package com.tang.study.test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class fileStream {

    private static Map<String,String> hash = new HashMap<>();
    public void stream() throws IOException {
        File file = new File("");
        InputStream fileStream = new FileInputStream("");
        Reader fileRead = new FileReader("");

        new InputStreamReader(new FileInputStream(file),"UTF-8");


    }

    public static void main(String[] args) {
        hash.put("","");
        hash.put("","");
        hash.put("A","B");
        System.out.println(hash);
    }
}
