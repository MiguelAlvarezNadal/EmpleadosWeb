<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.estilo{border: solid thick purple;border-radius:20px;padding:20px;text-align:center;color: blue;
		margin: auto;margin-top: 50px;width: 300px;height:200px;background-color:orange;}
	.estilo:hover{width:450px;height:250px;background-color:orange;padding:50px;}
	span{color:green;font-weight:bolder;font-size:20px;}
	a{text-decoration:none;float:right;margin-right:300px;margin-top:10px;}
</style>
</head>
<body>
<a href="CerrarSesion">Cerrar Sesion</a>
<div class="estilo">
	<h1 style="color: black">Info Empleado </h1>
	<span>Nombre:</span> ${empleado.nombre }<br/>
	<span>Apellido:</span> ${empleado.apellido }<br/>
	<span>ID:</span> ${empleado.id }<br/>
	<span>Email:</span> ${empleado.email }
</div>
</body>
</html>