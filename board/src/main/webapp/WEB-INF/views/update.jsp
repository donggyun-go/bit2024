<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<body>
    <h1>게시글 수정</h1>
    <form action="/gyun/detail/${board.seq}/updateForm" method="post">
    <div>
        <h2>제목: <input type="text" name="title" value="${board.title}"></h2>
        <p><strong>작성일자:</strong><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></p>
        <p><strong>작성자:</strong> ${board.name}</p>
        <p><strong>내용:</strong></p>
        <p><input type="text" name="content" value="${board.content}"></p>
        
    </div>
    <button type="submit">수정</button>
    </form>
    <a href="/gyun/detail/${board.seq}">취소</a>
</body>
</html>
