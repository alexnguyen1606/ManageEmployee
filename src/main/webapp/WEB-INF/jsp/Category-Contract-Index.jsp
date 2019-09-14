<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${cookie.USERNAME.value==null}"><c:redirect url="/login"></c:redirect></c:if>
<html
<head>
    <meta charset="ISO-8859-1">
    <title>Manage Employee</title>
    <jsp:include page="/template/bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/template/component/menu.jsp"></jsp:include>
<div class="right-panel" id="right-panel">
    <jsp:include page="/template/component/header.jsp"></jsp:include>
    <a href="/category/contract/add"><i class="fa fa-plus fa-2x " style="margin-left: 10px;"></i></a>
    <br>
    <c:if test="${not empty param.message!=null}"><div class="col-lg-9 alert alert-${param.alert}">${param.message}</div></c:if>
    <c:if test="${not empty contracts}">
    <table class="table table-hover table-striped ">
        <thead>
        <th>Code</th>
        <th>Type</th>
        <th>Term</th>
        <th>Description</th>
        <td>Tools</td>
        </thead>
        <tbody>
        <c:forEach items="${contracts}" var="contract">
            <tr>
                <td>${contract.code}</td>
                <td>${contract.type}</td>
                <td>${contract.term} Tháng</td>
                <td>${contract.description}</td>
                <td>
                <a href="/category/contract/update/${contract.id}"><i class="fa fa-edit"></i></a>
                    <a href="/category/contract/delete/${contract.id}" onclick="return confirm('Do you want to delete?')"><i class="fa fa-trash"></i></a>
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