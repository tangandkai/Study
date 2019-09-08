package com.tang.yaxin.Str;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrSplit {

    public static void main(String[] args) throws IOException {

        String path = "E:\\yaxin\\文档\\09.山西试点-客户数据及材料\\山西联通网关中心自采的DPI数据-5.22提供\\S1-MME信令话单要求\\SXI_TY_MOBILE_CNOS_YONGDING_CXDR_objectType_0005_20190521153019_S1MME-00240_0_0.txt";

        BufferedReader read = new BufferedReader(new FileReader(path));
        String writerPath = "C:\\Users\\tang\\Desktop\\亚信\\S1-MME信令话单要求\\0005_20190521153019_S1MME-00240_0_0.txt";
        String writePath_1 = "C:\\Users\\tang\\Desktop\\亚信\\S1U口数据数据20190617\\S1UIM-11500_0_0.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(writerPath));
        int line = 1;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        String maxContent = "";

        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        String minContent = "";
        String result;

        int num = 0;
        int total = 0;  //字段数小于88的个数
        while ((result=read.readLine())!=null){
            String[] splits = result.split("\\|");

            String pattern = "\\|";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(result);
            int count = 1;
            while (m.find()){
                count++;
            }

            writer.write("第"+line+"行的字段数:"+"\t"+count+"\n");
            if (count>=max){
                max = count;
                maxIndex = line;
                maxContent = result;
            }
            if (count<min){
                min = count;
                minIndex = line;
                minContent = result;
            }
            if (count>75){
                total++;
//                System.out.println("字段个数是88以下的行的字段个数："+splits.length+"\t"+"行标是:"+line+"\n"+"该行的内容是:"+result);
            }
            if (num<100 && count!=75){
                System.out.println("第"+line+"行的字段数是："+splits.length+"\n"+result);
                num++;
            }
            line++;
        }
//        System.out.println("字段数大于75的行数为:"+total);
        System.out.println("字段数最多的行是"+maxIndex+"\n"+"字段数是:"+max+"\n"+"内容是:"+maxContent);

//        String[] ss = maxContent.split("\\|");
//        for (int i=0;i<ss.length;i++){
//            System.out.println(ss[i]);
//        }
        System.out.println("字段数最小的行是"+minIndex+"\n"+"字段数是:"+min+"\n"+"内容是:"+minContent);
//        String[] sss = minContent.split("\\|");
//        for (int i=0;i<sss.length;i++){
//            System.out.println(sss[i]);
//        }
        writer.close();
        read.close();
    }
}
