<%@ page import="bean.Students" %>
<%@ page import="bean.Grades" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.GradeDao" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/11/13
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生信息</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dashboard.css"/>
    <link rel="stylesheet" type="text/css" href="../css/signin.css"/>

</head>
<body style="background-color:#fff">
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
                <li>
                    <a href=""><%=session.getAttribute("name").toString()%>
                    </a>
                </li>
                <li><a href="<%=request.getContextPath()%>/view/login.jsp">退出</a></li>
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
                <li><a href="teachers.jsp">教师列表</a></li>
                <li><a href="subjects.jsp">课程列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="choose.jsp">选课列表</a></li>
                <li><a href="scores.jsp">成绩列表</a></li>
            </ul>
        </div>
        <div>
            <form method="post" action="<%=request.getContextPath()%>/StudentServlet?method=insert">
                <h2 class="form-signin-heading"
                    style="max-width: 400px;margin: auto;padding-left: 12px;padding-top: 50px;padding-bottom: 20px;">
                    修改学生信息
                </h2>
                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">姓名</span>
                    <input name="name" type="text" class="form-control" placeholder="姓名" required><br>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">性别</span>
                    <select name="gender" class="form-control">
                        <option>男</option>
                        <option>女</option>
                    </select>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">院系</span>
                    <select name="gradename" class="form-control">
                        <%
                            GradeDao gdao = new GradeDao();
                            ArrayList<Grades> gras = gdao.getGradeListAll();
                            for (int i = 0; i < gras.size(); i++) {
                                Grades gra = (Grades) gras.get(i);
                        %>
                        <option><%=gra.getGradeName()%></option>
                        <% } %>
                    </select>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">邮箱</span>
                    <input name="email" type="text" class="form-control" placeholder="邮箱" required><br>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">电话</span>
                    <input name="phone" type="text" class="form-control" placeholder="电话" required><br>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">学号</span>
                    <input name="idno" type="text" class="form-control" placeholder="学号" required><br>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">地址</span>
                    <input name="address" type="text" class="form-control" placeholder="地址" required><br>
                </div>
                
                <input style="margin-top:15px;max-width: 370px;" id="btn-submit" type="submit"
                       class="btn btn-big btn-block form-signin" value="添加">
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="../js/dropdown.js" ></script>
<script type="text/javascript" src="../js/tooltip.js"></script>
<script type="text/javascript" src="../js/popover.js"></script>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>
