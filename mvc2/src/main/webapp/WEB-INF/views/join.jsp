<!--jsp 한글 처리 -->
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>회원가입</title>
<!--스타일 시트 적용-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
	<h2>회원가입</h2><br/>
		<form:form action="joinadd.do" commandName="command" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="inputId" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
					<form:input type="text" path="id" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">패스워드</label>
				<div class="col-sm-10">
					<form:input type="password" path="password" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputRePassword" class="col-sm-2 control-label">패스워드 확인</label>
				<div class="col-sm-10">
					<input type="password" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">이름</label>
				<div class="col-sm-10">
					<form:input type="text" path="name" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="회원가입" class="btn btn-success"/>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>