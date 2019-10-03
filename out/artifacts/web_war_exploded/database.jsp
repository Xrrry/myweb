<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/9/29
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>DataBaseTest</title>
</head>
<body>
<%!
    private static final String URL = "jdbc:mysql://localhost:3306/car_rental_system";
    private static final String USERNAME = "root";
    private static final String PWD = "xiaoruoruo1999";
%>
<%
    Connection c = null;
    PreparedStatement s = null;
    ResultSet rs = null;
    boolean flag = false;
%>
<%
    try{
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection(URL, USERNAME, PWD);
        String sql = "select * from detail";
        s = c.prepareStatement(sql);
        rs = s.executeQuery();
        %>
    <table border=1px cellspacing=0px >
        <tr>
            <th>汽车编号</th>
            <th>车型</th>
            <th>车牌号</th>
            <th>出厂日期</th>
            <th>上次受检日期</th>
            <th>油耗</th>
            <th>公里数</th>
            <th>价格(元/天)</th>
            <th>租赁状态</th>
        </tr>
        <%while(rs.next()){ %>
        <tr>
            <td><%out.print(rs.getInt("CarNum"));%></td>
            <td><%out.print(rs.getString("Model"));%></td>
            <td><%out.print(rs.getString("LicenseNum"));%></td>
            <td><%out.print(rs.getString("ProductionDate"));%></td>
            <td><%out.print(rs.getString("LastInspectionDate"));%></td>
            <td><%out.print(rs.getFloat("FuelConsumption"));%></td>
            <td><%out.print(rs.getInt("Mileage"));%></td>
            <td><%out.print(rs.getInt("Price"));%></td>
            <td><%out.print(rs.getString("State"));%></td>
        </tr>
        <% } %>
    </table>
    <%
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }catch(SQLException e){
        e.printStackTrace();
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        try {
            if(rs != null)	rs.close();
            if(s != null)	s.close();
            if(c != null)	c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
</body>
</html>
