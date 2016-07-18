<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<div class="form-inline" align="right" style="padding-top: 5px; padding-bottom: 5px;">
			<div class="form-group">
				<select id="search_type" name="search_type" class="form-control">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">작성자</option>
					<option value="write_date">날짜</option>
				</select>
			</div>
			<div class="form-group">
				<input type="text" name="search_text" id="search_text" class="form-control" />
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>글 번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${arr_board}">
					<tr>
						<td>${board.getNo()}</td>
						<td>
							<a href="boardContent?no=${board.getNo()}">${board.getTitle()}</a>
						</td>
						<td>${board.getWriter()}</td>
						<td>${board.getWrite_date()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" align="right">
			<a href="boardwrite" class="btn btn-primary"> 글쓰기</a>
		</div>
	</div>
	
	<script src="resources/js/jquery-1.12.3.min.js"></script>
	<script>
		$(function(){
			$('#search_text').bind('keyup', function(event){
				if(event.which==13){
					var search_type = $('#search_type').val();
					var search_text = $('#search_text').val();
					
					$(location).attr('href', "boardlist?search_type=" + search_type + "&search_text=" + search_text);
				}
			})
		});
	</script>
</body>
</html>