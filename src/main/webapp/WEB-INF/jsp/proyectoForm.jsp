<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Nuevo proyecto</h1>
<div class="card">
	<div class="card-body">
		<form:form method="POST" action="/projects/new" modelAttribute="proyecto">
			<div class="form-group">
				<label for="nombre">Nombre</label>
				<form:input path="name" type="text" class="form-control" id="nombre" ></form:input>
			</div>
			
			<div class="form-group mt-5">
				<button type="submit" class="btn btn-primary">Crear</button>
			</div>
			
		</form:form>
	</div>
</div>