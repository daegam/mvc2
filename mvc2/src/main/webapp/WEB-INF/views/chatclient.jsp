<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="button" id="btn_conn" value="접속" />

	<br />
	<input type="text" id="txt_msg" />
	<input type="button" id="btn_send" value="전송" />
	<div id="output"></div>

	<script type="text/javascript" src="resources/js/jquery-1.12.3.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			var host = "ws://127.0.0.1:8080/daegam/chat/server.do";
			var socket = new WebSocket(host);

			socket.onopen = function() {
				//서버 접속시	
			};

			socket.onmessage = function(msg) {
				//서버에서 메시지가 올경우	
				$('#output').append(msg.data + "<br />");
				$("html, body").animate({
					scrollTop : $(document).height()
				}, 1000);
			};

			socket.onclose = function() {
				//서버 접속 종료시
			};

			$('#btn_conn').click(function() {
				alert('접속');
			});

			$('#btn_send').click(function() {
				var msg = $('#txt_msg').val();
				socket.send(msg);
			});
		});
	</script>
</html>