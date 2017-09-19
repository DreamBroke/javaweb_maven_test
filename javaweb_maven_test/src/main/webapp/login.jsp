<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>JavaWebTest</title>
<link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.center {
    text-align: center;
}
</style>
</head>
<body>
    <h2 class="center">登录页面</h2>
    <hr/>
    <form action="login" class="form-group center container" method="Post">
	    <div class="form-group">
			<label for="username">用户名</label>
			<input class="form-control" id="username" name="username">
	    </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input class="form-control" id="password" name="password" type="password">
        </div>
        <button class="btn btn-primary" type="submit">确定</button>
        <button type="reset" class="btn btn-default">重置</button>
    </form> 
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

$("#username").focus();

if ("${msg}") {
	alert("${msg}");
	location.href=location.href;
}

</script>
</body>
</html>
