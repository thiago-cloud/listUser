<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Jstl-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Tag responsável pela tradução da página -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title><fmt:message key="public-new-user.title"/></title>

	<link
		href="${pageContext.request.contextPath}/resources/bootstrap-5.3.3-dist/css/bootstrap.min.css"
		rel="stylesheet" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jquery-3.7.0-dist/jquery-3.7.0.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/bootstrap-5.3.3-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="/public/public-nav.jsp"/>

	<div class="container">
		<div class="row">
			<div class="col">
				<h2><fmt:message key="public-new-user.cadastro"/></h2>

				<!--Para a estrutura condicional funcionar e necessário inserir o jstl-->
				<c:if test="${mensagem != null}">
				 	<div class="alert alert-success alert-dismissible fade show">
						<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
						<span><!--<c:out value="${mensagem}" />--> <fmt:message key="public-new-user.mensagem"/></span>
					</div>
				</c:if>

				<form
					action="${pageContext.request.contextPath}/public?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="public-new-user.nome"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="nome">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="public-new-user.cpf"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="cpf">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="public-new-user.nascimento"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="nascimento">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="public-new-user.email"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="email">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="public-new-user.usuario"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="user">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label"><fmt:message key="public-new-user.senha"/></label>
						<div class="col-sm-3">
							<input class="form-control" type="password" name="password">
						</div>
					</div>
					<button class="btn btn-primary" type="submit" ><fmt:message key="public-new-user.btn"/></button>
					<!--<input class="btn btn-primary" type="submit" value="Salvar" />-->
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>