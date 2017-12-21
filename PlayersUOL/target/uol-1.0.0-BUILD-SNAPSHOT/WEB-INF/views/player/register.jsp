<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script type="text/javascript">
	function goToList() {
		window.location.href = document.getElementById("url").value;
	}
</script>
<style type="text/css">
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<spring:url value="/register/player" var="registerURL" />
	<input type="hidden" value="${url }" id="url">
	<div>
		<div>
			<h2>Cadastro do jogador UOL</h2>
		</div>
		<div>
			<form:form action="${registerURL }" method="post"
				modelAttribute="playerForm">
				<table>
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>E-mail:</label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>
					<tr>
						<td><label>Telefone:</label></td>
						<td><form:input path="phone" /></td>
					</tr>
				</table>
				<div>
					<label>Quero ser do grupo:</label> <br>
					<form:radiobutton path="group" value="1" label="Liga da Justiça" checked="checked"/>
					<br>
					<form:radiobutton path="group" value="0" label="Os Vingadores" />
				</div>
				<div>
					<input type="submit" value="Cadastrar"> <input
						type="button" value="Lista jogadores" onclick="goToList()">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>