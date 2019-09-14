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
    <c:if test="${not empty trainingEmployee}">
        <div class="container">
            <div>Training Employee</div>
            <table class="table table-hover">
                <thead>
                <th>Course Code</th>
                <th>Course Name</th>
                <th>Total Time Training</th>
                <th>End Date</th>
                <th>Employee Name</th>
                <th>Result</th>
                </thead>
                <c:forEach items="${trainingEmployee}" var="item">
                    <tr>
                        <td>${item.training.code}</td>
                        <td>${item.training.name}</td>
                        <td>${item.training.totalTime} Months</td>
                        <td><fmt:formatDate value="${item.endDate}" pattern="dd-MM-yyyy"></fmt:formatDate></td>
                        <td>${item.employee.fullName}</td>
                        <td>${item.result}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>