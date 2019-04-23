package com.tang.study.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Second {

    public static void main(String[] args) throws IOException {

        cal();
    }

    /**
     * 200 0 200 10 200 50 200 30 200 25
     *
     * @throws IOException
     */
    public static void cal() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {

            func(line);
        }
    }


    public static void func(String line) {

    }

}