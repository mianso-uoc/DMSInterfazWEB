<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Incidencias</h1>
<div class="card">
	<div class="card-body">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Resumen</th>
					<th>Fecha</th>
				</tr>
			</thead>
<%-- 			<c:out value="${issues }"></c:out> --%>
			<tbody>
				<c:forEach items="${issues}" var="issue">
					<tr class='clickable-row' data-href='/issues/${issue.id}'>
						<td>${issue.id}</td>
						<td>${issue.title}</td>
						<td></td>
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