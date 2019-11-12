<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.ChooseDao" %>
<%@ page import="bean.Choose" %>
<html>
<head>
    <title>选课列表</title>
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
                <li><a href=""><%=session.getAttribute("name").toString()%></a></li>
                <li><a href="">退出</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
        <div class="sidebar col-sm-3 col-md-2">
            <ul class="nav nav-sidebar">
                <li><a href="students.jsp">学生列表</a></li>
                <li><a href="grades.jsp">院系列表</a></li>
                <li><a href="teachers.jsp">教师列表</a></li>
                <li><a href="subjects.jsp">课程列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="choose.jsp">选课列表<span
                        class="sr-only">(current)</span></a></li>
                <li><a href="scores.jsp">成绩列表</a></li>
            </ul>

        </div>
    </div>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="table-responsive" style="max-width: 1200px;margin: auto">
        <table align="center" class="table table-striped">
            <caption>所有选课信息</caption>
            <tr>
                <th>学生编号</th>
                <th>学生姓名</th>
                <th>课程编号</th>
                <th>课程名</th>
            </tr>
            <% ChooseDao sdao = new ChooseDao();
                ArrayList<Choose> chos = sdao.getChooseList();
                for (int i = 0; i < chos.size(); i++) {
                    Choose cho = (Choose) chos.get(i);
            %>
            <tr style="height: 52px;">
                <td style="padding-top: 17px;"><%=cho.getStudentNo() %>
                </td>
                <td style="padding-top: 17px;"><%=cho.getStudentName() %>
                </td>
                <td style="padding-top: 17px;"><%=cho.getSubjectNo() %>
                </td>
                <td style="padding-top: 17px;"><%=cho.getSubjectName() %>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>
