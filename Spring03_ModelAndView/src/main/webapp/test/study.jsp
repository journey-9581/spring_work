<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/test/study.jsp</title>
</head>
<body>
<h1>공부하는 페이지</h1>
<p>열공각</p>
<a href="../home.do">인덱스로 가기</a><br/>
<a href="${pageContext.request.contextPath }/home.do">인덱스로 가기</a><br/>
<a href="${pageContext.request.contextPath }/">인덱스로 가기</a>
</body>
</html>