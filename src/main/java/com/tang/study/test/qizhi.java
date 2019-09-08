package com.tang.study.test;

import java.util.*;

public class qizhi {
    static class X_Y{
        public int x;
        public int y;

        public X_Y(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        new qizhi().solution();
//        Map<String,Integer> hash = new HashMap<>();
//        hash.put("13",2);
//        System.out.println(hash.get("ok")==3);


    }

    public void solution(){
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        line = line.replaceAll("\\[","").replaceAll("\\]","");

        String[] splits = line.split(",");
        int[][] matrix = new int[6][6];
        int index = 0;
        for (int i=1;i<5;i++){
            for (int j=1;j<5;j++){
                matrix[i][j] = Integer.valueOf(splits[index]);
                index++;
            }
        }
        List<X_Y> list = new ArrayList<>();
        line = scan.nextLine();
        line = line.replaceAll("\\[","").replaceAll("\\]","");
        String[] strs = line.split(",");
        for (int i=0;i<strs.length-1;i+=2){
            list.add(new X_Y(Integer.valueOf(strs[i]),Integer.valueOf(strs[i+1])));
        }

        cal(matrix,list);
        List<List<Integer>> res = new ArrayList<>();
        for (int i=1;i<5;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=1;j<5;j++){
                tmp.add(matrix[i][j]);
            }
            res.add(tmp);
        }

        System.out.println(res);
    }

    public void cal(int[][]matrix, List<X_Y> nodes){
        Map<String,Integer> hash = new HashMap<>();
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        for (int i=0;i<nodes.size();i++){
            hash.put(nodes.get(i).x+""+nodes.get(i).y,1);
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                try{
                    if (hash.get(i+""+j)==1){
                        matrix[i+1][j] = Math.abs(matrix[i+1][j]-1);
                        matrix[i][j+1] = Math.abs(matrix[i][j+1]-1);
                        matrix[i-1][j] = Math.abs(matrix[i-1][j]-1);
                        matrix[i][j-1] = Math.abs(matrix[i][j-1]-1);
                    }
                }catch (Exception e){;}

            }
        }
    }
}
