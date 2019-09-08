package com.tang.yaxin;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {

    public static void main(String[] args) throws ParseException {
        String str = "select \"data_time\" from HBASE.TEST_TEST where \"data_time\" > \"hh\" limit 10";
        System.out.println(str);


        String sql = "select \"{0}\" from HBASE.TEST_TEST where \"{0}\" > {1}";

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
//
//        Date date = dateFormat.parse("2019-09-10 12:08:56");
//        System.out.println(date.getTime());
//        System.out.println(date.toString());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = "2019-09-09 16:00:00.000";
//        timestamp.
        timestamp = Timestamp.valueOf(time);
//        System.out.println(timestamp);

        sql =  MessageFormat.format(sql,"data_time",timestamp);
        System.out.println(sql);


        String sql1 = String.format("select \"%s\" from HBASE.TEST_TEST where \"%s\" > \"%d\"","");

    }
}
