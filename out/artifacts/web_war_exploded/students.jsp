<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="bean.Students" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Students</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/dashboard.css"/>
</head>
<body>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <div class="table-responsive" style="max-width: 1200px;margin: auto">
            <table align="center" class="table table-striped">
                <caption>所有学生信息</caption>
                <tr>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>学号</th>
                </tr>
                <%  StudentDao sdao = new StudentDao();
                    ArrayList<Students> stus = sdao.getStudentList();
                    for(int i=0;i<stus.size();i++) {
                        Students stu = (Students)stus.get(i);
                %>
                <tr style="height: 52px;">
                    <td style="padding-top: 17px;"><%=stu.getUserName() %></td>
                    <td style="padding-top: 17px;"><%=stu.getPhone() %></td>
                    <td style="padding-top: 17px;"><%=stu.getIdCardNo() %></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>
</body>
</html>
