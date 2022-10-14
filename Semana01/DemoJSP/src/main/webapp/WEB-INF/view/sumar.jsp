<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SUMAR</title>
</head>
<body>
	<h1>SUMAR</h1>
	<form method="post" action="sumar2">
		<div>
			<label>Número 1:</label> 
			<input type="number" name="num1" />
		</div>
		<div>
			<label>Número 2:</label> 
			<input type="number" name="num2" />
		</div>
		<div>
			<input type="submit" value="Procesar" />
		</div>
	</form>
	
	<h1>REPORTE</h1>
	<h2>Autor: ${autor}</h2>
	<c:if test="${estado==1}">
		<table>
		<tr>
			<td>Número 1:</td>
			<td>${num1}</td>
		</tr>
		<tr>
			<td>Número 2:</td>
			<td>${num2}</td>
		</tr>
		<tr>
			<td>Suma:</td>
			<td>${suma}</td>
		</tr>
		</table>
	</c:if>
	<c:if test="${estado==-1}">
		<p style="color: red;">${mensaje}</p>
	</c:if>
	

</body>
</html>