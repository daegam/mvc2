<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>펜션 등록하기</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link href="resources/css/jquery.timepicker.css" rel="stylesheet">
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
				<div class="page-header">
					<h1>펜션등록</h1>
				</div>
				<form:form action="regPension.do" class="form-horizontal" commandName="pension" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label class="col-sm-4 control-label">펜션이름</label>
						<div class="col-sm-4">
							<form:input path="name" class="form-control" placeholder="펜션 이름을 입력하세요" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">펜션사진</label>
						<div class="col-sm-4">
							<input type="file" class="form-control" name="picture" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">성수기 시작일</label>
						<div class="col-sm-4">
							<form:input path="busy_season_start" class="form-control" id="busy_season_start" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">성수기 마감일</label>
						<div class="col-sm-4">
							<form:input path="busy_season_end" class="form-control" id="busy_season_end" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">입실 시간</label>
						<div class="col-sm-4">
							<form:input path="check_in_time" class="form-control" id="check_in_time" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">퇴실 시간</label>
						<div class="col-sm-4">
							<form:input path="check_out_time" class="form-control" id="check_out_time" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">펜션 주소</label>
						<div class="col-sm-4">
							<form:input path="addr" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">문의 전화</label>
						<div class="col-sm-4">
							<form:input path="tel" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12" align="center">
							<form:button class="btn btn-success">팬션 등록</form:button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="resources/js/jquery-1.12.3.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script src="resources/js/jquery.timepicker.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$("input[id^='busy_season']").datepicker({
				'dateFormat' : 'yy:mm:dd'
			});
			$("input[id^='check']").timepicker({
				'timeFormat' : 'H:i'
			});
		})
	</script>
</body>
</html>