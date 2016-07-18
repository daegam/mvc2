<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 등록</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<form:form action="joinCustomer.do" commandName="bankCustomer" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-babel">이름</label>
				<div class="col-sm-10">
					<form:input path="customer_name" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputTel" class="col-sm-2 control-babel">전화번호</label>
				<div class="col-sm-10">
					<form:input path="customer_tel" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPostcode" class="col-sm-2 control-babel">우편번호</label>
				<div class="col-sm-10">
					<form:input path="customer_postcode" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPostcode" class="col-sm-2 control-babel">주소</label>
				<div class="col-sm-10">
					<form:input path="customer_addr1" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPostcode" class="col-sm-2 control-babel">상세주소</label>
				<div class="col-sm-10">
					<form:input path="customer_addr2" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPostcode" class="col-sm-2 control-babel">생년월일</label>
				<div class="col-sm-10">
					<form:input path="customer_birth" class="form-control" />
				</div>
			</div>
			<div class="row" align="center">
				<form:button type="submit" class="btn btn-success">고객 등록하기</form:button>
			</div>
		</form:form>
	</div>
</body>
</html>