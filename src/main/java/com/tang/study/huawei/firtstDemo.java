package com.tang.study.huawei;


import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

class CreateStudy{

    private static CreateStudy createStudy = null;
    private static ArrayList<Integer> arrayList= null;
    private CreateStudy(){}

    /**
     * 创建单例
     * @return
     */
    public static CreateStudy getInstance(){
        if (null !=createStudy){
            return createStudy;
        }
        return new CreateStudy();
    }

    /**
     * 将给出的学生成绩存放到arrayList
     * 为后续计算准备
     * @param Grades
     */
    public void initGrade(String Grades){
        arrayList = new ArrayList<Integer>();
        String[] listGrades = Grades.split(" ");
        for (String grade:listGrades){
            arrayList.add(Integer.parseInt(grade));
        }
    }

    /**
     * 查询在给定的学生id中的成绩最高的分数
     * @param firstIndex
     * @param secondIndex
     */
    public Integer inquryGrades(int firstIndex,int secondIndex){
        int lastIndex = secondIndex;

        int index = firstIndex-1>0?firstIndex-1 : 0;
        int middex =0;
        Integer maxGrade = 0;
        Integer minGrade = 0;
        if (firstIndex>secondIndex){
            middex = firstIndex;
            firstIndex = secondIndex;
            secondIndex = middex;
        }
        if (secondIndex>=arrayList.size()){
            lastIndex = arrayList.size();
        }
        for (int i=index;i<lastIndex;i++){

            minGrade = arrayList.get(i);
            if (minGrade>maxGrade){
                maxGrade=minGrade;
            }
        }

//        System.out.println(maxGrade);
        return maxGrade;
    }

    public void upGrades(int IndexA,Integer grade){

        int indexA = IndexA-1>=0?IndexA-1 : 0;
        arrayList.set(indexA,grade);
    }
    public void getGrades(){
        if (null==arrayList){
            throw new RuntimeException("please init the grade first:initGrade(String Grades)");
        }

        System.out.println(arrayList.toString());
    }
}
public class firtstDemo {

    public static void main(String[] args) {

        CreateStudy instance = CreateStudy.getInstance();
        ArrayList array = Calculate(instance);
        ListIterator iters = array.listIterator();
        while (iters.hasNext()){
            System.out.println(iters.next());
        }

    }

    public static ArrayList Calculate(CreateStudy instance){
        Scanner scanner = new Scanner(System.in);
        ArrayList list = new ArrayList();
        int n = 0;
        int flag = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] arrayLine = line.split(" ");

            n++;
            if (n==1){
//                System.out.println("diyici");
                flag = Integer.parseInt(arrayLine[1]);
            }
            if (!(arrayLine[0].trim().equals("U")) && !(arrayLine[0].trim().equals("Q")) && n!=1){
//                System.out.println("开始输入成绩.........");
                instance.initGrade(line);
//                instance.getGrades();
            }
            if (arrayLine[0].trim().equals("U")){
//                System.out.println("开始更新成绩........");
                instance.upGrades(Integer.parseInt(arrayLine[1]),Integer.parseInt(arrayLine[2]));
            }
            if (arrayLine[0].trim().equals("Q")){
//                System.out.println("开始查询最高成绩");
                list.add(instance.inquryGrades(Integer.parseInt(arrayLine[1]),Integer.parseInt(arrayLine[2])));

            }
            if (n==flag+2){
//                ListIterator iters = list.listIterator();
//                while (iters.hasNext()){
//                    System.out.println(iters.next());
//                }
                return list;
            }
        }
        return null;
    }
}
