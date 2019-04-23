package com.tang.study.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，
 * 不合法的地址和掩码单独归类。
 * 所有的IP地址划分为 A,B,C,D,E五类
 * A类地址1.0.0.0~126.255.255.255;
 * B类地址128.0.0.0~191.255.255.255;
 * C类地址192.0.0.0~223.255.255.255;
 * D类地址224.0.0.0~239.255.255.255；
 * E类地址240.0.0.0~255.255.255.255
 * 私网IP范围是：
 * 10.0.0.0～10.255.255.255
 * 172.16.0.0～172.31.255.255
 * 192.168.0.0～192.168.255.255
 * 子网掩码为前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
 * 本题暂时默认以0开头的IP地址是合法的，比如0.1.1.2，是合法地址
 * 输入描述:
 * 多行字符串。每行一个IP地址和掩码，用~隔开。
 *
 * 输出描述:
 * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * 示例1
 * 输入
 * 10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 * 输出
 * 1 0 1 0 0 2 1
 */
public class RecognitionIP {

    private static int MASK_NUM;    //正确掩码数
    private static int IP_A_NUM;    //正确A地址ip数
    private static int IP_B_NUM;    //正确B地址ip数
    private static int IP_C_NUM;    //正确C地址ip数
    private static int IP_D_NUM;    //正确D地址ip数
    private static int IP_E_NUM;    //正确E地址ip数
    private static int PRI_IP_NUM;  //私有ip数
    private static int IP_ERROR_NUM;    //错误ip数
    private static boolean cont;
    private static int i;
    private static boolean mask_falg;

    public static void main(String[] args) throws IOException {

        try {
            cal();
        } catch (Exception e){
            System.out.println(IP_A_NUM+","+IP_B_NUM+","+IP_C_NUM+","+IP_D_NUM+","+IP_E_NUM+","+IP_ERROR_NUM+","+PRI_IP_NUM);

        }

    }

    public static void cal() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        while ((input = br.readLine())!=null){
            i = 0;
            cont = true;

            String[] ip_mask = input.split("~");//将ip与掩码分割开来
            String[] ip = ip_mask[0].split("\\.");
            String[] mask = ip_mask[1].split("\\.");
            check_mask(mask);
            if (mask_falg){
                MASK_NUM++;
            }
            else IP_ERROR_NUM++;
            System.out.println("mask_falg="+mask_falg);
            check_ip(ip);
            System.out.println(IP_A_NUM+","+IP_B_NUM+","+IP_C_NUM+","+IP_D_NUM+","+IP_E_NUM+","+IP_ERROR_NUM+","+PRI_IP_NUM);
        }
        System.out.println(IP_A_NUM+","+IP_B_NUM+","+IP_C_NUM+","+IP_D_NUM+","+IP_E_NUM+","+IP_ERROR_NUM+","+PRI_IP_NUM);
    }

    private static void check_ip(String[] ip) {

        if(ip.length==4&&!ip[0].equals("")&&!ip[1].equals("")&&!ip[2].equals("")&&!ip[3].equals("")){
            if (Integer.parseInt(ip[0])>=1 && Integer.parseInt(ip[0])<=126){
                if (Integer.parseInt(ip[0])==10){
                    PRI_IP_NUM++;
                }
                else IP_A_NUM++;
            }
            if (Integer.parseInt(ip[0])>=128 && Integer.parseInt(ip[0])<=191){
                if (Integer.parseInt(ip[0])==172&&Integer.parseInt(ip[1])>=16&&Integer.parseInt(ip[1])<=31){
                    PRI_IP_NUM++;
                }
                else IP_B_NUM++;
            }
            if (Integer.parseInt(ip[0])>=192 && Integer.parseInt(ip[0])<=223){
                if (Integer.parseInt(ip[0])==192 && Integer.parseInt(ip[1])==168){
                    PRI_IP_NUM++;
                }
                else IP_C_NUM++;
            }
            if (Integer.parseInt(ip[0])>=224 && Integer.parseInt(ip[0])<=239){
                IP_D_NUM++;
            }
            if (Integer.parseInt(ip[0])>=240 && Integer.parseInt(ip[0])<=255){
                IP_E_NUM++;
            }
        }
        else IP_ERROR_NUM++;
    }

    /**
     * 判断掩码是否正确
     * @param mask
     */
    private static void check_mask(String[] mask) {
        String[] array = mask;
        while (cont&&i<array.length-1){
            //当掩码的某一位为255时（前面都为255），判断下一位是否在255，255，252，248，240，224，192，128，0
            //如果在这之间，继续判断
            //
            if (array[i].equals("255")) {
                if (array[i + 1].equals("255") || array[i + 1].equals("254") || array[i + 1].equals("252") || array[i + 1].equals("248") ||
                        array[i + 1].equals("240") || array[i + 1].equals("224") || array[i + 1].equals("192") ||
                        array[i + 1].equals("128") || array[i + 1].equals("0")) {
                    mask_falg = true;
                    cont = true;
                } else {
                    mask_falg = false;
                    cont = false;
                    i = 3;
                    break;
                }
            }
            if (array[i].equals("254") || array[i].equals("252") || array[i].equals("248") || array[i].equals("240") ||
                        array[i].equals("224") || array[i].equals("192") || array[i].equals("128") || array[i].equals("0")) {
                if (array[i + 1].equals("0")) {
                    mask_falg = true;
                    cont = true;
                } else {
                    cont = false;
                    mask_falg = false;
                    i = 3;
                    break;
                }
            }
            i++;
        }
    }
}

