<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Máquinas</h1>
<div class="card">
	<div class="card-body">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nº serie</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${machines}" var="machine">
					<tr class='clickable-row' data-href='/machines/${machine.id}'>
						<td>${machine.id}</td>
						<td>${machine.serialNumber}</td>
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