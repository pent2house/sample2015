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
<title>sub_line_01(JSP)</title>
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
.tg .tg-4eph{background-color:#f9f9f9}
</style>
	<script src="
		<c:url value="/resources/core/jquery.1.10.2.min.js" />">
	</script>
	<script src="
		<c:url value="/resources/core/jquery.autocomplete.min.js" />">
	</script>
    <link href="
        <c:url value="/resources/core/main.css" />" rel="stylesheet">
    </head>
    <body bgcolor="#F6E3CE">
            <font face="Verdana">
                <h1 class="tg" style="font-size:150%">RMA Details</h1>
                <c:url var="addAction" value="/cUrlValAttrbSubLine01Jsp.html" ></c:url>
                <form:form action="${addAction}" commandName="rmaMapKey">
					<table border="0">
					    <tr>
					        <th width="20"></th>
					        <th align="left" width="120">RMA Number</th>
					        <th align="left" width="120">Item Code</th>
					        <th width="120"></th>
					        <th width="120"></th>
					    </tr>
					    <tr height="30">
					        <td></td>
					        <td>
					            <form:input path="rmaNum" id="idRmaNum" readonly="true" disabled="true" style="height:25px; width:200px" />
					            <form:hidden path="rmaNum" id="idRmaNum" />
					        </td>
					        <td>
					            <form:input path="mdseCd" id="idItemCd" style="height:25px; width:200px" />
					        </td>
					        <td>
					            <input type="submit" value="Add Item" name="addItemSubLine01" style="height:25px; width:150px; color: #F6FDA4; background-color: #0400FF; font-face: 'Comic Sans MS';" />
					        </td>
					        <td>
					            <input type="submit" value="Back to RMA" name="backToRmaFromSubLine01" style="height:25px; width:150px; color: #F6FDA4; background-color: #0400FF;" />
					        </td>
					    </tr>
					    <tr height="10">
					        <td colspan="5"></td>
					    </tr>
					</table>
					<table border="0">
					    <tr height="30">
					        <td width="80" style="font-size:130%">Detail</td>
					        <td width="160">
					            <input type="submit" value="Submit" name="submitLine" style="height:25px; width:150px; color: #F6FDA4; background-color: #CC0000; font-face: 'Comic Sans MS';" />
					        </td>
					        <td width="160">
					            <input type="submit" value="Delete Item" name="deleteLine" style="height:25px; width:150px; color: #F6FDA4; background-color: #FF0000; font-face: 'Comic Sans MS';" />
					        </td>
					    </tr>
					</table>
				   <div 
						style="width:1450px;
						height:30px;
						line-height:3em;
						padding:3px;">
                    <table class="tg" border="1">
                        <tr>
                            <td width="20"></td>
                            <td width="120">RMA#</td>
                            <td width="120">Detail Num</td>
                            <td width="130">Status</td>
                            <td width="511" colspan="2">Product</td>
                            <td width="120">Qty</td>
                            <td width="60">Edit</td>
                            <td width="60">Delete</td>
                        </tr>
                   </table>
                   </div> 
				   <div 
						style="width:1450px;
						height:550px;
						line-height:3em;
						overflow:scroll;
						padding:3px;
						scrollbar-base-color:#DEBB07;">
                   <table class="tg" border="1">                        
						<c:forEach items="${rmaLineListModel.rmaLineModelList}" var="rmaLnObj" varStatus="i" begin="0">
						<tr>
							<td width="20">
								<form:checkbox path="selectedCheckBox" value="${rmaLnObj.rmaLineNum}" />
							</td>
							<td width="120">
								<form:input path="rmaLineModelList[${i.index}].rmaNum" id="idRmaNum${i.index}" readonly="true" disabled="true" style="height:25px; width:110px" />
								<form:hidden path="rmaLineModelList[${i.index}].rmaNum" id="idLnNm${i.index}" />
							</td>
							<td width="120">
								<form:input path="rmaLineModelList[${i.index}].rmaLineNum" id="idLnNm${i.index}" readonly="true" disabled="true" style="height:25px; width:110px" />
								<form:hidden path="rmaLineModelList[${i.index}].rmaLineNum" id="idLnNm${i.index}" />
							</td>
							<td width="130">
							<c:choose>
								<c:when test="${rmaLnObj.getRmaLineStsCd()== ''}">
									<form:select 
										path="rmaLineModelList[${i.index}].rmaLineStsCd" 
										id="idLnStCd${i.index}" 
										style="height:25px; width:130px">
									<form:option  value="" label=""/>
									<form:options items="${HDR_STS_LIST}" itemValue="rmaHdrStsCd" itemLabel="rmaHdrStsNm"/>
									</form:select>
								</c:when>
								<c:otherwise>
									<form:select 
										path="rmaLineModelList[${i.index}].rmaLineStsCd"
										items="${HDR_STS_LIST}" 
										id="idLnStCd${i.index}"
										itemLabel="rmaHdrStsNm" 
										itemValue="rmaHdrStsCd" 
										delimiter=" " 
										readonly="true" 
										disabled="true" 
										style="height:25px; width:130px"/>
									<form:hidden path="rmaLineModelList[${i.index}].rmaLineStsCd" id="idLnStCd${i.index}" />
								</c:otherwise>
							</c:choose>
							</td>
							<td width="150">
								<form:input path="rmaLineModelList[${i.index}].mdseCd" id="idMdseCd${i.index}" readonly="true" disabled="true" style="height:25px; width:140px" />
								<form:hidden path="rmaLineModelList[${i.index}].mdseCd" id="idMdseCd${i.index}" />
							</td>
							<td width="350">
								<form:input path="rmaLineModelList[${i.index}].mdseNm" id="idMdseNm${i.index}" readonly="true" disabled="true" style="height:25px; width:320px" />
								<form:hidden path="rmaLineModelList[${i.index}].mdseNm" id="idMdseNm${i.index}" />
							</td>
							<td width="120">
							<c:choose>
							    <c:when test="${rmaLnObj.getRmaLineStsCd()== ''}">
							        <form:input path="rmaLineModelList[${i.index}].qty" id="idQty${i.index}" style="height:25px; width:110px" />
							    </c:when>
							    <c:otherwise>
							        <form:input path="rmaLineModelList[${i.index}].qty" id="idQty${i.index}" readonly="true" disabled="true" style="height:25px; width:110px" />
							        <form:hidden path="rmaLineModelList[${i.index}].qty" id="idQty${i.index}" />
							    </c:otherwise>
							</c:choose>
							</td>
							<td width="60">
								<a href="
									<c:url value='/edit/${rmaLnObj.rmaLineNum}' />" >Edit
							</a>
							</td>
							<td width="60">
								<a href="
									<c:url value='/remove/${rmaLnObj.rmaLineNum}' />" >Delete
							</a>
							</td>
						</tr>
						</c:forEach>
                    </table>
                    </div>
                </form:form>
            </font>
	<script>
	$(document).ready(function() {

	    $('#idItemCd').autocomplete({
	        serviceUrl: '${pageContext.request.contextPath}/autoCompleteList',
	        paramName: "inputVal",
	        delimiter: ",",
	        transformResult: function(response) {
	            return {
	                suggestions: $.map($.parseJSON(response), function(item) {
	                    return {
	                        value: item.mdseCd,
	                        data: item.id
	                    };
	                })
	            };
	        }
	    });
	});
	</script>
</body>
</html>
