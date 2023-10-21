# SpringBoot

<h1>Bulletin Board System</h1>

<p>
Maven과 mySQL, Oracle을 사용한 simple spring boot BBS project
</p>

<h3>개발 도구</h3>

>  ![img_61](https://github.com/Mayhem-XD/Java/assets/116787370/80653f1d-6745-40e3-8af4-fc82d7d81518) ![img_61](https://github.com/Mayhem-XD/PyCo/assets/116787370/315f7972-a2df-4f8d-aeba-b889b50d0c5d) ![Untitled-1](https://github.com/Mayhem-XD/Java/assets/116787370/076d94a4-563d-4b9e-ac52-0509d22077e6)
> ![img_61 (2)](https://github.com/Mayhem-XD/Java/assets/116787370/8406f594-fb71-4cdc-80fd-ff72268cfcab)     ![vscode](https://github.com/Mayhem-XD/Java/assets/116787370/fbda9bcc-d200-448d-bca2-d1e142d45fcd)    ![img_61 (3)](https://github.com/Mayhem-XD/Java/assets/116787370/13a06fa8-7827-4a1c-a19f-7b23c25f4a4f)
> 
<hr>
<h2>수정중</h2>

> ext jar 3개
> bcrypt<br>
> ocn.home<br>
> pc 이름 확인<br>
> oracle server 설치순서
<hr>
<br><br>

<h4>일단 과정 수정중</h4>

> New -> Maven simple project 체크 <br>
> Type : Maven	Packaging  : Jar <br>
> Java Version : 11   Language : Java
> Group : com.ys <br>
> Artifact : sbbs <br>
> Version: 0.0.1-SNAPSHOT <br>
> Description : BBS project for Spring Boot <br>
> Spring Boot Version : 2.7.14 <br>
> Lombok <br>
> Lombok 추가 설치 <br>  
> MyBatis Framework <br>
> MySQL Driver <br>
> Oracle Driver <br>
> Spring Web <br>
> mySQL 메인 <br>
> Oracle 설치 <br>
> PC이름, 사용자 이름 영어로 <br>
> Spring boot 설정 <br>
> JSP 사용하기 위한 확장 설치<br>
> schedul 추가

~~~ java

<properties>
	  <maven.compiler.target>11</maven.compiler.target>
	  <maven.compiler.source>11</maven.compiler.source>
  </properties>

<dependencies>
	<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>8.0.33</version>
	</dependency>
	<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
	<dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>javax.servlet-api</artifactId>
	    <version>4.0.1</version>
	    <scope>provided</scope>
	</dependency>
	<!-- https://mvnrepository.com/artifact/org.mindrot/jbcrypt -->
	<dependency>
	    <groupId>org.mindrot</groupId>
	    <artifactId>jbcrypt</artifactId>
	    <version>0.4</version>
	</dependency>
	<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
	<dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>jstl</artifactId>
	    <version>1.2</version>
	</dependency>
  </dependencies>

~~~

~~~ java
// ajax 이용해서 등록창에서 유효한 ID 양식 확인,  패스워드 일치 여부 확인
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

~~~

~~~ js
// JavaScript (jQuery)
$(document).ready(function() {
    $("#uid").on("change",function() {
        let uid = $('#uid').val();
        $.ajax({
            url: "/sbbs/user/checkUid",
            type: "GET",
            data: { uid: uid },
            success: function(data) {
                 $("#uidCheckMsg").text(data);
            }
        });
    });
    
    $("#pwd2").on("change",function() {
        let pwd = $("#pwd").val();
        let pwd2 = $("#pwd2").val();
        if(pwd !== pwd2) {
            $("#pwd").css("background-color", "#ffc1cc");
            $("#pwd2").css("background-color", "#ffc1cc");
        } else {
            $("#pwd").css("background-color", "#ccff00");
            $("#pwd2").css("background-color", "#ccff00");
        }
    });   
});

~~~

~~~ java
// email 입력 받는 부분
 <tr>
	<td><label class="col-form-label">이메일</label></td>
	<td>
		<div class="input-group">
		<input type="text" name="email" id="email" class="form-control">
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

~~~

~~~ js

<script>
	function updateEmail() {
        var emailInput = document.querySelector('#email');
        var emailSelect = document.querySelector('#emailDomain');
        emailInput.value = emailInput.value.split('@')[0] + emailSelect.value;
    }
</script>

~~~

~~~ jsp

<c:forEach var="reply" items="${replyList}">
	<c:if test="${reply.isMine eq 0}">
		<div class="d-flex flex-row mt-1">
			<div class="card bg-light text-dark w-75">
				<c:if test="${reply.uid eq sessUid }">
					<div class="card-body">
	                                        <input type="hidden" name="bid" value="${board.bid}">
	                                        <input type="hidden" name="uid" value="${reply.rid}">
						${reply.uname}&nbsp;&nbsp;${fn:replace(reply.regTime, 'T', ' ')}
						<a href="/sbbs/reply/delete/${reply.rid}/${board.bid}"><i class="fa-solid fa-trash"></i></a><br>
						${reply.comment}
					</div>
				</c:if>
				<c:if test="${reply.uid ne sessUid }">
					<div class="card-body">
						${reply.uname}&nbsp;&nbsp;${fn:replace(reply.regTime, 'T', ' ')}<br>
						${reply.comment}
					</div>
				</c:if>
			</div>
		</div>
	</c:if>
	
</c:forEach>


~~~

<br><br>



<hr>




