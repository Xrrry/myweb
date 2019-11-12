<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="dao.StudentDao" %>
<%@ page import="bean.Students" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Subjects" %>
<%@ page import="dao.SubjectDao" %>
<%@ page import="dao.ScoreDao" %>
<%@ page import="bean.Scores" %>
<html>
<head>
    <title>成绩列表</title>
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
                <li><a href="students.jsp">学生列表</a></li>
                <li><a href="grades.jsp">院系列表</a></li>
                <li><a href="">教师列表</a></li>
                <li><a href="subjects.jsp">课程列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">选课列表</a></li>
                <li class="active"><a href="scores.jsp">成绩列表<span
                        class="sr-only">(current)</span></a></li>
            </ul>

        </div>
    </div>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="table-responsive" style="max-width: 1200px;margin: auto">
        <table align="center" class="table table-striped">
            <caption>所有成绩信息</caption>
            <tr>
                <th>姓名</th>
                <th>课程</th>
                <th>成绩</th>
                <th>考试时间</th>
            </tr>
            <%  ScoreDao sdao = new ScoreDao();
                ArrayList<Scores> scos = sdao.getScoreList();
                for (int i = 0; i < scos.size(); i++) {
                    Scores sco = (Scores) scos.get(i);
            %>
            <tr style="height: 52px;">
                <td style="padding-top: 17px;"><%=sco.getStudentName() %>
                </td>
                <td style="padding-top: 17px;"><%=sco.getSubjectName() %>
                </td>
                <td style="padding-top: 17px;"><%=sco.getScore() %>
                </td>
                <td style="padding-top: 17px;"><%=sco.getExamDate() %>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
</body>
</html>
