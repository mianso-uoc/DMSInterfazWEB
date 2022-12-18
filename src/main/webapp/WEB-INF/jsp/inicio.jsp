<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sec:authentication var="usuario" property="principal" />

<c:choose>
	<c:when test="${usuario.type eq 'Manager'}">
	
		<h1>Mis proyectos</h1>
		
		<a href="/projects/new" class="btn btn-primary">Nuevo proyecto</a>
		<div class="card">
			<div class="card-header bg-info">Proyectos</div>
			<div class="card-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Descripción</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuario.projects}" var="project">
							<tr>
								<td>${project.id}</td>
								<td>${project.name}</td>
								<td>${project.description}</td>
							</tr>
						</c:forEach>
					</tbody>
		
				</table>
			</div>
		</div>
	</c:when>
</c:choose>