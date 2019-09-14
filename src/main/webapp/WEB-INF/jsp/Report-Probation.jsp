<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <c:if test="${not empty employees}">
    <div class="container">
        <div>Danh sách nhân viên thử việc</div>
        <div><a href="/report/download/probation">Download</a></div>
        <table class="table table-hover">
            <thead>
            <th>FullName</th>
            <th>Department</th>
            <th>Type</th>
            <td>Number Insurence</td>
            <td>Address</td>
            <td>Gender</td>
            <td>Birth Day</td>
            <td>Phone Number</td>
            </thead>
            <tbody>
            <c:forEach items="${employees}" var="staff">
            <tr>
                <td>${staff.fullName}</td>
                <td>${staff.department.name}</td>
                <td><c:choose>
                    <c:when test="${staff.type==0}">Nhân viên học việc</c:when>
                    <c:when test="${staff.type==1}">Nhân viên thử việc</c:when>
                    <c:when test="${staff.type==2}">Nhân viên chính thức</c:when>
                </c:choose></td>
                <td>${staff.numberInsurence}</td>
                <td>${staff.address}</td>
                <td>${staff.gender == 1 ? "Male" : "Female"}</td>
                <td><fmt:formatDate value="${staff.birthDay}" pattern="dd-MM-yyyy"/></td>
                <td>${staff.phoneNumber}</td>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </c:if>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>