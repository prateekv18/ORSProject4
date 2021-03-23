<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.rays.ors.util.DataUtility"%>
<%@page import="com.rays.ors.controller.CollegeCtl"%>
<%@page import="com.rays.ors.util.ServletUtility"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Add College</title>
<body>
	<form action="CollegeCtl" method="post">
		<%@include file="Header.jsp"%>

		<jsp:useBean id="bean" class="com.rays.ors.bean.CollegeBean"
			scope="request"></jsp:useBean>

		<div align="center">
			<h1>Add College</h1>

			<h2>
				<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font>
			</h2>

			<h2>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h2>

			<input type="hidden" name="id" value="<%=bean.getId()%>"><input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"><input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

			<table>
				<tr>
					<th align="left">Name<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="name" placeholder="Enter Name"
						style="width: 170px"
						value="<%=DataUtility.getStringData(bean.getName())%>"></td>
					<td style="position: fixed"><font color="red"><%=ServletUtility.getErrorMessage("name", request)%></font>
					</td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">Address<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="address"
						placeholder="Enter address" style="width: 170px"
						value="<%=DataUtility.getStringData(bean.getAddress())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("address", request)%>
					</font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">State<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="state"
						placeholder="Enter State name" style="width: 170px"
						value="<%=DataUtility.getStringData(bean.getState())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("state", request)%>
					</font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">City<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="city"
						placeholder="Enter city name" style="width: 170px"
						value="<%=DataUtility.getStringData(bean.getCity())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("city", request)%>
					</font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th align="left">PhoneNo<span style="color: red">*</span> :
					</th>
					<td><input type="text" name="phoneNo"
						placeholder="Enter Phone number" style="width: 170px"
						value="<%=DataUtility.getStringData(bean.getPhoneNo())%>"></td>
					<td style="position: fixed"><font color="red"> <%=ServletUtility.getErrorMessage("phoneNo", request)%>
					</font></td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th></th>
					<td colspan="2"><input type="submit" name="operation"
						value="<%=CollegeCtl.OP_SAVE%>"> <%
 	if (bean.getId() > 0) {
 %>&emsp;<input type="submit" name="operation"
						value="<%=CollegeCtl.OP_DELETE%>"> <%
 	}
 %> &emsp; <input type="submit" name="operation"
						value="<%=CollegeCtl.OP_CANCEL%>"></td>
				</tr>
			</table>
		</div>
	</form>

	<%@include file="Footer.jsp"%>
</body>
</html>