<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/script.js" />" type="text/javascript"></script>
<body onload="init('${remindList}')">
<h1>
	<a href= "${pageContext.request.contextPath}/input">Hello world!</a><br>
	<a href= "${pageContext.request.contextPath}/remind_info">面談情報</a>
</h1>
<div class="modal js-modal">
    <div class="modal__bg js-modal-close"></div>
    <div class="modal__content">
    	<b>下記社員の面談予定日が過ぎました。</b>
		<table border="1" style="width: 100%">
			<tr>
				<th width="15%">名前</th>
				<th width="35%">現場場所</th>
				<th width="25%">今回面談日付</th>
				<th width="25%">備考</th>
			</tr>
			<c:forEach var="listValue" items="${remindList}">
		      <tr>
		 		<td>${listValue.name}</td>
		 		<td>${listValue.work_place} ${listValue.customer}</td>
		 		<td>${listValue.post_interview}</td>
		 		<td>${listValue.bikou}</td>
		 	  </tr>
		    </c:forEach>
		</table>
    </div>
</div>
</body>
</html>
