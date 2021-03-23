<%@page import="com.rays.ors.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.rays.ors.controller.LoginCtl"%>
<%@page import="com.rays.ors.util.DataUtility"%>
<%@page import="com.rays.ors.util.ServletUtility"%>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>img/kkkk.png" sizes="16*16" />
<title>Login Page</title>

</head>
<body>
	<form action="<%=ORSView.LOGIN_CTL%>" method="post">
		<%@ include file="Header.jsp"%>

		<jsp:useBean id="bean" class="com.rays.ors.bean.UserBean"
			scope="request"></jsp:useBean>

		<center>
			<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
				type="hidden" name="CreatedBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="ModifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

			<div align="center">
				<h1>Login</h1>
				<h2>
					<font color="red"><%=ServletUtility.getErrorMessage(request)%>
					</font>
				</h2>
				<H2>
					<font color="Green"> <%=ServletUtility.getSuccessMessage(request)%></font>
				</H2>

				<%
					String msg = (String) request.getAttribute("message");
					if (msg != null) {
				%>
				<h2 align="center">
					<font style="color: red"><%=msg%></font>
					<%
						}
					%>
				</h2>

			</div>
			<table>
				<tr>
					<th align="left">Username<span style="color: red">*</span></th>
					<td><input type="text" name="login"
						placeholder="Enter Login-ID" size=25
						value="<%=DataUtility.getStringData(bean.getLogin())%>"></td>

					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>

				<tr>
					<th style="padding: 1px"></th>
				</tr>
				<tr>
					<th></th>
				</tr>

				<tr>
					<th align="left">Password<span style="color: red">*</span></th>
					<td><input type="password" name="password"
						placeholder="Enter password" size=25
						value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
					<td style="position: fixed;"><font color="red"><%=ServletUtility.getErrorMessage("password", request)%></font>
					</td>
				</tr>

				<tr>
					<th style="padding: 3px"></th>
				</tr>

				<tr>
					<th></th>
				</tr>

				<tr>
					<th></th>
					<td colspan="4">&nbsp; <input type="submit" name="operation"
						value="<%=LoginCtl.OP_SIGN_IN%>"> &nbsp; <input
						type="submit" name="operation" value="<%=LoginCtl.OP_SIGN_UP%>">
					</td>
				</tr>
				<tr>
					<th style="padding: 3px"></th>
				</tr>
				<tr>
					<th></th>
					<td><font size="4px" ; color="red"><a
							href="<%=ORSView.FORGET_PASSWORD_CTL%>"><b>Forget my
									password</b></a></font></td>
				</tr>
			</table>
	</form>
	</center>
	</div>
	<%@ include file="Footer.jsp"%>

	</table>
	</center>
	</form>
</body>
</html>