<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel='stylesheet' href='resources/css/fullcalendar.min.css' />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<br>
	<br>
	<div class="container">
		<div id='calendar'></div>
	</div>
	<script src='resources/js/jquery-1.12.3.min.js'></script>
	<script src='resources/js/moment.min.js'></script>
	<script src='resources/js//fullcalendar.min.js'></script>

	<script>
		$(document).ready(function() {

			// page is now ready, initialize the calendar...

			$('#calendar').fullCalendar({
			// put your options and callbacks here
			})
		});
	</script>

</body>
</html>