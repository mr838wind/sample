<%@ page language="java" contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
	        url: '/designer/sample/jsonTest.ajax',
	        type: 'post',
	        data: { test:-1 },
	        error: function(_data) {
				console.log(_data);
		    	alert("오류가 발생 하였습니다.\n관리자에게 문의 하세요.");
			},
			success: function(_data){
				console.log(_data);
				$('#result').text(_data); 
				if(_data.result == '9999') {
					alert(_data.message);
				}
			}
	    });
	});
</script>
</head>
<body>

	<p>
		jsonTest
	</p>
	<div id="result">
		result....
	</div>

	
</body>
</html>