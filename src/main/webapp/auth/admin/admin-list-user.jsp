<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Jstl-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Essa tag do jstl serve para fazer formatação de data "fmt" e a representação da tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title> Usuários | listUser </title>

	<link
		href="${pageContext.request.contextPath}/resources/bootstrap-5.3.3-dist/css/bootstrap.min.css"
		rel="stylesheet" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jquery-3.7.0-dist/jquery-3.7.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/bootstrap-5.3.3-dist/js/bootstrap.min.js"></script>

</head>
<body>

	<!-- Header -->
	<jsp:include page="/public/public-nav.jsp"/>
	
	<!-- Body -->
	<div class="container">
		<div class="row">
			<div class="col">
				<h2>
					Usuários
				</h2>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Cpf</th>
							<th>Nascimento</th>
							<th>E-mail</th>
							<th>Ativado?</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${listarUsuarios}">
							<tr>
								<td><c:out value="${usuario.id}" /></td>
								<td><c:out value="${usuario.nome}" /></td>
								<td><c:out value="${usuario.cpf}" /></td>
								<!-- Usando a tag fmt do jstl -->
								<td>
									<fmt:formatDate value='${usuario.dataNascimento}'
										type='date' pattern='dd/MM/yyyy' />
								</td>
								<td><c:out value="${usuario.email}" /></td>
								<td>
									<!-- Esse if ternario mostra que se o usuario e == true mostre ATIVO senão mostre NÃO ATIVO -->
									<span> <c:out value= "${usuario.ativo=='true' ? 'ATIVO' : 'NÃO ATIVO'}" /> </span>
								</td>
								<td> 																			
									<a class="btn btn-outline-danger btn-sm"
									onclick="return confirm('Você deseja apagar?');"
									href="${pageContext.request.contextPath}/auth/admin?acao=apagar&id=<c:out value="${usuario.id}" />">
										Apagar
									</a>
								</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>