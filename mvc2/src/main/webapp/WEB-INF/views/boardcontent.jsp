<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<form:form class="form-horizontal" action="boardwrite.do" method="post">
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">제목</label>
				<div class="col-sm-10">
					<c:out value="${_board.getTitle()}"></c:out>
				</div>
			</div>
			<div class="form-group">
				<label for="inputWriter" class="col-sm-2 control-label">작성자</label>
				<div class="col-sm-10">
					<c:out value="${_board.getWriter()}"></c:out>
				</div>
			</div>
			<div class="form-group">
				<label for="inputTitle" class="col-sm-2 control-label">내용</label>
				<div class="col-sm-10">
					<c:out value="${_board.getContent()}"></c:out>
				</div>
			</div>
			<div class="form-group" align="right">
				<a href="boardupdate?no=${_board.getNo()}" class="btn btn-success">수정하기</a>
				<a href="boarddelete.do?no=${_board.getNo()}" class="btn btn-danger">삭제하기</a>
			</div>
		</form:form>
	</div>
</body>
</html>