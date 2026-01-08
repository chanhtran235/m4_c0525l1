<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 1/6/2026
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách</h1>
<h2>${mess}</h2>
<a href="students/add">Thêm mới</a>
<table>
    <tr>
        <td>STT</td>
        <td>ID</td>
        <td>Name</td>
        <td>Detail-requestParam</td>
        <td>Detail-pathVariable</td>
    </tr>
    <c:forEach items="${studentList}" varStatus="status" var="student">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>
                <a href="/students/detail?id=${student.id}">Detail1</a>
            </td>
            <td>
                <a href="/students/${student.id}/detail">Detail1</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
