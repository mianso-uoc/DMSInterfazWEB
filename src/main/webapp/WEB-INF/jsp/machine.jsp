<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Máquina #${machine.id} - Número de serie:
	${machine.serialNumber}</h1>
<div class="row">
	<div class="col-sm-12 col-md-12">
		<div class="thumbnail">
			<div class="caption">
				<h3>Proyectos</h3>
				<c:forEach items="${machine.proyectosMaquina}" var="proyectoMaquina">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title">
								<c:out value="${proyectoMaquina.proyecto.name}"></c:out>
							</h4>
							<p>
								<c:out value="${proyectoMaquina.proyecto.description}"></c:out>
							</p>

							<table class="table">
								<thead>
									<tr>
										<th scope="col">#</th>
										<th>Nombre</th>
										<th>Acciones</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<c:forEach items="${proyectoMaquina.piezas}" var="pieza">
											<td><c:out value="${pieza.id}"></c:out></td>
											<td><c:out value="${pieza.name}"></c:out></td>
											<td><a href="/pieces/${pieza.id}"><i class="bi bi-pencil-square"></i></a></td>
										</c:forEach>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>