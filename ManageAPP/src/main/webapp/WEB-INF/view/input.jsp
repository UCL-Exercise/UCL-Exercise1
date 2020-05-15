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
<script src="<c:url value="/resources/js/script.js" />" type="text/javascript"></script>
<body>
  <!-- (1) -->
  <form:form modelAttribute="employeeForm" action="${pageContext.request.contextPath}/show">
    <table>
    	<tr>
    		<td>職員ID：</td>
    		<td><form:input path="id" /></td>
    		<td>職員氏名：</td>
    		<td><form:input path="name" /></td>
    	</tr>
    	<tr>
    		<td><input type="submit" /></td>
    	</tr>
    </table>
  </form:form>
  <input type="button" value="新規追加" onclick="clickBtn('${pageContext.request.contextPath}')"/>
</body>
</html>