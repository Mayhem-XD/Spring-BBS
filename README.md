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
> MyBatis Framework <br>
> MySQL Driver <br>
> Oracle Driver <br>
> Spring Web <br>
> Oracle 설치 <br>
> PC이름, 사용자 이름 영어로 <br>
> Spring boot 설정 <br>
> JSP 사용하기 위한 확장 설치<br>

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


<br><br>



<hr>




