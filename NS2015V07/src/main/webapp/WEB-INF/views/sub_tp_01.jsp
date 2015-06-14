<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>sub_tp_01(JSP)</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body bgcolor="#EFB4B4">
<font face="Verdana">
<h1 style="font-size:200%">
	Type entry
</h1>
<c:url var="addAction" value="/cUrlValAttrbSubTp01Jsp.html" ></c:url>
<form:form action="${addAction}" commandName="rmaMapKey">
	<table cellspacing="5" border="0">
		<tr>
			<td>
				<form:label path="rtrnTpCd"><spring:message text="Type Code"/></form:label>
			</td>
			<td>
				<form:input path="rtrnTpCd" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="rtrnTpNm">
					<spring:message text="Type Name"/>
				</form:label>
			</td>
			<td>
				<form:input path="rtrnTpNm" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="sortNum">
					<spring:message text="Sort Number"/>
				</form:label>
			</td>
			<td>
				<form:input path="sortNum" />
			</td>
		</tr>
		<tr>		
			<td><input type="submit" value="Add Type" name="addType" style="height:25px; width:150px; color: #F6FDA4; background-color: #CC3300; font-face: 'Comic Sans MS';"/></td>
			<td><input type="submit" value="Back to RMA" name="backToRmaFromTp" style="height:25px; width:150px; color: #F6FDA4; background-color: #990000; font-face: 'Comic Sans MS';"/></td>
		</tr>
	</table>
</form:form>
<br>
<h3 style="font-size:150%">List of Type</h3>
<c:if test="${!empty TP_LIST}">
	<table class="tg">
	<tr>
		<th width="80">Type Code</th>
		<th width="120">Type Name</th>
		<th width="120">Sort Num</th>
		<th width="100">Delete</th>
		<th width="100">Go Reason</th>
	</tr>
	<c:forEach items="${TP_LIST}" var="rmaMapKey">
		<tr>
			<td>${rmaMapKey.rtrnTpCd}</td>
			<td>${rmaMapKey.rtrnTpNm}</td>
			<td>${rmaMapKey.sortNum}</td>
			<td><a href="<c:url value='/removeType/${rmaMapKey.rtrnTpCd}' />" >Delete</a></td>
			<td><a href="<c:url value='/detail/${rmaMapKey.rtrnTpCd}' />" >Reason</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</font>
</body>
</html>
