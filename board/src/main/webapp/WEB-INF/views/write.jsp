<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>새 게시글 작성</title>
</head>
<body>
    <h1>새 게시글 작성</h1>
    <form action="writeForm" method="post">
        <div>
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div>
            <label for="content">내용:</label>
            <textarea id="content" name="content" required></textarea>
        </div>
        <div>
            <label for="name">작성자:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <input type="submit" value="글 작성">
        </div>
    </form>
</body>
</html>
