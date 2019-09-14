<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="/">Manage Employee</a>
                <a class="navbar-brand hidden" href="./"><img src="/template/images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="menu-item-has-children dropdown ${category}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Category</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="/category/contract">Contracts</a></li>
                            <li><i class="fa fa-bars"></i><a href="/category/part">Parts</a></li>
                            <li><i class="fa fa-bars"></i><a href="/category/department">Department</a></li>
                            <li><i class="fa fa-bars"></i><a href="/category/training">Training Course</a></li>
                        </ul>
                    </li>
                    <li class="${train}">
                        <a href="/trainingemployee"> <i class="menu-icon fa fa-server"></i>Training Manage</a>
                    </li>
                    <li class="${hr}">
                        <a href="/hr"> <i class="menu-icon fa fa-address-book-o"></i>HR Contracts</a>
                    </li>
                    <li class="menu-item-has-children dropdown ${report}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-id-card"></i>Report Manage HR</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="/report/employee">Staff</a></li>
                            <li><i class="fa fa-id-badge"></i><a href="/report/probation">Probation Staff</a></li>
                            <li><i class="fa fa-bars"></i><a href="/report/expiresemployee">Staff Contract Expires</a></li>
                            <li><i class="fa fa-bars"></i><a href="/report/trainingemployee">Staff And Training Courses</a></li>
                        </ul>
                    </li>
                    <c:if test="${fn:contains(cookie.ROLES.value,'ADMIN')}">
                    <li class="menu-item-has-children dropdown ${user}">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-id-card"></i>Manage User</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-user"></i><a href="/manage/user">List User</a></li>
                            <li><i class="fa fa-lock"></i><a href="/manage/autherization">Autherization</a></li>
                        </ul>
                    </li>
                    </c:if>
                    <h3 class="menu-title">Extras</h3><!-- /.menu-title -->
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Pages</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="/login">Login</a></li>
                            <%--<li><i class="menu-icon fa fa-sign-in"></i><a href="page-register.html">Register</a></li>--%>
                            <%--<li><i class="menu-icon fa fa-paper-plane"></i><a href="pages-forget.html">Forget Pass</a></li>--%>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->