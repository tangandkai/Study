package com.tang.study.niukwwang.officer.array;

public class isNumeric {

    public static void main(String[] args) {

        System.out.println(solution(new char[]{'1','2','3','.','4','5'}));
    }

    /**123.45e+6
     * 串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
     * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * @param str
     * @return
     */
    public static boolean solution(char[] str){
//        String strs = String.valueOf(str).toLowerCase().trim();
        String strs = "123.45";
        try{
            System.out.println(Double.parseDouble(strs));
            return true;
        }catch (Exception e){
            try {
                if (strs.contains("e")){
                    String[] splits = strs.split("e");
                    Double.parseDouble(splits[0]);
                    if (splits.length==1)
                        return false;
                    int value = Integer.parseInt(splits[splits.length - 1]);
                    if(value==(int)Math.ceil(value)){
//                        System.out.println(value);
                        return true;
                    }
                }
            }catch (Exception e1){
                return false;
            }
            return false;
        }
    }
}
