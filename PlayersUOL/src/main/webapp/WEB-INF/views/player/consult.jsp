<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Players</title>
</head>
<body>
	<h2>Jogadores cadastrados</h2>
	<c:if test="${not empty listPlayer}">
		<table>
			<tr>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Telefone</th>
				<th>Codinome</th>
				<th>Grupo</th>
			</tr>

			<c:forEach var="player" items="${listPlayer}">
				<tr>
					<td>${player.name}</td>
					<td>${player.email}</td>
					<td>${player.phone}</td>
					<td>${player.codeName}</td>
					<td>${player.group}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty listPlayer}">
		<h4>Sem registros!</h4>
	</c:if>
	<div>
		<a href="${url}">Cadastrar</a>
	</div>
</body>
</html>