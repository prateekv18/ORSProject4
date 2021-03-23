<%@page import="com.rays.ors.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/ctm_logo.png" sizes="16*16" />
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<form action="<%=ORSView.WELCOME_CTL%>">

		<h1 align="center">
			<font size="10px" color="red">Welcome to ORS </font>
		</h1>

		<%
			UserBean bean = (UserBean) session.getAttribute("user");
			if (bean != null) {
				if (bean.getRoleId() == RoleBean.STUDENT) {
		%>

		<h2 align="Center">
			<font style="size: 10px; color: cyan"> <a
				href="<%=ORSView.GET_MARKSHEET_CTL%>">Click here to view your
					Marksheet </a>
			</font>
		</h2>

		<%
			}
			}
		%>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>