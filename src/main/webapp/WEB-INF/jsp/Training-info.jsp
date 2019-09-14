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
    <div class="container">
       Code:${training.code}
        <br>
        Name:${training.name}
        <br>
        Description:${training.description}
        <br>
         Status:${training.status == 1 ? "Enable":"Disable"}
    </div>
    <c:if test="${not empty trainingEmployee}">
        <c:if test="${not empty param.message!=null}"><div class="col-lg-9 alert alert-${param.alert}">${param.message}</div></c:if>
        <table class="table table-hover">
            <thead>
            <th>Name</th>
            <th>Department</th>
            <th>Type</th>
            <th>Status</th>
            <th>Result</th>
            <th>Tool</th>
            </thead>
            <tbody>
            <c:forEach items="${trainingEmployee}" var="item">
                <tr>
                    <td>${item.employee.fullName}</td>
                    <td>${item.employee.department.name}</td>
                    <td><c:choose>
                        <c:when test="${item.employee.type==0}">Nhân viên học việc</c:when>
                        <c:when test="${item.employee.type==1}">Nhân viên thử việc</c:when>
                        <c:when test="${item.employee.type==2}">Nhân viên chính thức</c:when>
                    </c:choose></td>
                    <td>${item.status ==1 ?"Enable" : "Disable"}</td>
                    <td>${item.result}</td>
                    <td><a href="/trainingemployee/update/${training.id}?id=${item.id}"><i class="fa fa-edit"></i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <div class="col-lg-6">
        Search:
        <br>
    <form method="get" action="/search/${training.id}" class="form-group">
        Name : <input class="form-control" name="nameEmployee">
        <br>
        <button type="submit" class="btn btn-info">Search</button>
    </form>
    </div>
    <c:if test="${not empty employee}">
        Search Result<br>
        <table class="table table-hover">
            <thead>
            <th>Name</th>
            <th>Department</th>
            <th>Type</th>
            </thead>
            <tbody>
            <c:forEach items="${employee}" var="item">
                <tr>
                    <td>${item.fullName}</td>
                    <td>${item.department.name}</td>
                    <td><c:choose>
                        <c:when test="${item.type==0}">Nhân viên học việc</c:when>
                        <c:when test="${item.type==1}">Nhân viên thử việc</c:when>
                        <c:when test="${item.type==2}">Nhân viên chính thức</c:when>
                    </c:choose></td>
                    <td><a href="/trainingemployee/${training.id}/${item.id}">Add To Course</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${not empty viewmodel}">
    <div class="container col-lg-9">
        <div class="col-lg-9 alert-info">Update</div>
        <form:form action="/trainingemployee/${training.id}" method="post" modelAttribute="viewmodel" cssClass="form-group">
            <form:hidden path="trainingEmployee.id"></form:hidden>
            <form:label path="trainingEmployee.result"></form:label>
            <form:textarea path="trainingEmployee.result" cssClass="form-control"></form:textarea>
            <form:label path="trainingEmployee.status"></form:label>
            <form:select path="trainingEmployee.status">
                <form:option value="1">Enable</form:option>
                <form:option value="0">Disable</form:option>
            </form:select>
            <button type="submit" class="btn btn-success">Update</button>
        </form:form>

    </div>
    </c:if>
</div>
<jsp:include page="/template/jquery/libs.jsp"></jsp:include>
</body>
</html>