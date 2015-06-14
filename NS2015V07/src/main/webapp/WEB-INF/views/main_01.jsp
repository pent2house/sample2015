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
	<title>main_01(JSP)</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
	<meta name="robots" content="noindex,nofollow"/> 
	<title>This is demo</title> 
	<link rel="stylesheet" href="/resources/themes/master.css" type="text/css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
	<script src="/resources/scripts/mysamplecode.js" type="text/javascript"></script>
</head>
<body bgcolor="#D9FFF9">
<font face="Verdana">
<h1 class="tg" style="font-size:150%">RMA entry</h1>
<c:url var="addAction" value="/cUrlValAttrbMain01Jsp.html" ></c:url>
<form:form action="${addAction}" commandName="rmaMapKey">
	<table border="0">
	   <tr height="27">
	      <td><form:label path="id"><spring:message text="ID"/></form:label></td>
	      <td colspan="3">
	         <form:input path="id" id="idId" readonly="true" size="8"  disabled="true" style="height:25px; width:200px"/>
	         <form:hidden path="id" id="idId" />
	      </td> 
	   </tr>
	   <tr height="27">
	      <td><form:label path="rmaNum"><spring:message text="RMA number"/></form:label></td>
	      <td colspan="3">
	         <form:input path="rmaNum" id="idRmaNum" readonly="true" disabled="true" style="height:25px; width:200px"/>
	         <form:hidden path="rmaNum" id="idRmaNum" />
	      </td>
	   </tr>
	   <tr height="27">
	      <td><form:label path="rtrnTpCd"><spring:message text="Return Type"/></form:label></td>
	      <td>
	         <!--<form:select path="rtrnTpCd" items="${TP_LIST}" itemLabel="rtrnTpNm" itemValue="rtrnTpCd" delimiter=" " style="height:20px; width:200px"/>-->
	         <div class="id_tpCd">
	            <form:select path="rtrnTpCd" id="idSelectTpCd" onchange="onChangeTp();" style="height:25px; width:200px">
	               <form:option value="" label="--- Select Type ---"/>
	               <form:options items="${TP_LIST}" itemValue="rtrnTpCd" itemLabel="rtrnTpNm"/>
	            </form:select>
	         </div>
	      </td>
	      <td><input type="submit" value="Edit Type" name="goToTp" style="height:20px; width:100px"/></td>
	      <td><input type="submit" value="Combination" name="goToTpRsn" style="height:22px; width:100px; color: #F6FDA4; background-color: #01690D;"/></td>
	   </tr>
	   <tr height="27">
	      <td><form:label path="rtrnRsnCd"><spring:message text="Return Reason"/></form:label></td>
	      <td>
	         <!--<form:select path="rtrnRsnCd" items="${RSN_LIST}" itemLabel="rtrnRsnNm" itemValue="rtrnRsnCd" delimiter=" " style="height:20px; width:200px"/>-->
	         <div class="id_RsnCd">
	         <form:select path="rtrnRsnCd" id="idSelectRsnCd" style="height:25px; width:200px">
	            <form:option value="" label="--- Select Reason ---"/>
	            <form:options items="${RSN_LIST}" itemValue="rtrnRsnCd" itemLabel="rtrnRsnNm"/>
	         </form:select>
	         </div>
	      </td>
	         <td colspan="2">
	         <input type="submit" value="Edit Reason" name="goToRsn" style="height:20px; width:100px"/>
	      </td>
	   </tr>
	   <tr height="27">
	      <td><form:label path="sellToCustCd"><spring:message text="Costomer Code"/></form:label></td>
	      <td colspan="3">
	         <form:input path="sellToCustCd" id="idSellTo" style="height:25px; width:200px"/>
	      </td>
	   </tr>
	   <tr height="27">
	      <td><form:label path="rmaHdrStsCd"><spring:message text="Header status"/></form:label></td>
	      <td colspan="3">
	         <div class="id_HdrSts">
	            <form:select path="rmaHdrStsCd" items="${HDR_STS_LIST}" id="idSelectStsCd" itemLabel="rmaHdrStsNm" itemValue="rmaHdrStsCd" delimiter=" " style="height:25px; width:200px"/>
	         </div>
	      </td>
	   </tr>
	   <tr height="15"><td colspan="4"></td></tr>
	   <tr>
	      <td colspan="4">
	         <input type="button" id="idSubmitHdr" value="Update RMA" style="height:25px; width:150px; color: #F6FDA4; background-color: #0400FF; font-face: 'Comic Sans MS';"/>
	         <input type="submit" value="Submit" name="submitHdr" style="height:25px; width:150px; color: #F6FDA4; background-color: #CC0000; font-face: 'Comic Sans MS';"/>
	      </td>
	   </tr>
	</table>
<h3 style="font-size:150%">List of RMA header</h3>

<div 
	style="width:1450px;
	height:350px;
	line-height:3em;
	overflow:scroll;
	padding:5px;
	scrollbar-base-color:#DEBB07;">

	<c:if test="${!empty HDR_LIST}">
		<table id="IdHdrDtl" class="tg">
		<tr height="20">
			<th width="20"></th>
			<th width="20"></th>
			<th width="80">ID</th>
			<th width="120">RMA#</th>
			<th width="180" colspan="2">Header Status</th>
			<th width="180" colspan="2">Type</th>
			<th width="220" colspan="2">Reason</th>	
			<th width="120">Sell To</th>
			<th width="100">Edit Header</th>
			<th width="100">Delete Header</th>
			<th width="100">Go Detail</th>
		</tr>
		<c:forEach items="${HDR_LIST}" var="rmaObj" varStatus="loop">
			<tr height="15">
				<td><form:radiobutton path="radioBtn" class='close clickIdx' data-id='${rmaObj.id}' /></td>
				<td><form:checkbox path="selectedCheckBox" value="${rmaObj.rmaNum}"/></td>
				<td id="id${loop.index}">${rmaObj.id}</td>
				<td id="idRmaNum${loop.index}">${rmaObj.rmaNum}</td>
				<td id="idStsCd${loop.index}">${rmaObj.rmaHdrStsCd}</td>
				<td id="idStsNm${loop.index}">${rmaObj.rmaHdrStsNm}</td>
				<td id="idTpCd${loop.index}">${rmaObj.rtrnTpCd}</td>
				<td id="idTpNm${loop.index}">${rmaObj.rtrnTpNm}</td>
				<td id="idRsnCd${loop.index}">${rmaObj.rtrnRsnCd}</td>				
				<td id="idRsnNm${loop.index}">${rmaObj.rtrnRsnNm}</td>
				<td id="idCustCd${loop.index}">${rmaObj.sellToCustCd}</td>
				<td><a href="<c:url value='/edit/${rmaObj.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/remove/${rmaObj.id}' />" >Delete</a></td>
				<td><a href="<c:url value='/cUrlValSubLine01Jsp/${rmaObj.rmaNum}' />" >Detail</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</div>
</form:form>
</font>

<script type="text/javascript">

	$(function() {
	   $('#idSubmitHdr').on('click',function() {

	      var idId = $("#idId").val();
	      var idRmaNum = $("#idRmaNum").val();
	      var id_tpCd = $("div.id_tpCd select").val();
	      var id_RsnCd = $("div.id_RsnCd select").val();
	      var idSellTo = $("#idSellTo").val();
	      var id_HdrSts = $("div.id_HdrSts select").val();

	      var rmaHdrModel = {
	         "id" : idId,
	         "rmaNum" : idRmaNum,
	         "rtrnTpCd" : id_tpCd,
	         "rtrnRsnCd" : id_RsnCd,
	         "sellToCustCd" : idSellTo,
	         "rmaHdrStsCd" :id_HdrSts
	      }
	      $.ajax({
	         type : 'POST', 
	         url : 'submitHdrByJsonMain01',
	         contentType : 'application/json; charset=utf-8',
	         dataType : 'json',
	         data: JSON.stringify(rmaHdrModel),
	         success : function(data) {
	            modifyRowData(data);
	         },
	         error : function(e) {
	            alert("error:" +response+ ":" +e);
	         }
	      });
	   });
	});
	
	function modifyRowData(newData) {
	   var id = newData.id;
	   var rmaNum = newData.rmaNum;
	   var stsCd = newData.rmaHdrStsCd;
	   var stsNm = newData.rmaHdrStsNm;
	   var tpCd = newData.rtrnTpCd;
	   var tpNm = newData.rtrnTpNm;
	   var rsnCd = newData.rtrnRsnCd;
	   var rsnNm = newData.rtrnRsnNm;
	   var custCd = newData.sellToCustCd;

	   $('#IdHdrDtl tr').each(function() { 
	      var currRmaNum = $(this).find('td').eq(3).text(); // rmaNum
	      var currStsCd = $(this).find('td').eq(4).text(); // StsCd
	      var currStsNm = $(this).find('td').eq(5).text();
	      var currTpCd = $(this).find('td').eq(6).text(); // TpCd
	      var currTpNm = $(this).find('td').eq(7).text();
	      var currRsnCd = $(this).find('td').eq(8).text(); // RsnCd
	      var currRsnNm = $(this).find('td').eq(9).text();
	      var currCustCd = $(this).find('td').eq(10).text(); // CustCd

	      var idRmaNum = $(this).find('td').eq(3).attr('id');
	      var idStsCd = $(this).find('td').eq(4).attr('id');
	      var idStsNm = $(this).find('td').eq(5).attr('id');
	      var idTpCd = $(this).find('td').eq(6).attr('id');
	      var idTpNm = $(this).find('td').eq(7).attr('id');
	      var idRsnCd = $(this).find('td').eq(8).attr('id');
	      var idRsnNm = $(this).find('td').eq(9).attr('id');
	      var idCustCd = $(this).find('td').eq(10).attr('id');

	      if(rmaNum == currRmaNum) {
	         $("#"+ idStsCd).html(stsCd);
	         $("#"+ idStsNm).html(stsNm);
	         $("#"+ idTpCd).html(tpCd);
	         $("#"+ idTpNm).html(tpNm);
	         $("#"+ idRsnCd).html(rsnCd);
	         $("#"+ idRsnNm).html(rsnNm);
	         $("#"+ idCustCd).html(custCd);
	         return false;
	      }
	   });
	}

	$(function() {
	   $(document).on('click', '.clickIdx', function() {
	      var $this = $(this);
	      var number = $this.data('id');
	      $.ajax({
	         type : 'POST', 
	         url : 'onCheckRadioRmaMain01',
	         dataType : 'json',
	         data : "idx=" + number,
	         success : function(data) {
	            var id = data.id;
	            var rmaNum = data.rmaNum;
	            var rtrnTpCd = data.rtrnTpCd;
	            var rtrnRsnCd = data.rtrnRsnCd;
	            var sellToCustCd = data.sellToCustCd;
	            var rmaHdrStsCd = data.rmaHdrStsCd;
	            $("#idId").val(id);
	            $("#idRmaNum").val(rmaNum);
	            $("div.id_tpCd select").val(rtrnTpCd);
	            $("div.id_RsnCd select").val(rtrnRsnCd);
	            $("#idSellTo").val(sellToCustCd);
	            $("div.id_HdrSts select").val(rmaHdrStsCd);
	         },
	         error : function(e) {
	            alert("error:" +response+ ":" +e);
	         }
	      });
	   });
	});

</script>

<script type="text/javascript">

	function onChangeTp() {
	   var tpCd = $('#idSelectTpCd').val();
	   $.ajax({
	      type : "Get", 
	      url : "onChangeTpCdRsnMain01",
	      dataType: 'json',
	      data : "tpCd=" + tpCd,
	      success : function(data) {
	         refreshCombo(data, "idSelectRsnCd");
	      },
	      error : function(e) {
	         alert("error:" +response+ ":" +e);
	      }
	   });
	}

	function refreshCombo(dataList, comboId) {
	   // Remove all current itmes
	   $("#"+ comboId).children('option:not(:first)').remove();
	   $.each(dataList, function(k, v) {
	      // Get each key and value from the list
	      var code = v.rtrnRsnCd;
	      var val = v.rtrnRsnNm;
	      $("#"+ comboId)
	         // Set the key and value
	         .append($("<option></option>")
	         .attr("value",code)
	         .text(val)
	      );
	   });
	}
	
	function onClickRma() {

	    var tpCd = $('#rmaRadio').val();
	    alert('test='+tpCd);
		    $.ajax({
		    type : "Get", 
		    url : "onClickRma", //toBoundByButton
		    data : "tpCd=" + tpCd,
		    success : function(response) {
		    	//alert(response);
		    },
		    error : function(e) {
		       //alert('Error: ' + e);
		    }
	    });
	 }

</script>

<script type="text/javascript">
	var countUnBoundChecked = function() {
	  var n1 = $("div.id_UnBound input:checked").length;
	  if( n1 > 0 ) {
		  $("#id_toBoundBtn").prop("disabled", false);
	  } else {
		  $("#id_toBoundBtn").prop("disabled", true);
	  }
	};
	countUnBoundChecked();	 
	$("div.id_UnBound input[type=checkbox]").on( "click", countUnBoundChecked );
</script>

</body>
</html>
