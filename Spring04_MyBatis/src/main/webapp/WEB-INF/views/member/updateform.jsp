<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/member/updateform.jsp</title>
</head>
<body>
	<div class="container">
		<h1>회원 수정 폼</h1>
		<form action="update.do" method="post">
			<input type="hidden" name="num" id="num" value="${dto.num }"/>
			<label for="num2">번호</label>
			<input type="text" name="num2" id="num2" value="${dto.num }" disabled/>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" value="${dto.name }"/>
			<label for="addr">주소</label>
			<input type="text" name="addr" id="addr" value="${dto.addr  }"/>
			<button type="submit">수정</button>
		</form>
	</div>
</body>
</html>