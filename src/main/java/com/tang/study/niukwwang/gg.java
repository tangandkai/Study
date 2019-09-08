package com.tang.study.niukwwang;

import java.util.Scanner;

public class gg {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String S = scan.nextLine();
        String T = scan.nextLine();
        System.out.println(new gg().cal(S,T));

    }

    /**
     * ababa
     * aba
     * 2
     * @param S
     * @param T
     * @return
     *
     * 输入样例3
     * a?a?a
     * abab
     * 输出样例3
     * 1
     */
    public int cal(String S,String T){
        int count = 0;
        int slength = S.length();
        int tlength = T.length();
        for (int i=0;i<slength;i++){
            if (S.substring(i,i+tlength>=slength?slength:i+tlength).equals(T)){
                count++;
            }
            //(!S.substring(i,i+tlength>=slength?slength:i+tlength).equals(T))
            else{
                String stmp = S.substring(i,i+tlength>=slength?slength:i+tlength);
                int Ctmp = 0;
                for (int j=0;j<stmp.length();j++){
                    if (stmp.charAt(j)==T.charAt(j) ||stmp.charAt(j)=='?'){
                        Ctmp++;
                    }
                    if (Ctmp==T.length()){
                        count++;
                    }
                }
            }
        }
        return count;

    }
}
