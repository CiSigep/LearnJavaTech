<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input</title>
</head>
<body>
	<s:form action="output">
		<s:textfield name="input.input" ></s:textfield>
		<s:submit></s:submit>
	</s:form>

</body>
</html>