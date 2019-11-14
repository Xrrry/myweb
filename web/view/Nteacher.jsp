<%@ page import="bean.Teachers" %>
<%@ page import="dao.GradeDao" %>
<%@ page import="bean.Grades" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师信息</title>
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
                <li><a href="students.jsp">学生列表</a></li>
                <li class="active"><a href="grades.jsp">院系列表</a></li>
                <li><a href="teachers.jsp">教师列表<span
                        class="sr-only">(current)</span></a></li>
                <li><a href="subjects.jsp">课程列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="choose.jsp">选课列表</a></li>
                <li><a href="scores.jsp">成绩列表</a></li>
            </ul>
        </div>
        <div>
            <form method="post" action="<%=request.getContextPath()%>/TeacherServlet?method=insert">
                <%
                    Teachers t =(Teachers) session.getAttribute("teacher");
                %>
                <h2 class="form-signin-heading"
                    style="max-width: 400px;margin: auto;padding-left: 12px;padding-top: 50px;padding-bottom: 20px;">
                    添加教师信息
                </h2>
                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">名称</span>
                    <input name="name" type="text" class="form-control" placeholder="名称" required><br>
                </div>

                <div class="input-group form-signin" style="max-width: 400px;">
                    <span class="input-group-addon">院系</span>
                    <select name="gradename" class="form-control">
                        <%
                            GradeDao gdao = new GradeDao();
                            ArrayList<Grades> gras = gdao.getGradeList();
                            for (int i = 0; i < gras.size(); i++) {
                                Grades gra = (Grades) gras.get(i);
                        %>
                        <option><%=gra.getGradeName()%></option>
                        <% } %>
                    </select>
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