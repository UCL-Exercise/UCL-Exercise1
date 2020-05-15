<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Echo Application</title>
</head>
<body>
	<table>
		<tr>
			<td>NAME:</td>
			<td>${form.name}</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>名前</td>
			<td>年齢</td>
			<td>得意言語</td>
			<td>仕事年数</td>
			<td>性別</td>
			<td>住所</td>
			<td>備考</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<c:forEach var="listValue" items="${list}">
	      <tr>
	 		<td>${listValue.name}</td>
	 		<td>${listValue.age}</td>
	 		<td>${listValue.skill}</td>
	 		<td>${listValue.exp_year}</td>
	 		<td>${listValue.sex}</td>
	 		<td>${listValue.address}</td>
	 		<td>${listValue.comment}</td>
	 		<td><a href="${pageContext.request.contextPath}/update?id=${listValue.id}">修正</a></td>
	 		<td><a href="${pageContext.request.contextPath}/delete?id=${listValue.id}">削除</a></td>
	 	</tr>
	  </c:forEach>
	</table>
</body>
</html>