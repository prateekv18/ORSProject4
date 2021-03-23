<%@page import="com.rays.ors.controller.ORSView"%>
<%@page import="com.rays.ors.controller.MyProfileCtl"%>
<%@page import="com.rays.ors.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.rays.ors.util.DataUtility"%>
<%@page import="com.rays.ors.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>My Profile</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : 'mm/dd/yy',
			//defaultDate : "06/06/2001",
			changeMonth : true,
			changeYear : true,
			//yearRange: "c-20:c+0",
			//yearRange : "1980:2002",
			//maxDate:'0',
			// minDate:0
			yearRange : "-40:-18"
		});
	});
</script>
<body>
	<form action="<%=ORSView.MY_PROFILE_CTL%>" method="post">

		<%@include file="Header.jsp"%>
		<jsp:useBean id="bean" class="com.rays.ors.bean.UserBean"
			scope="request"></jsp:useBean>

		<center>
			<h1>My Profile</h1>

			<h2>
				<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font>
			</h2>

			<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdBy" value="<%=bean.getCreatedBy()%>">
			<table>
				<tr>
					<th align="left">LoginId<font color="red">*</font></th>
					<td><input required="required" type="text" name="login" required="required"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"
						readonly="readonly"> <font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font>
					</td>
				</tr>
				<tr>
					<th align="left">First Name<font color="red">*</font></th>
					<td><input required="required" type="text" name="firstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>">
						<font color="red"><%=ServletUtility.getErrorMessage("firstName", request)%></font>
					</td>
				</tr>
				<tr>
					<th align="left">Last Name<font color="red">*</font></th>
					<td><input required="required" type="text" name="lastName"
						value="<%=DataUtility.getStringData(bean.getLastName())%>">
						<font color="red"><%=ServletUtility.getErrorMessage("lastName", request)%></font>
					</td>
				</tr>

				<tr>
					<th align="left">Gender</th>
					<td>
						<%
							HashMap map = new HashMap();
							map.put("M", "Male");
							map.put("F", "Female");

							String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
						%> <%=htmlList%>
					</td>
				</tr>

				<tr>
					<th align="left">Mobile No<font color="red">*</font></th>
					<td><input type="text" name="mobileNo"
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>">
						<font color="red"></font></td>
				</tr>

				<tr>
					<th align="left">Date Of Birth</th>
					<td>
						<input type="text" name="dob" id="datepicker" value="<%=DataUtility.getDateString(bean.getDob())%>"> 				
						<a href="javascript:getCalender(documents.forms[0].dob);"> <!-- <img	src="../img/Calender.jpg" width="16" height="15" border="0" alt="Calender"> -->
						</a> 
						<font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font>
					</td>
				</tr>

				<h2>
					<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
					</font>
				</h2>

				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=MyProfileCtl.OP_SAVE%>"> &nbsp; <input
						type="submit" name="operation"
						value="<%=MyProfileCtl.OP_CHANGE_MY_PASSWORD%>">&nbsp;</td>
				</tr>

			</table>
	</form>
	</center>
	<br>
	<br>
	<%@include file="Footer.jsp"%>
</body>
</html>