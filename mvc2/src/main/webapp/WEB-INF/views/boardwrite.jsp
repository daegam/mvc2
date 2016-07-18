<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<form:form class="form-horizontal" action="boardwrite.do" commandName="boardwrite" method="post">
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">제목</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="title"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputWriter" class="col-sm-2 control-label">작성자</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" path="writer"/>
				</div>
			</div>
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">내용</label>
				<div class="col-sm-10">
					<form:textarea class="form-control" path="content" rows="20"/>
				</div>
			</div>
			<div class="form-group" align="right">
				<input type="submit" value="글 쓰기" class="btn btn-primary"/>
			</div>
		</form:form>
	</div>
</body>
</html>