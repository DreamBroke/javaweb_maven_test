<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE>
<html>
<head>
<title>JavaWebTest</title>
</head>
<body>
<h2>Hello World!</h2>
<hr/>
<table border="1px">
    <tr>
        <td>ID</td>
        <td>名称</td>
        <td>价格</td>
        <td>数量</td>
    </tr>
    <c:choose>
        <c:when test="${empty list }">
            <tr>
                <td colspan="3">没有符合条件的数据</td>
            </tr>
        </c:when> 
        <c:otherwise>
            <c:forEach items="${list }" var="commodity">
                <tr>
                    <td>￥${commodity.id }</td>
                    <td>￥${commodity.name }</td>
                    <td>￥${commodity.price }</td>
                    <td>￥${commodity.quantity }</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
