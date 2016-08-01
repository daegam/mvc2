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
				<input type="hidden" value="${pension_name}" id="pension_name"/>
				<input type="hidden" value="${pension_no}" id="pension_no"/>
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
						<th>비고</th>
					</tr>
					<c:forEach items="${arr_room}" var="room">
						<tr>
							<td>${room.name}</td>
							<td>${room.size}</td>
							<td>${room.standard_num}</td>
							<td>${room.max_num}</td>
							<td>${room.weekdays_price}</td>
							<td>${room.weekend_price}</td>
							<td>${room.adult_addprice}</td>
							<td>${room.child_addprice}</td>								
							<td>
								<a href="roomDel.do?pension_name=${pension_name}&pension_no=${pension_no}&room_no=${room.no}" class="btn btn-danger btn_delRoom btn-sm">삭제</a>
								<input type='button' class='btn btn-warning btn-sm' id="btn_roomImg" data-toggle='modal' data-target='#roomImg' value='사진관리'/>
								<input type="hidden" value="${room.no}" id="room_no"/>
								<input type="hidden" value="${room.name}" id="room_name"/>
							</td>
						</tr>
					</c:forEach>
				</table>
				<div class="row" align="center">
					<input type="button" class="btn btn-primary" id="btn_addUpdate" value="방 추가/수정"/>
				</div>
			</div>
		</div>
	</div>
	
	<!-- /#wrapper -->

	<!-- Modal -->
	<div class="modal fade" id="roomImg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel"></h4>
	      </div>
	      <form name="form_roomImage" action="uploadRoomImage.do" method="post">
		      <div class="modal-body">
		        <table class="table">
		        	<tr>
		        		<th class="col-md-4">사진1</th>
		        		<th class="col-md-4">사진2</th>
		        		<th class="col-md-4">사진3</th>
		        	</tr>
		        	<tr>
		        		<td><img src="#" class="img_preview img-rounded" style="max-width: 100%; height: auto;"/></td>
		        		<td><img src="#" class="img_preview img-rounded" style="max-width: 100%; height: auto;"/></td>
		        		<td><img src="#" class="img_preview img-rounded" style="max-width: 100%; height: auto;"/></td>
		        	</tr>
		        	<tr>
		        		<td><input type="file" class="form-control roomPic" name="room_img"></td>
		        		<td><input type="file" class="form-control roomPic" name="room_img"></td>
		        		<td><input type="file" class="form-control roomPic" name="room_img"></td>
		        	</tr>
		        	
		        	<tr>
		        		<th>사진4</th>
		        		<th>사진5</th>
		        		<th>사진6</th>
		        	</tr>
		        	<tr>
		        		<td><img src="#" class="img_preview img-rounded" style="max-width: 100%; height: auto;"/></td>
		        		<td><img src="#" class="img_preview img-rounded" style="max-width: 100%; height: auto;"/></td>
		        		<td><img src="#" class="img_preview img-rounded" style="max-width: 100%; height: auto;"/></td>
		        	</tr>
		        	<tr>
		        		<td><input type="file" class="form-control roomPic" name="room_img"></td>
		        		<td><input type="file" class="form-control roomPic" name="room_img"></td>
		        		<td><input type="file" class="form-control roomPic" name="room_img"></td>
		        	</tr>
	
		        </table>
		      </div>
		      <div class="modal-footer">
		      	<input type="hidden" id="room_no"/>
		      	<button type="button" class="btn btn-primary" id="btn_uploadRoomImage">방 사진 저장</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">나가기</button>
		      </div>
	      </form>
	    </div>
	  </div>
	</div>
	<!-- jQuery -->
	<script src="resources/js/jquery-1.12.3.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/js/bootstrap.min.js"></script>
	<script>
		$(function(){
			var pension_name = $('#pension_name').val();
			var pension_no = $('#pension_no').val();
			
			$('#btn_addUpdate').click(function(){
				$(location).attr('href', "http://127.0.0.1:8080/daegam/roomAddUpdate.do?pension_no=" + pension_no + "&pension_name=" + pension_name);
			});
			
			$('#btn_delRoom').click(function(){
				$(location).attr('href', "http://127.0.0.1:8080:daegam/roomDel.do?pension_no=" + pension_no + "&pension_name=" + pension_name);
			});
			
			$('#btn_roomImg').click(function(){
				var room_name = $('#room_name').val();
				$('#myModalLabel').text(room_name + "방 사진");	
			});
			
			$(document).on('change', '.roomPic', function(){	
				var idx = $(this).index('.roomPic');
				var ext = $(this).val().split('.').pop().toLowerCase();

				if($.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1){
					resetFile($(this));
					alert('업로드 할 수 없는 확장자입니다!');
				}else{
					file = $(this).prop("files")[0];
					var blobURL = URL.createObjectURL(file);
					$('.img_preview').eq(idx).attr('src', blobURL);		
				}
			});
				
			$('#btn_uploadRoomImage').click(function(){
				var form = $('form')[0];
				var formData = new FormData(form);
				
				var room_no = $('#room_no').val();
				
				$.ajax({
					url: 'http://127.0.0.1:8080/daegam/uploadRoomImage.do?room_no=' + room_no,
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					success: function(result){
						alert("업로드 성공!");
					}
				})
			});
		});
		
		function resetFile(e){
			e.wrap('<form>').closest('form').get(0).reset();
			e.unwrap();
		}
		
	</script>
</body>
</html>