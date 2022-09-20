<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<header class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="/inicio"><i class="bi bi-tools"></i> DSMantenimiento</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
<%-- 			<security:authorize access="isAuthenticated()"> --%>
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
<!-- 					<li class="nav-item"><a class="nav-link active"	aria-current="page" href="#">Inicio</a></li> -->
					<li class="nav-item"><a class="nav-link" href="/issues">Incidencias</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">	Configuración </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/users">Usuarios</a></li>
							<li><a class="dropdown-item" href="/companies">Empresas</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/manufacturers">Fabricantes</a></li>
						</ul>
					</li>
				</ul>
				<div class="form-inline my-2 my-lg-0">
					<span class="text-light"><i class="bi bi-person-circle"></i> 
<%-- 					<security:authentication property="principal.username" /> --%>
						Username
					</span>
				</div>
<%-- 			</security:authorize> --%>
		</div>
	</div>
</header>