<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <div class="col-lg-8">
        <h2>Employee</h2>
        <form:form action="/hr/update" method="post"  modelAttribute="viewmodel" cssClass="form-group">
            <form:hidden path="employee.id"></form:hidden>
            <form:label path="employee.fullName">FullName:</form:label>
            <form:input path="employee.fullName" cssClass="form-control" required="required"></form:input>
            <form:label path="departmentId">Department</form:label>
            <form:select path="departmentId" cssClass="form-control">
                <c:forEach var="item" items="${department}">
                    <form:option value="${item.id}">${item.name}</form:option>
                </c:forEach>
            </form:select>
            <form:label path="employee.type">Type:</form:label>
            <form:select path="employee.type" cssClass="form-control">
                <form:option value="2">Nhân viên chính thức</form:option>
                <form:option value="1">Nhân viên thử việc</form:option>
                <form:option value="0">Nhân viên học viện</form:option>
            </form:select>
            <form:label path="employee.numberInsurence">Number Of Insurence</form:label>
            <form:input path="employee.numberInsurence" cssClass="form-control"></form:input>
            <form:label path="employee.address">Address:</form:label>
            <form:input path="employee.address" cssClass="form-control"></form:input>
            <form:label path="employee.gender">Gender:</form:label>
            <form:select path="employee.gender" cssClass="form-control">
                <form:option value="1">Male</form:option>
                <form:option value="0">Female</form:option>
            </form:select>
            <form:label path="birthDayString">Birth Day(01-01-2010):</form:label>
            <form:input path="birthDayString" cssClass="form-control"></form:input>
            <form:label path="employee.phoneNumber">Phone Number</form:label>
            <form:input path="employee.phoneNumber" cssClass="form-control"></form:input>
            <form:select path="employee.status">
                <form:option value="1">Enable</form:option>
                <form:option value="0">Disable</form:option>
            </form:select>
            <button type="submit" class="btn btn-success">Add</button>
        </form:form>
    </div>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>