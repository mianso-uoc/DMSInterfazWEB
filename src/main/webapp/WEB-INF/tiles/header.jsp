<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authentication var="usuario" property="principal" />
<c:choose>
	<c:when test="${usuario ne 'anonymous' && usuario.type eq 'Administrator'}">
		<c:set var="color" value="secondary"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="color" value="primary"></c:set>
	</c:otherwise>
</c:choose>
<header class="navbar navbar-expand-lg navbar-dark bg-${color}">
	<div class="container-fluid">
		<a class="navbar-brand" href="/inicio"><i class="bi bi-tools"></i>
			DSMantenimiento</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<sec:authorize access="isAuthenticated()">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="/machines">Máquinas</a></li>
					
					<c:if test="${usuario ne 'anonymous' && usuario.type eq 'Manager'}">
						<li class="nav-item"><a class="nav-link" href="/projects">Proyectos</a></li>
					</c:if>
					
					<c:if test="${usuario ne 'anonymous' && usuario.type eq 'Administrator'}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Configuración </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="/users">Usuarios</a></li>
								<li><a class="dropdown-item" href="/companies">Empresas</a></li>
							</ul>
						</li>
					</c:if>
				</ul>
			
				<span class="badge bg-info me-2">${usuario.type}</span>
				<div class="dropdown ">
					<a href="#"
						class="d-block link-light text-decoration-none dropdown-toggle"
						data-bs-toggle="dropdown" aria-expanded="false">
						<span class="text-light"><i class="bi bi-person-circle"></i>
						${usuario.name} </span>
					</a>
					<ul class="dropdown-menu text-small" style="">
						<li><a class="dropdown-item" href="/logout">Logout</a></li>
					</ul>
				</div>
			</sec:authorize>
		</div>
	</div>
</header>