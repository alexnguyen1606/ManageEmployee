<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<div class="right-panel container" id="right-panel">
    <jsp:include page="/template/component/header.jsp"></jsp:include>
    <a href="/hr/add"><i class="fa fa-plus fa-2x " style="margin: auto;"></i></a>
    <div class="container">
    <c:if test="${not empty param.message!=null}"><div class="col-lg-9 alert alert-${param.alert}">${param.message}</div></c:if>
    <c:if test="${not empty staffs}">
        <table class="table table-hover table-striped ">
            <thead>
            <th>FullName</th>
            <th>Department</th>
            <th>Type</th>
            <td>Number Insurence</td>
            <td>Address</td>
            <td>Gender</td>
            <td>Birth Day</td>
            <td>Phone Number</td>
            <td>Tool</td>
            <td>Contract</td>
            </thead>
            <tbody>
            <c:forEach items="${staffs}" var="staff">
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
                    <td><fmt:formatDate pattern="dd-MM-yyyy" value="${staff.birthDay}"/></td>
                    <td>${staff.phoneNumber}</td>
                    <td>
                        <a href="/hr/update/${staff.id}"><i class="fa fa-edit"></i></a>
                        <a href="/hr/delete/${staff.id}" onclick="return confirm('Do you want to delete?')"><i class="fa fa-trash"></i></a>
                    </td>
                    <td><a href="/contractemployee/${staff.id}">Contract Personal</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    </div>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>