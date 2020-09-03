<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<style>
	#tbl {
		border: 1px solid #ccc;
		border-collapse: collapse;
	}
	
	#tbl tr, #tbl td, #tbl th {
		border: 1px solid #ccc;
		text-align: center;
	}
	#tbl th:nth-child(1) {
		width: 50px;
	}
	#tbl th:nth-child(2) {
		width: 200px;
	}
	#tbl th:nth-child(3) {
		width: 150px;
	}
	
	#btn {
		/* border: 1px solid black; */
		outline: none;
		width: 400px;
		margin: 10px;
	}
	#write { float: right; }
</style>
<body>

	<table id="tbl">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.seq}</td>
				<td>${dto.title}</td>
				<td>${dto.regdate}</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<div id="btn">
		<button id="write" onclick="location.href='/board/write.do';">글쓰기</button>
		<div style="clear: both;"></div>
	</div>

</body>
</html>