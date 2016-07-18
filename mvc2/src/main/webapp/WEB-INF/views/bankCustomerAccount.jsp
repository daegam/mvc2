<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 계좌</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container" style="margin-top: 20px">
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
					<th>계좌번호</th>
					<th>계좌잔액</th>
					<th>계좌 등록일자</th>
					<th>비고</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(BankCustomerAccount)>0}">
						<c:forEach var="bca" items="${BankCustomerAccount}">
							<tr>
								<td>${bca.getCustomer_no()}</td>
								<td>${bca.getCustomer_name()}</td>
								<td>${bca.getCustomer_tel()}</td>
								<td>${bca.getCustomer_postcode()}</td>
								<td>${bca.getCustomer_addr1()}</td>
								<td>${bca.getCustomer_addr2()}</td>
								<td>${bca.getCustomer_birth()}</td>
								<td>${bca.getCustomer_date()}</td>
								<td>${bca.getAccount_no()}</td>
								<td>${bca.getAccount_money()}</td>
								<td>${bca.getAccount_date()}</td>
								<td>
									<a href="deposit.do?customer_no=${bca.getCustomer_no()}&account_no=${bca.getAccount_no()}" class="btn btn-success">입금</a> 
									<a href="withdrawal.do?customer_no=${bca.getCustomer_no()}&account_no=${bca.getAccount_no()}" class="btn btn-danger">출금</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10" align="center">해당 고객은 계좌가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>