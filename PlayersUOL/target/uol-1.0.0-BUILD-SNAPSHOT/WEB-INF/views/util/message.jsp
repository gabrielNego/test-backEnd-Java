<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.warnblock {
	color: #000;
	background-color: #FFFF00;
	border: 3px solid #000000;
	padding: 8px;
	margin: 16px;
	text-align: center;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #F0E68C;
	padding: 8px;
	margin: 16px;
	text-align: center;
}

.successblock {
	color: #000;
	background-color: #32CD32;
	border: 3px solid #00FF00;
	padding: 8px;
	margin: 16px;
	text-align: center;
}
</style>
</head>

<body>
	<c:if test="${not empty warnMsg}">
		<div class="warnblock">
			<h2>Atenção</h2>
			<h4>${warnMsg}</h4>
		</div>
	</c:if>

	<c:if test="${not empty errMsg}">
		<div class="errorblock">
			<h2>Ocorreu um erro durante o processo</h2>
			<h4>${errMsg}</h4>
		</div>
	</c:if>
	<c:if test="${not empty successMsg}">
		<div class="successblock">
			<h2>Operação realizada com sucesso!</h2>
			<h4>${successMsg}</h4>
		</div>
	</c:if>
	<br>
	<a href="${url }">Voltar</a>
</body>
</html>