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
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
<script src="<c:url value="/resources/js/jquery-3.3.1.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/script.js" />" type="text/javascript"></script>
<body>
  <!-- (1) -->
  <form:form modelAttribute="remindForm" onsubmit="return check()" action="${pageContext.request.contextPath}/remind_info">
    <table>
    	<tr>
    		<td>職員番号：</td>
    		<td><form:input path="id" /></td>
    		<td>職員氏名：</td>
    		<td><form:input path="name" /></td>
    		<td>面談年月：</td>
    		<td><form:input path="date" placeholder="yyyy-mmを入力ください"/><span><form:errors path="date" class="error_msg"/></span></td>
    	</tr>
    	<tr>
    		<td><input type="submit" /></td>
    		<td><input type="button" value="当月検索" id="dateSearch" /></td>
    	</tr>
    </table>
  </form:form>
  <div id="model_show">
	 <table id="table"  border="1" style="width: 100%;margin-top: 20px;">
		<tr>
			<th width="10%">名前</th>
			<th width="25%">現場場所</th>
			<th width="15%">プロジェクト名</th>
			<th width="15%">前回面談日付</th>
			<th width="15%">今回面談日付</th>
			<th width="15%">備考</th>
		</tr>
		<c:forEach var="listValue" items="${remindList}">
	      <tr>
	 		<td>${listValue.name}</td>
	 		<td>${listValue.work_place} ${listValue.customer}</td>
	 		<td>${listValue.project}</td>
	 		<td>${listValue.pre_interview}</td>
	 		<td>${listValue.post_interview}</td>
	 		<td>${listValue.bikou}</td>
	 	  </tr>
	    </c:forEach>
	  </table>
  </div>
  <div id="ajax_show">
  </div>
</body>
</html>