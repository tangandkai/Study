package com.tang.yaxin;

import java.sql.*;
import java.text.MessageFormat;
import java.util.Properties;

public class phoenixApp {

    public static void main(String[] args) throws SQLException {

        String sql = "select * from HBASE.TEST_TEST where \"data_time\" > to_timestamp('2019-09-10 00:12:00')-0.333333333";
        String time = "2019-09-09 16:00:00";
        Timestamp timestamp = Timestamp.valueOf(time);
//        sql = MessageFormat.format(sql,"data_time");

        Properties properties = new Properties();
        properties.setProperty("phoenix.query.timeoutMs", "10000");
        properties.setProperty("hbase.rpc.timeout","10000");
        properties.setProperty("hbase.client.scanner.timeout.period","10000");
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            System.out.println("phoenix驱动加载完成");
        }catch (ClassNotFoundException e){
            System.out.println("phoenix驱动加载失败");
        }

        Connection conn = DriverManager.
                getConnection("jdbc:phoenix:10.21.13.86,10.21.13.87,10.21.13.88:2181:/hbase-unsecure","","");
//        conn.isValid(45);
        System.out.println("获取到连接.......");
        System.out.println(conn.getMetaData().getCatalogs());
        PreparedStatement stamt = conn.prepareStatement(sql);
        ResultSet result = stamt.executeQuery();
        while(result.next()) {
            System.out.println("id="+result.getInt("id"));
            System.out.println("data_time_timestamp="+result.getTimestamp("data_time"));
            System.out.println("data_time_timestampASString="+result.getString("data_time"));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        result.close();
        stamt.close();
        conn.close();
    }
}
