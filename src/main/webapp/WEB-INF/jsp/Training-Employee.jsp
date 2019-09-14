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
    <a href="/category/training/add"><i class="fa fa-plus fa-2x " style="margin-left: 10px;"></i></a>
    <br>
    <c:if test="${not empty param.message!=null}"><div class="col-lg-9 alert alert-${param.alert}">${param.message}</div></c:if>
    <c:if test="${not empty training}">
        <table class="table table-hover table-striped ">
            <thead>
            <th>Code</th>
            <th>Name</th>
            <th>Time Training</th>
            <th>Description</th>
            <th>Status</th>
            <th>Tool</th>
            </thead>
            <tbody>
            <c:forEach items="${training}" var="train">
                <tr>
                    <td>${train.code}</td>
                    <td>${train.name}</td>
                    <td>${train.totalTime} months</td>
                    <td>${train.description}</td>
                    <td>${train.status == 1 ? "Enable" : "Disable"}</td>
                    <td>
                        <a href="/trainingemployee/${train.id}">List Employee</a>
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