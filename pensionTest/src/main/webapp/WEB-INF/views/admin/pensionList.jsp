<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>펜션 목록</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/simple-sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
				<div class="row text-center">
					<c:forEach var="pension" items="${arr_pension}">
						<div class="col-md-3 col-sm-6 hero-feature">
							<div class="thumbnail">
								<img src="resources/img/pension/${pension.picture_name}" alt="">
								<div class="caption">
									<h3>${pension.name}</h3>
									<p>
										<a href="#" class="btn btn-primary">수정하기</a> <a href="#" class="btn btn-danger">삭제하기</a>
									</p>
									<p>
										<a href="roomList.do?pension_no=${pension.no}&pension_name=${pension.name}" class="btn btn-default">방 관리</a>
									</p>
									
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="row text-center"></div>
			</div>
			<div class="row" align="center">
				<input type="button" class="btn btn-success" id="btn_reg_pension" value="펜션등록" />
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="resources/js/jquery-1.12.3.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>

	<script>
		$(function() {
			$('#btn_reg_pension').bind('click', function() {
				$(location).attr('href', 'regPension.do');
			});
		});
	</script>
</body>
</html>