package com.tang.study.test;


import java.util.*;

public class swap implements Cloneable{

    public static int a = 8;
    public static int b = 9;

    private Map hashmap = new HashMap();
    private Map hastable = new Hashtable();
    private Map treemap = new TreeMap();

    private Set treeset = new TreeSet();
    private Set hashset = new HashSet();
    private Set linkset = new LinkedHashSet();

    private List arraylist = new ArrayList();
    private List linklist = new LinkedList();
    private List vector = new Vector();

    public static void main(String[] args) {
        swap s = new swap();
        s.cai_1(8);
        Integer x =9;
        Integer y =x;
        y ++;
//        x++;
        System.out.println(x);
        System.out.println(y);

        Test test_1 = new Test();
        Test test_2 = test_1;
        test_1.bb=9;
        test_2.bb=19;
//        test_2.setAa(1);
        System.out.println(test_1.bb);
        System.out.println(test_2.bb);

        System.out.println(test_1.n);
        test_1.builder.append("word");

        Integer nn = 10;
        String re = Integer.toBinaryString(nn);
        System.out.println(re);
        int count = 0;
        char[] array = re.toCharArray();
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
            if (array[i]=='1'){
                count++;
            }
        }
        System.out.println(count);
    }

    public void cal(int a){
        a++;
        System.out.println(a);
    }

    public void cai_1(int num){
        int n = num >> 1;
        System.out.println(n);
    }

    @Override
    protected Object clone() {
        Object object = null;
        try{
            object = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return object;
    }
}

class Test{
    public static final int n = 11;
    public static StringBuilder builder = new StringBuilder("hello");
    public static int aa = 9;
    public int bb = 1;
    public void cc(int a){

    }

    public void cc(String b){}
    public void cc(int a,String b){}
    public void cc(String b,int a){}
}
