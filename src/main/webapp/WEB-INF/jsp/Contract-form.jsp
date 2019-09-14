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
        <h2>Contract </h2>
   <form:form action="/category/contract/add" method="post"  modelAttribute="viewmodel" cssClass="form-group">
       <form:label path="code">Code:</form:label>
       <form:input path="code" cssClass="form-control" required="required"></form:input>
       <form:label path="type">Type:</form:label>
       <form:input path="type" cssClass="form-control"></form:input>
       <form:label path="term">Term(months):</form:label>
       <form:input path="term" cssClass="form-control"></form:input>
       <form:label path="description">Description:</form:label>
       <form:input path="description" cssClass="form-control"></form:input>
       <button type="submit" class="btn btn-success">Add</button>
   </form:form>
    </div>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>