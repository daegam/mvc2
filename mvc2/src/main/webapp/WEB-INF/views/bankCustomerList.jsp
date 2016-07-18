<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 목록</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<!-- 검색 시작 -->
		<div class="form-inline" align="right" style="padding-top: 5px; padding-bottom: 5px;">
			<div class="form-group">
				<select id="s_type" class="form-control">
					<option value="customer_no" ${param.s_type=="customer_no" ? 'selected="selected"':''}>고객 번호</option>
					<option value="customer_name" ${param.s_type=="customer_name" ? 'selected="selected"':''}>고객 이름</option>
				</select>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" id="s_text" value='<c:if test="${s_text !=''}">${s_text}</c:if>'/>
			</div>
		</div>
		<div id="search">
			<c:if test="${s_text !=''}">
				<label style="color: blue">${s_text}</label><label> 에 대한 검색결과입니다!</label>
			</c:if>
		</div>
		<!-- 검색 끝 -->
		<table class="table">
			<thead>
				<tr>
					<th>고객 번호</th>
					<th>고객 이름</th>
					<th>고객 전화번호</th>
					<th>고객 우편번호</th>
					<th>고객 주소</th>
					<th>고객 상세주소</th>
					<th>고객 생년월일</th>
					<th>고객 등록일자</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${bankCustomers}">
					<tr>
						<td>${customer.getCustomer_no()}</td>
						<td>${customer.getCustomer_name()}</td>
						<td>${customer.getCustomer_tel()}</td>
						<td>${customer.getCustomer_postcode()}</td>
						<td>${customer.getCustomer_addr1()}</td>
						<td>${customer.getCustomer_addr2()}</td>
						<td>${customer.getCustomer_birth()}</td>
						<td>${customer.getCustomer_date()}</td>
						
						<td>
							<a href="accountReg.do?customer_no=${customer.getCustomer_no()}" class="btn btn-primary">계좌등록</a>
							<a href="customerAccount.do?customer_no=${customer.getCustomer_no()}" class="btn btn-primary">계좌확인</a>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row" align="right">
			<input type="button" value="고객 등록" id="btn_joinCustomer" class="btn btn-success"/>
		</div>
		<div class="row" align="center">
			<ul id="pagination-demo" class="pagination-sm"></ul>
		</div>
	</div>
	<script src="resources/js/jquery-1.12.3.min.js"></script>
	<script src="resources/js/jquery.twbsPagination.min.js"></script>
	<script>
		$(function() {
			$('#pagination-demo').twbsPagination({
				totalPages : "<c:out value='${totalPage}'/>",
				visiblePages : 5,
				href : "?page={{number}}&s_type=<c:out value='${param.s_type}'/>&s_text=<c:out value='${param.s_text}'/>",
				onPageClick : function(event, page) {
					$('#page-content').text('Page ' + page);
				}
			});
			
			
			$('#s_text').bind('keyup', function(event) {
				if (event.which == 13) {
					var ty = $('#s_type').val();
					var tx = encodeURIComponent($('#s_text').val());
					$(location).attr('href',"getCustomerList.do?s_type="+ty+"&s_text="+tx);
				}
			});
			
			$('#btn_joinCustomer').click(function(){
				$(location).attr('href', "joinCustomer.do");
			});
		})
	</script>
</body>
</html>