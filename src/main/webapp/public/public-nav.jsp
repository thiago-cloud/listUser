<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Tag responsavel pela tradução da página -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
	    <a class="navbar-brand" href="#"><fmt:message key="public-nav.home"/></a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	     	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <!--<li class="nav-item">
		        	<a class="nav-link active" aria-current="page" href="#">Home</a>
		        </li>-->
		        <li class="nav-item">
		        	<a class="nav-link" href="${pageContext.request.contextPath}/public?acao=novo"><fmt:message key="public-nav.novo"/></a>
		        </li>
		        <li class="nav-item">
		        	<a class="nav-link" href="${pageContext.request.contextPath}/auth/admin?acao=listar"><fmt:message key="public-nav.listar"/></a>
		        </li>
		        <li class="nav-item">
		        	<a class="nav-link" href="${pageContext.request.contextPath}/I18nController?lingua=en_US"><fmt:message key="public-nav.ingles"/></a>
		        </li>
		        <li class="nav-item">
		        	<a class="nav-link" href="${pageContext.request.contextPath}/I18nController?lingua=pt_BR"><fmt:message key="public-nav.portugues"/></a>
		        </li>         
	     	</ul>     
	    </div>
	</div>
</nav>
    