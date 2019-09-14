<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="now" value="<%= new java.util.Date()%>" />
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
    <div class="container">
        FullName : ${employee.fullName}
        <br>
        Department: ${employee.department.name}
        <br>
        Number Insurence: ${employee.numberInsurence}
        <br>
        <c:choose>
            <c:when test="${employee.type==0}">Nhân viên học việc</c:when>
            <c:when test="${employee.type==1}">Nhân viên thử việc</c:when>
            <c:when test="${employee.type==2}">Nhân viên chính thức</c:when>
        </c:choose>
    </div>
    <c:if test="${not empty contractEmployee}">
        <h2>Contract Currently</h2>
        <table class="table table-hover">
            <thead>
            <th>Code:</th>
            <th>Term:</th>
            <th>Start Date:</th>
            <th>End Date:</th>
            <th>Status:</th>
            <th>Description:</th>
            </thead>
            <tbody>
            <c:forEach items="${contractEmployee}" var="item">
                <tr>
                    <td>${item.contract.code}</td>
                    <td>${item.contract.term}</td>
                    <td> <fmt:formatDate pattern="dd-MM-yyyy" value="${item.startDate}"/></td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${item.endDate}"/></td>
                    <td><c:if test="${item.endDate > now }">Còn hiệu lực</c:if>
                        <c:if test="${item.endDate < now}">Hết hiệu lực</c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <div class="col-lg-9">
        <form:form modelAttribute="viewmodel" action="/contractemployee" method="post" cssClass="form-group">
            <form:hidden path="employeeId"></form:hidden>
            <form:label path="startDateString">Start Date(dd-MM-yyyy):</form:label>
            <form:input path="startDateString" cssClass="form-control"></form:input>
            <form:label path="contractId">Contract</form:label>
            <form:select path="contractId" cssClass="form-control">
                <c:forEach var="item" items="${contract}">
                    <form:option value="${item.id}">${item.code}</form:option>
                </c:forEach>
            </form:select>
            <button type="submit" class="btn btn-success">Add</button>
        </form:form>
    </div>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>