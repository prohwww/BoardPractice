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
		/* border: 1px solid #ccc; */
		border-collapse: collapse;
		width: 500px;
		height: 400px;
	}
	#tbl td, #tbl tr{ border: 1px solid #ccc; }
	#tbl td {
		width: 500px;
		padding: 10px;
	}
	#tbl td > span {
		float: right;
		font-size: 12px;
	}
	#ctd{
		height: 300px;
	}
	
	#btns {
/* 		border: 1px solid black; */
		position: relative;
		width: 490px;
		top: 0px;
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
		<h2>#${dto.seq}번째 게시물 입니다.</h2>
		<table id="tbl">
			<tr>
				<td>${dto.title} <span>${dto.regdate}</span></td>
			</tr>
			
			<tr>
				<td id="ctd">${dto.content}</td>
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