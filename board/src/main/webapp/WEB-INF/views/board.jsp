<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/redmond/jquery-ui.css" type="text/css" />
 <!-- jqGrid CSS -->
<link rel="stylesheet" href="//cdn.jsdelivr.net/jqgrid/4.6.0/css/ui.jqgrid.css" type="text/css" />
<!-- The actual JQuery code -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.10.2.min.js" /></script>
<!-- The JQuery UI code -->
<script type="text/javascript" src="https://code.jquery.com/ui/1.10.3/jquery-ui.min.js" /></script>
<!-- The jqGrid language file code-->
<script type="text/javascript" src="//cdn.jsdelivr.net/jqgrid/4.6.0/i18n/grid.locale-kr.js" /></script>
<!-- The atual jqGrid code -->
<script type="text/javascript" src="//cdn.jsdelivr.net/jqgrid/4.6.0/jquery.jqGrid.src.js" /></script>
	<script>
	    $(document).ready(function () {
	        // jqGrid 초기화
	        $("#grid").jqGrid({
	            datatype: 'json',            // 데이터 유형 (json, xml 등)
	            mtype: 'GET',                // HTTP 요청 방식 (GET 또는 POST)
	            colNames: ['번호','이름', '제목', '내용'], 
	            colModel: [
	            	{ name: 'seq', index: 'seq', width: 60, align: 'center', key: true },
	                { name: 'name', index: 'name', width: 60, align: 'center'},
	                { name: 'title', index: 'title', width: 300, align: 'left' },
	                { name: 'content', index: 'content', width: 100, align: 'center' }
	            ],
	            pager: '#pager',             // 페이저 위치 지정
	            rowNum: 10,                   // 한 페이지에 보여질 행 수
	            rowList: [10, 20, 30],        // 페이저의 행 수 선택 옵션
	            sortname: 'id',              // 초기 정렬 열
	            sortorder: 'asc',            // 초기 정렬 순서
	            viewrecords: true,           // 전체 레코드 수 표시
	            gridview: true,              // 성능 향상을 위한 옵션
	            autoencode: true,            // 데이터를 HTML 인코딩
	            caption: '게시판'             // 그리드 제목
	        });
	
	        // 서버에서 데이터를 가져와 그리드에 로드
	        $("#grid").jqGrid('setGridParam', { 
	            url: '/getBoards', 
	            datatype: 'json',
	            loadComplete: function(data) { // 데이터 로드 완료 후 콜백 함수
	                console.log(data); // 받아온 데이터를 콘솔에 출력
	            }
	        }).trigger('reloadGrid');
	    });
	</script>   
    <title>게시판</title>
</head>
<body>
    <h1>게시판</h1>
    <p><a href="write">새 글 작성</a></p>
	<table id="grid"></table>
	<div id="pager"></div>
</body>
</html>