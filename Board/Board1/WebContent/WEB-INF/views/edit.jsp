<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	
	#tbl {
		border: 1px solid #ccc;
		border-collapse: collapse;
		width: 600px;
		height: 700px;
	}
	#tbl *{ border: 1px solid #ccc; }
	#tbl td > input {
		width: 480px;
		border: 0px;
		outline: none;
		padding: 10px;
	}
	
	#tbl th {
		width: 50px;
	}
	#tbl td{
		width: 480px;
		padding-left: 10px;
		padding-right: 10px;
	}
	#content {
		width: 480px;
		height: 500px;
		outline: none;
		padding: 10px;
		resize: none;
		border: 0px;
	}
	
	#btns {
/* 		border: 1px solid black; */
		position: relative;
		width: 600px;
		top: 210px;
		margin-left: 10px;
	}
	
	#btns > button {
		float: right;
		margin: 5px;
		outline: none;
	}

</style>
<body>
	
	<h1>수정하기</h1>
	
	<form method="POST" action="/board/editok.do">
	<div id="content">
		
		<table id="tbl">
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="title" value="${dto.title}" required></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea id="content" name="content" required>${dto.content}</textarea></td>
			</tr>
		
		</table>
		
		<input type="hidden" name="seq" value="${dto.seq}">
		
	</div>
	
	<div id="btns">
		<button id="back" onclick="history.back();">뒤로</button>
		<button id="write" type="submit">등록</button>
		<div style="clear:both;"></div>
	</div>
	</form>


</body>
</html>