<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jspf" %>
	<script>
	function updateEmail() {
        var emailInput = document.querySelector('#email');
        var emailSelect = document.querySelector('#emailDomain');
        emailInput.value = emailInput.value.split('@')[0] + emailSelect.value;
    }
	</script>
</head>
<body>
	<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
        <div class="container-fluid">
            <img src="/sbbs/img/logo.png" alt="Logo" style="height:60px;" class="rounded-3 mx-2">
            <div class="p-2 bg-dark justify-content-center rounded">
                <img src="https://picsum.photos/1500/200" width="100%">
            </div>
        </div>
    </nav>
    <div class="container" style="margin-top: 300px;">
        <div class="row">
            <div class="col-4"></div>
            <div class="col-4">
                <h3>
                    <strong>회원 가입</strong>
                </h3>
                <hr>
                <form action="/sbbs/user/register" method="post" enctype="multipart/form-data">
	                <table class="table table-borderless">
	                    <tr>
	                        <td style="width:35%"><label class="col-form-label">사용자 ID</label></td>
	                        <td style="width:65%"><input type="text" name="uid" id="uid" class="form-control" placeholder="3글자 이상 입력하세요"></td>
	                    </tr>
	                    <tr>
	                    
							<td><label class="col-form-label">중복 확인</label></td>	                		
	                		<td><span style="font:20px" id="uidCheckMsg"></span></td>
	                	</tr>
	                    <tr>
	                        <td><label class="col-form-label">패스워드</label></td>
	                        <td><input type="password" name="pwd" id="pwd" class="form-control"></td>
	                    </tr>
	                    <tr>
	                        <td><label class="col-form-label">패스워드 확인</label></td>
	                        <td><input type="password" name="pwd2" id="pwd2" class="form-control"></td>
	                    </tr>
	                    <tr>
	                        <td><label class="col-form-label">이름</label></td>
	                        <td><input type="text" name="uname" class="form-control"></td>
	                    </tr>
	                    <tr>
						    <td><label class="col-form-label">이메일</label></td>
						    <td>
						        <div class="input-group">
						            <input type="text" name="email" id="email" class="form-control">
						            <select class="form-select" name="emailDomain" id="emailDomain" onchange="updateEmail()">
						                <option selected>@gmail.com</option>
						                <option>@naver.com</option>
						            </select>
						        </div>
						    </td>
						</tr>
	                    <tr>
	                        <td><label class="col-form-label">사진</label></td>
	                        <td><input type="file" name="profile" class="form-control"></td>
	                    </tr>
	                    <tr>
	                        <td><label class="col-form-label">주소</label></td>
	                        <td><input type="text" name="addr" class="form-control"></td>
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
            <div class="col-4"></div>
        </div>
    </div>
    <%@ include file="../common/bottom.jspf" %>
</body>
</html>