<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Usuarios</h1>
<c:if test="${msgSuccess ne null }">
	<div class="alert alert-success" role="alert">
	  <c:out value="${msgSuccess}"></c:out>
	</div>
</c:if>
<div class="card">
	<div class="card-body">
		<c:url var="urlNewUser" value="/users/new"></c:url>
		<a class="btn btn-primary mb-1 float-end" href="${urlNewUser}"><i class="bi bi-plus-circle"></i> Nuevo</a>
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Email</th>
					<th>Tipo</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${users}" var="user">
					<tr class='clickable-row' data-href='/users/${user.id}'>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td><span class="badge bg-info me-2">${user.type}</span></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
	</div>
</div>
<script>

$(document).ready(function() {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});

</script>