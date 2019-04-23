package com.tang.study.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 *
 * 输出
 * OK
 * NG
 * NG
 * OK
 */
public class VerificationPassword {

    public static void main(String[] args) throws IOException {

        String Password = "5434";
//        String pattern = "[a-z]|[A-Z]|[0-9]|[^a-zA-Z0-9]";
        String pattern = "[a-z]|[A-Z]|[0-9]";
        Pattern p = Pattern.compile(pattern);

        Matcher match = p.matcher(Password);
//        System.out.println(match.find());

        cal();
    }

    public static void cal() throws IOException {
        String flag = "";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine())!= null){
            if (Verification_1(line)&&Verification_2(line)&&Verification_3(line)){
                flag = "OK";
            }
            else flag = "NG";
            System.out.println(flag);
        }
    }

    /**
     * 正则匹配查找密码是否包含大小写，数字等其他符号
     * @param Password
     * @return
     */
    public static boolean Verification_1(String Password){

        int count = 0;
        String[] patterns = {"[a-z]","[A-Z]","[0-9]","[^a-zA-Z0-9]"};
        for (String pattern:patterns){
            Pattern p = Pattern.compile(pattern);
            Matcher match = p.matcher(Password);
            if (match.find()){
                count++;
            }
        }
        return count>=3;
    }

    /**
     * 查找是否有重复子串
     * @param Password
     * @return
     */
    public static boolean Verification_2(String Password){
        for (int i=0;i<Password.length()-3;i++){
            if (Password.substring(i+3).contains(Password.substring(i,i+3))){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断密码的长度是否符合要求
     * @param Password
     * @return
     */
    public static boolean Verification_3(String Password){
        if (Password.length()<=8){
            return false;
        }
        return true;
    }
}
