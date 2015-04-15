<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/jquery-1.11.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>${name}</h2>

	<div>
		<a href="#" id="test1">Get ||</a> <a href="#" id="test2">Get2 ||</a> <a
			href="#" id="test3">Get3 ||</a> <a href="#" id="test4">GetJson</a>
	</div>
	<div id="result"></div>
	<script>
	$("#test1").click(function(event) {
		console.log('requset ajax');
		$.get('person/23', function(data) {
			$("#result").text(data);
			console.log(data);
		});
	});
	
	$("#test2").click(function(event) {
		$.get('ajax/get2?name=ljinshuan', function(data) {
			$("#result").text(data);
		});
	});
	$("#test3").click(function(event) {
		$.get('ajax/get3?name=ljinshuan', function(data) {
			$("#result").text(data.username);
		});
	});
	$("#test4").click(function(event) {
		$.getJSON('person/23', function(data, textStatus) {
			$("#result").text(data);
		});
	});
	
	var aaa="aa";
	

</script>
</body>
</html>