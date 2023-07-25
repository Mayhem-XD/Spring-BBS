<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Calc</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/fdb840a8cc.js" crossorigin="anonymous"></script>
    <style>
        * { font-family: 'Noto Sans KR', sans-serif; }
        a { text-decoration: none; }
    </style>
    <script>
    $(document).ready(function() {
        $('form').submit(function(event) {
            event.preventDefault();	// form 제출 동작 방지
            $.ajax({
                type: 'POST',
                url: '/sbbs/test/calc',
                data: $(this).serialize(),	//  form 요소의 입력 필드의 이름과 값을 쌍으로 하는 문자열을 생성	
											//  ex) "num1=10&calc=+&num=29"               
                success: function(data) {	// data는 CalcController에서 구한 값 result	
                    $('#result').html(data);
                }
            });
        });
    });
</script>
</head>
<body>
	<div class="container" style="margin-top: 80px;">
		 <div class="row">
		 <div class="col-sm-1"></div>
		 <div class="col-sm-10">
		 	<form method="post" action="/sbbs/test/calc">
		 		<table class="table table-condensed table-hover" style="margin-bottom:50px">
		 			<tr>
		 				<td><input type="number" name="num1" placeholder="num1" class="form-control"></td>
		 				<td><input type="text" name="calc" placeholder="+-*/" class="form-control"></td>
		 				<td><input type="number" name="num2" placeholder="num2" class="form-control"></td>
		 				<td><input type="submit" name="res" value="=" class="form-control"></td>
		 				<td><div style="height: 38px; width:50px" id="result" class="form-control"></div></td>
		 			</tr>
		 		</table>
		 	</form>
		 </div>
		 <div class="col-sm-1"></div>
		 </div>
	</div>

</body>
</html>