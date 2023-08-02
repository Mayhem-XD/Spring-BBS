<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
	<style>
		td, th {text-align: center;}
		.disable-link {pointer-events: none;}
	</style>
	<script>
	function updateEmail() {
        var emailInput = document.querySelector('#email');
        var emailSelect = document.querySelector('#emailDomain');
        emailInput.value = emailInput.value.split('@')[0] + emailSelect.value;
    }
	</script>
</head>
<body>
	<%@ include file="../common/top.jspf" %>

	<div class="container" style="margin-top: 80px;">
	
        <div class="row">
        	<%@ include file="../common/aside.jspf" %>
        	<!-- ============================== main ============================ -->
        	<div class="col-sm-9">
        		<h3><strong>사용자 정보수정</strong></h3><hr>
        		<div class="row">
        			<div class="col-3"></div>
        			<div class="col-6">
        				<form action="/sbbs/user/update" method="post" enctype="multipart/form-data">
			            	<input type="hidden" name="uid" value="${user.uid}">
			            	<input type="hidden" name="hashedPwd" value="${user.pwd}">
			            	<input type="hidden" name="filename" value="${user.profile}">
			            	<input type="hidden" name="oldEmail" value="${user.email}">
			                <table class="table table-borderless">
			                	<tr>
			                        <td style="width:35%"><label class="col-form-label">사용자 ID</label></td>
			                        <td style="width:65%"><input type="text" name="uid" class="form-control" value="${user.uid}" disabled></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">이름</label></td>
			                        <td><input type="text" name="uname" class="form-control" value="${user.uname}"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">비밀번호</label></td>
			                        <td><input type="password" name="pwd" class="form-control"></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">비밀번호 확인</label></td>
			                        <td><input type="password" name="pwd2" class="form-control"></td>
			                    </tr>
			                    <tr>
						    <td><label class="col-form-label">이메일</label></td>
						    <td>
						        <div class="input-group">
						            <input type="text" name="email" id="email" class="form-control" value="${user.email.substring(0, user.email.indexOf('@'))}">
						            <select class="form-select" name="emailDomain" id="emailDomain" onchange="updateEmail()">
						                <option selected>@DOMAIN.com</option>
						                <option>@gmail.com</option>
						                <option>@naver.com</option>
						                <option>@yahoo.com</option>
						                <option>@empas.com </option>
						                <option>@msn.com</option>
						            </select>
						        </div>
						    </td>
						</tr>
			                    <tr>
			                        <td><label class="col-form-label">사진</label></td>
			                        <td><input type="file" name="profile" class="form-control" ></td>
			                    </tr>
			                    <tr>
			                        <td><label class="col-form-label">주소</label></td>
			                        <td><input type="text" name="addr" class="form-control" value="${user.addr}"></td>
			                    </tr>
			                    <tr>
			                        <td colspan="2" style="text-align: center;">
			                            <input class="btn btn-primary" type="submit" value="제출">
			                            <input class="btn btn-secondary ms-1" type="reset" value="취소">
			                        </td>
			                    </tr>
			                </table>
			            </form>
			              
        			</div>
        			<div class="col-3"></div>
        		</div>
        		
        	</div>
    	</div>
    	
	</div>
	<%@ include file="../common/bottom.jspf" %>
</body>
</html>