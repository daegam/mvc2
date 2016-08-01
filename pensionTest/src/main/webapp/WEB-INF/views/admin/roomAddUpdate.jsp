<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>펜션 목록</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/simple-sidebar.css" rel="stylesheet">

</head>

<body>

	<div id="wrapper">
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> 관리자 페이지 </a></li>
				<li><a href="pensionList.do">펜션 목록</a></li>
				<li><a href="#">예약 현황</a></li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			
			<div class="container">
				<div class="page-header">
					<h1>${pension_name} 방 현황</h1>
				</div>
				<form:form action="roomAddUpdate.do" method="post" modelAttribute="roomList" class="form">
					<input type="hidden" value="${pension_name}" name="pension_name"/>
					<input type="hidden" value="${pension_no}" name="pension_no"/>
					<table class="table" id="table_room">
						<tr>
							<th>방 이름</th>
							<th>사이즈</th>
							<th>기준인원</th>
							<th>최대인원</th>
							<th>주중 요금</th>
							<th>주말 요금</th>
							<th>어른 추가요금</th>
							<th>어린이 추가요금</th>
						</tr>
						<c:forEach items="${roomList.roomList}" varStatus="i">
							<tr class="exist_tr">
								<form:hidden path="roomList[${i.index}].no"/>
								<form:hidden path="roomList[${i.index}].pension_no"/>
								<td><form:input path="roomList[${i.index}].name" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].size" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].standard_num" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].max_num" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].weekdays_price" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].weekend_price" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].adult_addprice" class="form-control"/></td>
								<td><form:input path="roomList[${i.index}].child_addprice" class="form-control"/></td>
							</tr>
						</c:forEach>
					</table>
					<div class="row" align="center">
						<input type="button" class="btn btn-primary" id="btn_addRoom" value="방 추가하기"/>
						<input type="submit" class="btn btn-success" value="저장" />
					</div>
				</form:form>		
			</div>
		</div>
	</div>
	
	<!-- jQuery -->
	<script src="resources/js/jquery-1.12.3.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function(){
			$('#btn_addRoom').click(function(){
				$('#table_room').append(
						"<tr class='exist_tr'>"+ 
							"<td><input type='text' class='form-control' name='name'></td>" + 
							"<td><input type='text' class='form-control' name='size'></td>" + 
							"<td><input type='text' class='form-control' name='standard_num'></td>" + 
							"<td><input type='text' class='form-control' name='max_num'></td>" + 
							"<td><input type='text' class='form-control' name='weekdays_price'></td>" + 
							"<td><input type='text' class='form-control' name='weekend_price'></td>" + 
							"<td><input type='text' class='form-control' name='adult_addprice'></td>" + 
							"<td><input type='text' class='form-control' name='child_addprice'></td>" + 
					"</tr>");
			});
		});
	</script>
</body>
</html>