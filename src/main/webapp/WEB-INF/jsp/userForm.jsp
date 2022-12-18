<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Nuevo usuario</h1>
<div class="card">
	<div class="card-body">
		<form:form method="POST" action="/users/new" modelAttribute="userForm">
			<div class="form-group">
				<label for="userEmail">Email</label>
				<form:input path="user.email" type="email" class="form-control" id="userEmail" ></form:input>
			</div>
			<div class="form-group">
				<label for="userName">Nombre</label>
				<form:input path="user.name" type="text" class="form-control" id="userName" ></form:input>
			</div>
			<div class="form-group">
				<label for="userPassword">Contraseña</label>
				<form:input path="user.password" type="password" class="form-control" id="userPassword" ></form:input>
			</div>
			<div class="form-group">
				<label for="userType">Tipo</label>
				<form:select path="type" class="form-control" id="userType" >
					<form:option value="Administrador">Administrador</form:option>
					<form:option value="Responsable">Responsable</form:option>
					<form:option value="Soldador">Soldador</form:option>
				</form:select>
			</div>
			<div class="form-group bloque-empresa">
				<label for="userCompany">Empresa</label>
				<form:select path="company" class="form-control js-example-basic-single" id="userCompany" >
					<c:forEach items="${companies}" var="company">
						<form:option value="${company.id}">${company.name}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div class="form-group mt-5">
				<button type="submit" class="btn btn-primary">Crear</button>
			</div>
			
		</form:form>
	</div>
</div>

<script>
	$(document).ready(function() {
		$(".clickable-row").click(function() {
			window.location = $(this).data("href");
		});
		
		$("#userType").change(function() {
			console.log($("#userType").val() === "Administrador");
			if ($("#userType").val() === "Administrador") {
				$(".bloque-empresa").addClass("d-none");
			} else {
				$(".bloque-empresa").removeClass("d-none");
			}
		});
	});
</script>