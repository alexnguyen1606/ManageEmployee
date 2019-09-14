<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a href="/category/part/add"><i class="fa fa-plus fa-2x " style="margin-left: 10px;"></i></a>
    <br>
    <c:if test="${not empty param.message!=null}"><div class="col-lg-9 alert alert-${param.alert}">${param.message}</div></c:if>
    <c:if test="${not empty parts}">
        <table class="table table-hover table-striped ">
            <thead>
            <th>Part</th>
            <th>Department</th>
            <th>Description</th>
            <td>Tools</td>
            </thead>
            <tbody>
            <c:forEach items="${parts}" var="part">
                <tr>
                    <td>${part.name}</td>
                    <td>${part.department.name}</td>
                    <td>${part.description}</td>
                    <td>
                        <a href="/category/part/update/${part.id}"><i class="fa fa-edit"></i></a>
                        <a href="/category/part/delete/${part.id}" onclick="return confirm('Do you want to delete?')"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>