package com.tang.study.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)

 * 结果 （10， -10）
 *
 * 输入描述:
 * 一行字符串
 * 输出描述:
 * 最终坐标，以,分隔
 * 示例1
 * 输入
 *
 * 复制
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出
 *
 * 复制
 * 10,-10
 */
public class DirectionTools {

    private static Map<String,String> hashMap = new HashMap<>();
    private static int[] coordinate = new int[2];
    static {
        hashMap.put("A","A");
        hashMap.put("W","W");
        hashMap.put("S","S");
        hashMap.put("D","D");
    }

    public static int foo(int a ,int b)
    {
        if (b == 0) return 0;
        if (b %2 == 0) return foo(a+a,b/2);
        return foo(a+a,b/2)+a;
    }

    public static void main(String[] args) {
//        cal();
//        printf("%d"，foo(1,3));
        System.out.println((int)1/2);
        System.out.println(foo(1,3));



    }

    public static void cal(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] lists = scanner.nextLine().split(";");
            List<String> arrayList = check(lists);
            Iterator iter = arrayList.iterator();
            while (iter.hasNext()){
                String str = iter.next().toString();
                String direct = str.substring(0,1);
                int value = Integer.parseInt(str.substring(1));
                direction(direct,coordinate,value);
            }
            System.out.println(coordinate[0]+","+coordinate[1]);
            coordinate[0] = 0;
            coordinate[1] = 0;
        }
    }

    /**
     * 检查输入的数据是否符合要求
     * @param lists
     */
    public static List check(String[] lists){
        List<String> arrayList = new ArrayList<>();
        for (String list : lists) {
            try{
                Integer.parseInt(list.substring(1));
                if (list.length()>1 && list.length()<=3 && hashMap.get(list.substring(0,1))!=null){
                    arrayList.add(list);
                }
            }catch (Exception e){
                continue;
            }

        }
        return arrayList;
    }

    /**
     * 计算方向
     * @param direct
     * @param coordinate
     * @param mid
     * @return
     */
    public static void direction(String direct,int[] coordinate,int mid){
        if (direct.equals("A")){
            coordinate[0] = coordinate[0] - mid;
        }
        if (direct.equals("W")){
            coordinate[1] = coordinate[1] + mid;
        }
        if (direct.equals("D")){
            coordinate[0] = coordinate[0] + mid;
        }
        if (direct.equals("S")){
            coordinate[1] = coordinate[1] - mid;
        }
    }


}
