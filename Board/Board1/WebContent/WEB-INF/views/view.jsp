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
	
	<div id="content">
		
		<table id="tbl">
			<tr>
				<td>${dto.title} <span>${dto.regdate}</span></td>
			</tr>
			
			<tr>
				<td>${dto.content}</td>
			</tr>
		
		</table>
		
	</div>
	
	<div id="btns">
		<button id="back" onclick="history.back();">뒤로</button>
		<button id="edit" onclick="location.href='/board/delete.do?seq=${dto.seq}';">삭제</button>
		<button id="delete"onclick="location.href='/board/edit.do?seq=${dto.seq}';">수정</button>
		<div style="clear:both;"></div>
	</div>


</body>
</html>