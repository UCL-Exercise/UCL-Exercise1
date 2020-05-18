<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>エラー画面</title>
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
<body>
エラー情報：<P class="error_msg">${message}</P>
</body>
</html>
