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
    private static final String URL = "jdbc:mysql://localhost:3306/Student_System";
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
        String sql = "select * from students";
        s = c.prepareStatement(sql);
        rs = s.executeQuery();
        %>
    <table border=1px cellspacing=0px >
        <tr>
            <th>姓名</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>学号</th>
            <th>地址</th>
            <th>年级</th>
        </tr>
        <%while(rs.next()){ %>
        <tr>
            <td><%out.print(rs.getString("UserName"));%></td>
            <td><%out.print(rs.getString("Email"));%></td>
            <td><%out.print(rs.getString("Phone"));%></td>
            <td><%out.print(rs.getString("IdCardNO"));%></td>
            <td><%out.print(rs.getString("Address"));%></td>
            <td><%out.print(rs.getInt("GradeNO"));%></td>
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
