package com.tang.study.test;

public class InnerClass {
    private String name;
    private static String address;
    private String ws ;

    private String getName(){
        return name;
    }

    InnerClass(String name){
        this.name = name;
    }

    public void tt(){
        staticInnerClass.aa();
        new staticInnerClass("").cc();
    }
    public static void tt1(){}
    public static class staticInnerClass{
        public String name;
        public staticInnerClass(String name){
            this.name = name;
        }
        public static String aa(){

            String name = "hahah";
            return name;
        }
        public String cc(){
            new staticInnerClass("").cc();
            new staticInnerClass("").as();
            return name;
        }
        public String as(){
            return address;
        }
    }

    public class commonInnerClass{
//        public static String aaaa;
        public String bb(){
            staticInnerClass.aa();
            new staticInnerClass("").cc();
            new staticInnerClass("").as();
            return name;
        }
        public  String gg(){
            tt1();
            tt();
            return "this is method gg";
        }
    }

    public static void main(String[] args) {
        String nameA = new InnerClass("tang").getName();
        String nameB = new InnerClass("wen").new commonInnerClass().bb();
        String value = new InnerClass("gg").new commonInnerClass().gg();
        System.out.println(value);
        String nameC = InnerClass.staticInnerClass.aa();
        String nameD = new InnerClass.staticInnerClass("kai").cc();
        System.out.println("nameA"+nameA+"\n"+"nameB"+nameB+"\n"+
                "nameC"+nameC+"\n"+"nameD"+nameD);
    }
}
