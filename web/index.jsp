<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script type="text/javascript">
    function validate() {
        var account = document.loginForm.account.value;
        var password = document.loginForm.password.value;

        if (account === "") {
            alert("账号不能为空");
            document.loginForm.account.focus();
            return;
        } else if (password === "") {
            alert("密码不能为空");
            document.loginForm.password.focus();
            return;
        }
        loginForm.submit();
    }
</script>
欢迎您登录：
<form name="loginForm" action="test.jsp" method="post">
    输入账号：<input name="account" type="text"><br>
    输入密码：<input name="password" type="password"><br>
    <input name="identity" type="radio" value="学生" checked>学生
    <input name="identity" type="radio" value="教师" >教师<BR>
    <input type="submit" onclick="validate()" value="登录">
</form>
</body>
</html>