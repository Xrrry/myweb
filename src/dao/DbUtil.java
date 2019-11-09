package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

    private String dbUrl = "jdbc:mysql://localhost:3306/Student_System?useUnicode=true&characterEncoding=utf8";
    private String dbUser = "root";
    private String dbPassword = "xiaoruoruo1999";
    private String jdbcName = "com.mysql.jdbc.Driver";
    private Connection connection = null;
    public Connection getConnection(){
        try {
            Class.forName(jdbcName);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("数据库链接成功！");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("数据库链接失败！");
            e.printStackTrace();
        }
        return connection;
    }

    public void closeCon(){
        if(connection != null)
            try {
                connection.close();
                System.out.println("数据库链接已关闭！");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DbUtil dbUtil = new DbUtil();
        dbUtil.getConnection();
    }

}