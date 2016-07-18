<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌 등록</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<form:form action="accountReg.do" commandName="account" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="input" class="col-sm-2 control-babel">고객 번호</label>
				<div class="col-sm-10">
					<form:input path="customer_no" class="form-control" readonly="true"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputAccount" class="col-sm-2 control-babel">계좌 번호</label>
				<div class="col-sm-10">
					<form:input path="account_no" class="form-control"/>
				</div>
			</div>
			<div class="row" align="center">
				<form:button type="submit" class="btn btn-success">계좌 등록하기</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>