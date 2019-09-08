package com.tang.study.niukwwang.officer.Str;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）
 * 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 *
 */
public class simpliyPath {

    public static void main(String[] args) {

        String path = "/../";
        String res = new simpliyPath().solution(path);
        System.out.println(res);
    }

    public String solution(String path){
        if (path == null || path.length()==0)
            return path;
        StringBuilder builder = new StringBuilder();
        int pcount = 0;
        String[] splits = path.split("/");
        for (int i=splits.length-1;i>=0;i--){
            if (splits[i].equals(".") || splits[i]==null){
                continue;
            }
            if (splits[i].equals("..")){
                pcount++;
                continue;
            }
            if (pcount>0){
                continue;
            }
            builder.insert(0,splits[i]);
            builder.insert(0,"/");
        }
        return builder.length()==0?"/":builder.toString();
    }
}
