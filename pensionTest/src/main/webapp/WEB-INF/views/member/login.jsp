<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/login.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">일반회원</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">관리자</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="login-form" action="loginMember.do" commandName="login" method="post" role="form" style="display: block;">
									<div class="form-group">
										<form:input path="id" tabindex="1" class="form-control" placeholder="아이디를 입력하세요" />
									</div>
									<div class="form-group">
										<form:password path="pwd" tabindex="2" class="form-control" placeholder="패스워드를 입력하세요" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<form:button tabindex="4" class="form-control btn btn-login">로그인</form:button>
											</div>
										</div>
									</div>
								</form:form>
								<form:form id="register-form" action="loginAdmin.do" commandName="login" method="post" style="display:none;">
									<div class="form-group">
										<form:input path="id" tabindex="1" class="form-control" placeholder="관리자 아이디" />
									</div>
									<div class="form-group">
										<form:password path="pwd" tabindex="2" class="form-control" placeholder="관리자 패스워드" />
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<form:button tabindex="4" class="form-control btn btn-login">관리자 로그인</form:button>
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="resources/js/jquery-1.12.3.min.js"></script>
	<script src="resources/js/login.js"></script>
</body>
</html>