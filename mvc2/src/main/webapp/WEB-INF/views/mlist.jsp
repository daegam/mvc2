<!--jsp 한글 처리 -->
<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>회원목록</title>
<!--스타일 시트 적용-->
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${_list}">
					<tr>
						<td>${tmp.getId()}</td>
						<td>${tmp.getName()}</td>
						<td>
							<a href="mupdate?id=${tmp.getId()}" class="btn btn-primary">수정</a>
							<a href="mdelete?id=${tmp.getId()}" class="btn btn-danger">삭제</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>