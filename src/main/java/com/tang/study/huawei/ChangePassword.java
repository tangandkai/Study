package com.tang.study.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6,
 * pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，
 * 数字和其他的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，
 * 如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 * 输入描述:
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 输出描述:
 * 输出渊子真正的密文
 * 示例1
 * 输入
 * YUANzhi1987
 * 输出
 * zvbo9441987
 */
public class ChangePassword {
    private static Map<String,String> hashMap = new HashMap<>();
    static {
        hashMap.put("1","1");
        hashMap.put("abc","2");
        hashMap.put("def","3");
        hashMap.put("ghi","4");
        hashMap.put("jkl","5");
        hashMap.put("mno","6");
        hashMap.put("pqrs","7");
        hashMap.put("tuv","8");
        hashMap.put("wxyz","9");
        hashMap.put("0","0");
    }
    public static void main(String[] args) throws IOException {

        cal();
    }

    /**
     * ascii对照
     * A~Z 65~90
     * a~z 97~122
     * 2~9 51~57
     */
    public static void cal() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String Password = "";
        while ((Password=br.readLine())!= null){
            if (Password.length()<=100){
                StringBuilder result = change(Password);
                System.out.println(result.toString());
            }
        }
    }

    /**
     * A~Z 65~90
     * a~z 97~122
     * 0~9 48~57
     * @param Password
     */
    public static StringBuilder change(String Password){
        StringBuilder builder = new StringBuilder();
        char[] chars = Password.toCharArray();
        for (int i=0;i<chars.length;i++){
            char first = chars[i];
            int value = (int)first;
            if (value >=65 && value<=90){
                //该范围内是大写字母,需要先转成小写，然后后移一位
                value = value + 32;
                if (value==122){//当字符为y时，转成小写需要后移以为变为a
                    builder.append("a");
                }
                else builder.append(""+(char)(value+1));
            }
            else if (value >=97 && value<=122 || value==48 || value==49){//该范围内是小写字母,需要转成数字
                Set<String> keys = hashMap.keySet();
                for (String key:keys){
                    if (key.contains(""+first)){
                        builder.append(hashMap.get(key));
                        break;
                    }
                }
            }
            else {//该范围内为数字或者其他字符，无需处理
                builder.append(""+first);
            }
        }
        return builder;
    }
}
