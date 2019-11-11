<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="bean.Students" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dashboard.css"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">学生管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href=""><%=session.getAttribute("account").toString()%></a></li>
                <li><a href="">退出</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
        <div class="sidebar col-sm-3 col-md-2">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="students.jsp">学生列表<span
                        class="sr-only">(current)</span></a></li>
                <li><a href="grades.jsp">院系列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">课程列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">成绩列表</a></li>
            </ul>

        </div>
    </div>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="table-responsive" style="max-width: 1200px;margin: auto">
        <table align="center" class="table table-striped">
            <caption>所有学生信息</caption>
            <tr>
                <th>学生编号</th>
                <th>姓名</th>
                <th>邮箱</th>
                <th>电话</th>
                <th>学号</th>
                <th>地址</th>
                <th>年级</th>
                <th>性别</th>
            </tr>
            <% StudentDao sdao = new StudentDao();
                ArrayList<Students> stus = sdao.getStudentList();
                for (int i = 0; i < stus.size(); i++) {
                    Students stu = (Students) stus.get(i);
            %>
            <tr style="height: 52px;">
                <td style="padding-top: 17px;"><%=stu.getStudentNo() %>
                </td>
                <td style="padding-top: 17px;"><%=stu.getUserName() %>
                </td>
                <td style="padding-top: 17px;"><%=stu.getEmail() %>
                </td>
                <td style="padding-top: 17px;"><%=stu.getPhone() %>
                </td>
                <td style="padding-top: 17px;"><%=stu.getIdCardNo() %>
                </td>
                <td style="padding-top: 17px;"><%=stu.getAddress() %>
                </td>
                <td style="padding-top: 17px;"><%=stu.getGradeNo() %>
                </td>
                <td style="padding-top: 17px;"><% if(stu.getGender()==0){
                    out.print('男');
                }
                else {
                    out.print('女');
                }%>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>
