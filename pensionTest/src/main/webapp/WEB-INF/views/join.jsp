<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include><br>
	<br>
	<br>
	<div class="container">
		<div class="page-header">
			<h1>회원가입</h1>
		</div>
		<form:form class="form-horizontal" commandName="join">
			<div class="form-group">
				<label class="col-sm-3 control-label">아이디</label>
				<div class="col-sm-6" id="div_id">
					<form:input path="id" class="form-control" id="id" placeholder="영문,숫자가 포함된 6자리 이상 아이디만 사용 가능합니다." />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">패스워드</label>
				<div class="col-sm-6" id="div_pwd">
					<form:password path="pwd" class="form-control" id="pwd" placeholder="영문,숫자,특수문자가 포함된 6자리 이상 아이디만 사용 가능합니다!" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">패스워드 확인</label>
				<div class="col-sm-6" id="div_re_pwd">
					<input type="password" class="form-control" id="re_pwd" placeholder="비밀번호를 다시 한번 입력하세요.">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">이름</label>
				<div class="col-sm-6" id="div_name">
					<form:input path="name" class="form-control" id="name" placeholder="한글 이름만 입력가능합니다." />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">전화번호</label>
				<div class="col-sm-6" id="div_tel">
					<form:input path="tel" class="form-control" id="tel" placeholder="-를 제외한 전화번호를 입력하세요." />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">우편번호</label>
				<div class="col-sm-4">
					<form:input path="postcode" class="form-control" id="postcode" placeholder="검색 버튼을 누르세요." readonly="true"/>
				</div>
				<div class="col-sm-2">
					<input type="button" class="btn btn-primary" id="btn_search_addr" value="주소 검색" onClick="search_addr()"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">주소</label>
				<div class="col-sm-6">
					<form:input path="addr" class="form-control" id="addr" readonly="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label">상세 주소</label>
				<div class="col-sm-6">
					<form:input path="detail_addr" class="form-control" id="detail_addr" placeholder="상세주소를 입력하세요." />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12 text-center">
					<form:button class="btn btn-success" id="btn_join">회원 가입</form:button>
				</div>
			</div>
		</form:form>
		<hr>
	</div>

	<script type="text/javascript" src="resources/js/jquery-1.12.3.min.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		//http://postcode.map.daum.net/guide
		function search_addr() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
							// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
							var extraRoadAddr = ''; // 도로명 조합형 주소 변수
	
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraRoadAddr += (extraRoadAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraRoadAddr !== '') {
								extraRoadAddr = ' (' + extraRoadAddr + ')';
							}
							// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
							if (fullRoadAddr !== '') {
								fullRoadAddr += extraRoadAddr;
							}
	
							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							$('#postcode').val(data.zonecode);
							$('#addr').val(fullRoadAddr);
							
	
							// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
							if (data.autoRoadAddress) {
								//예상되는 도로명 주소에 조합형 주소를 추가한다.
								var expRoadAddr = data.autoRoadAddress
										+ extraRoadAddr;
								document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
										+ expRoadAddr + ')';
	
							} else if (data.autoJibunAddress) {
								var expJibunAddr = data.autoJibunAddress;
								document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
										+ expJibunAddr + ')';
	
							} else {
								document.getElementById('guide').innerHTML = '';
							}
						}
					}).open();
		}
	
		$(function() {
			
			var flag = false;
			
			$('#id').keyup(function(){
				
				$(this).val($(this).val().replace(/[^a-z0-9]/gi,""));
				$('#help_id').detach();
				if($('#id').val() == "" || $('#id').val().length<6){
					$('#div_id').append(
							"<p class='help-block' id='help_id' style='color: red'>영문,숫자가 포함된 6자리 이상 아이디만 사용 가능합니다!</p>"
							);
					flag = false;
				}else{
					flag = true;
				}
			});
			
			$('#pwd').keyup(function(){
				
				$(this).val($(this).val().replace(/[^!-z0-9]/gi,""));
				$('#help_pwd').detach();
				if($('#pwd').val() == "" || $('#pwd').val().length<8){
					$('#div_pwd').append(
							"<p class='help-block' id='help_pwd' style='color: red'>영문,숫자,특수문자가 포함된 8자리 이상 비밀번호만 사용 가능합니다!</p>"
							);
					flag = false;
				}else{
					flag = true;
				}
			});
			
			$('#re_pwd').keyup(function(){
				
				$(this).val($(this).val().replace(/[^!-z0-9]/gi,""));
				$('#help_re_pwd').detach();
				if($('#pwd').val() != $('#re_pwd').val()){
					$('#div_re_pwd').append(
							"<p class='help-block' id='help_re_pwd' style='color: red'>위에 입력한 비밀번호와 일치하지 않습니다.</p>"
							);
					flag = false;
				}else{
					flag = true;
				}
			});
			
			$('#name').keyup(function(){
				
				$(this).val($(this).val().replace(/[!-z0-9]/gi,""));
				$(this).val($(this).val().replace(" ",""));
				$('#help_name').detach();
				if($('#name').val() == ""){
					$('#div_name').append(
							"<p class='help-block' id='help_name' style='color: red'>한글로 된 이름만 입력가능합니다!</p>"
							);
					flag = false;
				}else{
					flag = true;
				}
			});
			
			$('#tel').keyup(function(){
				
				$(this).val($(this).val().replace(/[^0-9]/gi,""));
				$('#help_tel').detach();
				if($('#tel').val() == ""){
					$('#div_tel').append(
							"<p class='help-block' id='help_tel' style='color: red'>숫자만 입력하세요!</p>"
							);
					flag = false;
				}else{
					flag = true;
				}
			});
			
			

			
			$('#btn_join').bind('click', function(){
				
				if($('#detail_addr').val().trim() == "" || $('#postcode').val() == "" || $('#addr').val() == ""){
					flag = false;
				}else{
					flag = true;
				}
				
				if(flag == false){
					alert("입력이 되지 않았거나 잘못 입력된 곳을 다시입력해주세요!");				
					return false;
				}
			});
		});
	</script>
</body>
</html>