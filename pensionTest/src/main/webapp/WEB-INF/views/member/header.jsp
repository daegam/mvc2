<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<header class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.do">MY 펜션</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="join.do">회원가입</a></li>
				<c:choose>
					<c:when test="${not empty sessionScope.login_mem}">
						<li><a href="logoutMember.do">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="loginMember.do">로그인</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="#">예약하기</a></li>
				<li><a href="#">Q&A게시판</a></li>
				<li><a href="#">방문후기</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</header>