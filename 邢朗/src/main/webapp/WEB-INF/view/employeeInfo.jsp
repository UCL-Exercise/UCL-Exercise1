<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報</title>
<script src="<c:url value="/resources/js/script.js" />" type="text/javascript"></script>
<link href="<c:url value="/resources/css/employeeInfo.css" />" rel="stylesheet" type="text/css">
</head>
<body>
    <form:form modelAttribute="employeeForm" action="${pageContext.request.contextPath}/employeeInfo_result">
    <div class="header">
        <ul class="header_info">
            <li>名前：
            	<form:input path="name"/>
            </li>
            <li>得意言語：
            	<form:input path="skill" />
            </li>
            <li>住所：
                <form:input path="address" />
            </li>
            <li>仕事年数：
                <form:input path="exp_year" />
            </li>
        </ul>
        <div class="search">
        <input type="submit" />
      	<input type="button" value="クリアー" onclick="window.location.href='employeeInfo'"/>
        </div>
    </div>
    <div class="info_menu">
        <span>名前</span>
        <span>年齢</span>
        <span>得意言語</span>
        <span>仕事年数</span>
        <span>性別</span>
        <span class="adress">住所</span>
        <span class="prepare">備考</span>
        <span>操作</span>
    </div>
    <c:forEach var="listValue" items="${list}">
	      <div class="info_menu">
	 		<span>${listValue.name}</span>
	 		<span>${listValue.age}</span>
	 		<span>${listValue.skill}</span>
	 		<span>${listValue.exp_year}</span>
	 		<span>${listValue.sex}</span>
	 		<span class="adress">${listValue.address}</span>
	 		<span class="prepare">${listValue.comment}</span>
	 		<span>
                <button class="b1" onclick="window.location.href='employee_info'">詳細</button>
                <button class="b2">更新</button>
            </span>
	 	  </div>
	 </c:forEach>

    </form:form>
</body>
</html>