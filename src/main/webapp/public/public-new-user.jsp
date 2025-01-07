<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>

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
				<h2>Cadastrar novo usuário</h2>
				<form
					action="${pageContext.request.contextPath}/public?acao=inserir"
					method="post">

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Nome</label>
						<div class="col-sm-5">
							<input class="form-control" type="text" name="nome">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">CPF</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="cpf">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Nascimento</label>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="nascimento">
						</div>
					</div>


					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Email</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="email">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Usuário</label>
						<div class="col-sm-2">
							<input class="form-control" type="text" name="user">
						</div>
					</div>

					<div class="row mb-3">
						<label class="col-sm-1 col-form-label">Senha</label>
						<div class="col-sm-2">
							<input class="form-control" type="password" name="password">
						</div>
					</div>

					<input class="btn btn-primary" type="submit" value="Salvar" />
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>