<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 1/8/2026
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/students/add" method="post" modelAttribute="student">
    <h1>Add new student</h1>
    Id:
    <form:input path="id"/><br>
    Name:
    <form:input path="name"/><br>
    Gender:
    <form:radiobutton path="gender" value="1"/>Male
    <form:radiobutton path="gender" value="0"/>Female<br>
    Subject:
    <form:checkboxes path="subjects" items="${subjects}"/><br>
    <form:select path="className">
        <option>--Chọn lớp---</option>
        <form:option value="C07">C07</form:option>
        <form:option value="C09">C09</form:option>
        <form:option value="C08">C08</form:option>
    </form:select><br>
    <button>Save</button>
</form:form>

</body>
</html>
