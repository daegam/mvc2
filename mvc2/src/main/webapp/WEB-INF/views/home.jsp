<!--jsp 한글 처리 -->
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<!--스타일 시트 적용-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>Hello world!</h1>
		<P>The time on the server is ${serverTime}.</P>
	</div>
</body>
</html>