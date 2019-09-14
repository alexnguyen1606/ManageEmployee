<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Manage Employee</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/template/component/menu.jsp"></jsp:include>
<div class="right-panel" id="right-panel">
    <jsp:include page="/template/component/header.jsp"></jsp:include>
    <div class="container"><a href="/manage/user/add"><i class="fa fa-plus fa-2x "></i></a></div>
<c:if test="${not empty users}">
    <div class="container">
        <c:if test="${not empty param.message}"><div class="alert alert-${param.alert}">${param.message}</div></c:if>
        <table class="table table-hover">
            <thead>
            <th>Username</th>
            <th>Email</th>
            <th>Status</th>
            <th>Tool</th>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.email}</td>
                    <td>${user.status == 1 ? 'Enable' : 'disable'}</td>
                    <td>
                        <a href="/manage/user/update/${user.id}"><i class="fa fa-edit"></i></a>
                        <a href="/manage/user/delete/${user.id}" onclick="return confirm('Do you want to delete?')"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>