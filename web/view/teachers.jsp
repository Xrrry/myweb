<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.TeacherDao" %>
<%@ page import="bean.Teachers" %>
<html>
<head>
    <title>教师列表</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../css/dashboard.css"/>
</head>
<body>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认</h4>
            </div>
            <div class="modal-body">
                确认删除?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" onclick="go()">删除</button>
            </div>
        </div>
    </div>
</div>
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
                <li><a href="<%=request.getContextPath()%>/view/login.jsp">退出</a></li>            </ul>
        </div>
    </div>
</nav>


<div class="container-fluid">
    <div class="row">
        <div class="sidebar col-sm-3 col-md-2">
            <ul class="nav nav-sidebar">
                <li><a href="students.jsp">学生列表</a></li>
                <li><a href="grades.jsp">院系列表</a></li>
                <li class="active"><a href="teachers.jsp">教师列表<span
                        class="sr-only">(current)</span></a></li>
                <li><a href="subjects.jsp">课程列表</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="choose.jsp">选课列表</a></li>
                <li><a href="scores.jsp">成绩列表</a></li>
            </ul>

        </div>
    </div>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div class="table-responsive" style="max-width: 1200px;margin: auto">
        <table align="center" class="table table-striped">
            <caption>所有教师信息</caption>
            <tr>
                <th>教师编号</th>
                <th>姓名</th>
                <th>所属专业名称</th>
                <th>操作</th>
            </tr>
            <% TeacherDao tdao = new TeacherDao();
                ArrayList<Teachers> teas = tdao.getTeacherList();
                for (int i = 0; i < teas.size(); i++) {
                    Teachers tea = (Teachers) teas.get(i);
            %>
            <tr style="height: 52px;">
                <td style="padding-top: 17px;"><%=tea.getTeacherNo() %>
                </td>
                <td style="padding-top: 17px;"><%=tea.getTeacherName() %>
                </td>
                <td style="padding-top: 17px;"><%=tea.getGradeName() %>
                </td>
                <td>
                    <a href="">
                        <button type="button"
                                class="btn btn-primary">修改
                        </button>
                    </a>
                    <button id="todelete" type="button" class="btn btn-danger" data-toggle="modal"
                            data-target="#myModal" onclick="aaa(<%=tea.getTeacherNo()%>)" value="<%=tea.getTeacherNo()%>">
                        删除
                    </button>
                </td>
            </tr>
            <% } %>
        </table>
    </div>
</div>
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
    var id = 0;
    function aaa(e) {
        console.log(e);
        id = e;
    }
    function go() {
        window.location.href = '<%=request.getContextPath()%>/TeacherServlet?method=delete&id=' + id;
    }
</script>
</body>
</html>
