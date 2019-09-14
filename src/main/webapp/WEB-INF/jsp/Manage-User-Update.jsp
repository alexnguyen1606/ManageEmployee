<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <div class="container">
        <div class="col-lg-9">
            <c:if test="${not empty param.message}"><div class="alert alert-${param.alert}">${param.message}</div></c:if>

            <form:form action="/manage/user/update" modelAttribute="viewmodel" method="post" cssClass="form-group">
                <div>Update:${viewmodel.user.username}</div>
                <form:hidden path="user.username"></form:hidden>
                <form:hidden path="user.id"></form:hidden>
                <form:label path="user.password">Password:</form:label>
                <form:password path="user.password" cssClass="form-control" required="required"></form:password>
                <form:label path="user.email">Email:</form:label>
                <form:input path="user.email" type="email" required="required" cssClass="form-control"></form:input>
                <form:label path="user.status"></form:label>
                <form:select path="user.status" cssClass="form-control">
                    <form:option value="1">Enable</form:option>
                    <form:option value="0">Disable</form:option>
                </form:select>
                <button type="submit" class="btn btn-success">Update</button>
            </form:form>
        </div>
    </div>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>