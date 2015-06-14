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
	<title>sub_tp_rsn_01(JSP)</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
</head>
<body bgcolor="#C4F7D4">
<font face="Verdana">
<h1 style="font-size:200%">
	Type and Reason
</h1>
<c:url var="addAction" value="/cUrlValAttrbSubTpRsn01Jsp.html" ></c:url>
<form:form action="${addAction}" commandName="rmaMapKey">
<table cellspacing="5" border="0">
	<tr>
		<td>Type</td>
		<td>
			<form:select path="rtrnTpCd" id="tpCd" onchange="onChangeTp();" style="height:25px; width:200px">
			   <form:option value="" label="--- Select Type ---"/>
			   <c:forEach items="${TP_LIST}" var="name">
			      <c:choose>
			         <c:when test="${name.getRtrnTpCd()== TP_SELECTED}">
			            <form:option value="${name.getRtrnTpCd()}" selected="true">${name.getRtrnTpNm()}</form:option>
			         </c:when>
			         <c:otherwise>
			            <form:option value="${name.getRtrnTpCd()}">${name.getRtrnTpNm()}</form:option>
			         </c:otherwise>
			      </c:choose>
			   </c:forEach>
			</form:select>
		</td>
		<td>
			<input type="submit" value="Back to RMA" name="backToRmaFromTpRsn" style="height:25px; width:150px; color: #F6FDA4; background-color: #0400FF;"/>
		</td>
	</tr>
	<tr height="15"><td colspan="3"></td></tr>
</table>
<br>
<table border="0">
	<tr>
		<td width="50">
		</td>
		<td width="1000">
			<table border="0">
				<tr>
					<td width="350" valign="top">
						<h3 style="font-size:150%">List of Bound Reason</h3>
						<table>
							<tr><td align="left"><input type="submit" id="id_toUnBoundBtn" value="Un-Bound" name="toUnBoundRsnList"/></td></tr>
							<tr>
								<td>
								  <div class="id_Bound">
									<table id="idTableRsnBound" class="tg" border="1">
										<tr>
											<th width="20"></th>
											<th width="80">Reason Code</th>
											<th width="120">Reason Name</th>
										</tr>							
										<c:forEach items="${RSN_LIST_BOUND}" var="rsnVal" varStatus="loop">
											<tr>
												<td><form:checkbox path="selectedCheckBox" value="${rsnVal.rtrnRsnCd}"/></td>
												<td>${rsnVal.rtrnRsnCd}</td>
												<td>${rsnVal.rtrnRsnNm}</td>
											</tr>
										</c:forEach>
									</table>
								  </div>
								</td>
							</tr>
						</table>
					</td>
					<td width="400" valign="top">
						<h3 style="font-size:150%">List of Un-Bound Reason</h3>
						<table>
							<tr><td align="left"><input type="submit" id="id_toBoundBtn" value="Bound" name="toBoundRsnList"/></td></tr>
							<tr>
								<td>
								  <div class="id_UnBound">
									<table id="idTableRsnUnBound" class="tg" border="1">
										<tr>
											<th width="20"></th>
											<th width="80">Reason Code</th>
											<th width="120">Reason Name</th>
										</tr>
										<c:forEach items="${RSN_LIST_UNBOUND}" var="rsnVal" varStatus="loop">
											<tr>
												<td><form:checkbox path="selectedCheckBox" value="${rsnVal.rtrnRsnCd}"/></td>
												<td>${rsnVal.rtrnRsnCd}</td>
												<td>${rsnVal.rtrnRsnNm}</td>
											</tr>
										</c:forEach>
									</table>
								  </div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form:form>
</font>

<script type="text/javascript">

	function onChangeTp() {
	   var selectedTpCd = $('#tpCd').val();
	   $.ajax({
	      type : "Get", 
	      url : "onChangeTpCdTpRsn01",
	      data : "tpCd=" + selectedTpCd,
	      success : function(response) {
	         // Remove the row excluding the first row
	         $("#idTableRsnBound").find("tr:gt(0)").remove();
	         $("#idTableRsnUnBound").find("tr:gt(0)").remove();

	         var trHtmlBound = '';
	         var trHtmlUnBound = '';
	         $.each(response, function(k, v) {
	            var thisTpCd = v.rtrnTpCd;
	            if(thisTpCd == selectedTpCd) {
	               trHtmlBound = getRsnLines(trHtmlBound, k, v);
	            } else {
	               trHtmlUnBound = getRsnLines(trHtmlUnBound, k, v);
	            }
	         });

	         $('#idTableRsnBound').append(trHtmlBound);
	         $('#idTableRsnUnBound').append(trHtmlUnBound);
	      },
	      error : function(e) {
	         alert('Error onChangeTp: ' + e);
	      }
	   });
	}
	
	function getRsnLines(trHtml, idx, dataObj) {
	   //Get each key and value from the list
	   var code = dataObj.rtrnRsnCd;
	   var val = dataObj.rtrnRsnNm;
	   trHtml +=
		      '<tr>'
		      + '<td>'
		      +   '<input id="selectedCheckBox'+idx+'" name="selectedCheckBox" type="checkbox" value="'+code+'"/>'
		      + '</td>'
		      + '<td>'+code+'</td>'
		      + '<td>'+val+'</td>'
		      +'</tr>';

	   return trHtml;
	}

	function onClickRsn() {
	   var tpCd = $('#tpCd').val();
	   alert('test='+tpCd);
	       $.ajax({
	       type : "Get", 
	       url : "toBoundRsn", //toBoundByButton
	       data : "tpCd=" + tpCd,
	       success : function(response) {
	          alert(response);
	       },
	       error : function(e) {
	          alert('Error: ' + e);
	       }
	   });
	}
 
</script>

</body>
</html>
