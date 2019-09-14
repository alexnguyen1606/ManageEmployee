<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
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
            <form:form action="/manage/autherization" method="post" modelAttribute="viewmodel" cssClass="form-group">
                <form:hidden path="user.id"></form:hidden>
               <c:forEach items="${viewmodel.roles}" var="role">
                   <form:label path="listIdRole">${role.code}</form:label>
                   <from:checkbox path="listIdRole" value="${role.id}" cssClass="form-control"/>
               </c:forEach>
                <button type="submit" class="btn btn-success">Update</button>
            </form:form>
        </div>
    </div>

</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>