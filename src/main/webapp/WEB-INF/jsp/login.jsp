<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" 
      integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<jsp:include page="/template/bootstrap.jsp"></jsp:include>
<link rel="style/sheet" url="/template/css/login.css">
</head>
<body>
<body>
    <div class="container">
        <div class="row">
			<div class="col-md-5 mx-auto">
			<div id="first" class="first" >
				<div class="myform form ">
					 <div class="logo mb-3">
						 <div class="col-md-12 text-center">
							<h1>Login</h1>
						 </div>
					</div>
					<c:if test="${not empty param.message!=null}"><div class="alert alert-${param.alert}">${param.message}</div>
                    </c:if>
                   <form action="/login" method="post" name="login">
                           <div class="form-group">
                              <label for="exampleInputEmail1">Username</label>
                              <input name="username"  class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter Username">
                           </div>
                           <div class="form-group">
                              <label for="exampleInputEmail1">Password</label>
                              <input type="password" name="password" id="password"  class="form-control" aria-describedby="emailHelp" placeholder="Enter Password">
                           </div>
                           <div class="form-group">
                              <p class="text-center">By signing up you accept our <a href="#">Terms Of Use</a></p>
                           </div>
                           <div class="col-md-12 text-center ">
                              <button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
                           </div>
                           <div class="col-md-12 ">
                              <div class="login-or">
                                 <hr class="hr-or">
                                 <span class="span-or">or</span>
                              </div>
                           </div>
                           <div class="col-md-12 mb-3">
                              <p class="text-center">
                                 <a href="javascript:void();" class="google btn mybtn"><i class="fa fa-google-plus">
                                 </i> Signup using Google
                                 </a>
                              </p>
                           </div>
                           <div class="form-group">
                              <p class="text-center">Don't have account? <a href="#" id="signup"  >Sign up here</a></p>
                           </div>
                        </form>
                 
				</div>
			</div>
			</div>
		</div>
      </div>
      <script src="/template/js/login.js"></script>   
      <script type="text/javascript">
      function openform() {
    		document.getElementById("first").style.display="none";
    		document.getElementById("second").style.display="block";
    	}
    	function closeform() {
    		document.getElementById("first").style.display="block";
    		document.getElementById("second").style.display="none";

    	}
      </script>
</body>
</html>