<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 보기</title>
</head>
<body>
    <h1>게시글 상세 보기</h1>
    <div>
        <h2>제목: ${board.title}</h2>
        <p><strong>작성일자:</strong><fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" /></p>
        <p><strong>작성자:</strong> ${board.name}</p>
        <p><strong>내용:</strong></p>
        <p>${board.content}</p>
        
    </div>
    <a href="returnBoard">목록으로 돌아가기</a>
    <a href="${board.seq}/update">수정하기</a>
    <a href="${board.seq}/delete">삭제하기</a>
</body>
</html>