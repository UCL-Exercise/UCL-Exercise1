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
  <!-- (1) -->
  <form:form modelAttribute="employeeForm" action="${pageContext.request.contextPath}/data_add">
    <table>
    	<tr>
    		<td>職員ID：</td>
    		<td><form:input path="id"/></td>
    		<td>職員氏名：</td>
    		<td><form:input path="name" class="input_error"/><span><form:errors path="name" class="error_message"/></span></td>
    	</tr>
    	<tr>
    		<td>職員性別：</td>
    		<td><form:input path="sex" /></td>
    		<td>職員年齢：</td>
    		<td><form:input path="age" /></td>
    	</tr>
    	<tr>
    		<td>得意言語：</td>
    		<td><form:input path="skill" /><form:errors path="skill" /></td>
    		<td>仕事年数：</td>
    		<td><form:input path="exp_year" /><form:errors path="exp_year" /></td>
    	</tr>
    	<tr>
    		<td>住所：</td>
    		<td><form:input path="address" /><form:errors path="address" /></td>
    		<td>国籍：</td>
    		<td><form:input path="nation" /><form:errors path="nation" /></td>
    	</tr>
    	<tr>
    		<td>備考：</td>
    		<td><form:input path="comment" /></td>
    	</tr>
    	<tr>
    		<td><input type="submit" /></td>
    	</tr>
    </table>
  </form:form>
</body>
</html>