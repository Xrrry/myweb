<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script type="text/javascript">
    // var arg0 = "欢迎使用JavaScript";
    // print(arg0)
    // function print(arg1) {
    //   window.alert(arg1);
    // }

    // str = window.prompt("请输入一个字符串");
    // window.alert(str);

    function validate() {
        account = document.loginForm.account.value;
        password = document.loginForm.password.value;

        if (account === "") {
            alert("账号不能为空");
            document.loginForm.account.focus();
            return;
        } else if (password === "") {
            alert("密码不能为空");
            document.loginForm.password.focus();
            return;
        }
        window.location.href = "test.jsp?account="+ account + "&password=" + password;
    }
</script>
欢迎您登录：
<form name="loginForm">
    输入账号：<input name="account" type="text"><br>
    输入密码：<input name="password" type="password"><br>
    <input type="button" onclick="validate()" value="登录">
</form>
</body>
</html>