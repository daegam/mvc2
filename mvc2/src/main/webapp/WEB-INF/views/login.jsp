<!--jsp 한글 처리 -->
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>로그인</title>
<!--스타일 시트 적용-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="login.do" method="post">
			<input type="text" name="id"/>
			<input type="password" name="password"/>
			<input type="text" name="name"/>
			<input type="submit" value="가입하기"/>
		</form>
	</div>
</body>
</html>