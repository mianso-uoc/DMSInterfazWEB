<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Pieza</h1>

<div class="card">
	<div class="card-body">
		<div class="row">
			<div class="col-2"><strong>ID</strong></div>
			<div class="col-10">${pieza.id}</div></div>
		<div class="row">
			<div class="col-2"><strong>Nombre</strong></div>
			<div class="col-10">${pieza.name}</div></div>
		<div class="row">
			<div class="col-2"><strong>Proyecto</strong></div>
			<div class="col">${pieza.proyectoMaquina.proyecto.name}</div></div>
		<div class="row">
			<div class="col-2"><strong>Máquina</strong></div>
			<div class="col">${pieza.proyectoMaquina.maquina.serialNumber}</div>
		</div>
		<div class="row">
			<div class="col-2"><strong>Voltaje objetivo</strong></div>
			<div class="col">${pieza.voltage}</div>
		</div>
		<div class="row">
			<div class="col-2"><strong>Corriente objetivo</strong></div>
			<div class="col">${pieza.current}</div>
		</div>
		<div class="row">
			<div class="col-2"><strong>Tolerancia</strong></div>
			<div class="col">${pieza.tolerance}</div>
		</div>

		<div class="row">
			<div class="col-6">
				<canvas id="myChart" width="400" height="220"></canvas>
			</div>
			<div class="col-6">
				<canvas id="myChartI" width="400" height="220"></canvas>
			</div>
		</div>
		
		
	</div>
</div>
<script>

$(document).ready(function() {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
    
    
    var pointBackgroundColors = [];
    var pointBorderColors = [];
    const ctx = document.getElementById('myChart');
    const myChart = new Chart(ctx, {
        type: 'line',
        data: {
            datasets: [{
                label: 'Lecturas',
                data: ${pieza.readingsVAsJson},
                backgroundColor: [
                    '#90cd8a'
                ],
                borderColor: [
                    '#90cd8a'
                ],
                borderWidth: 2,
                pointStyle: 'circle',
                pointBackgroundColor: pointBackgroundColors,
                pointBorderColor: pointBorderColors
            },
            {
                label: 'Valor objetivo',
                data: ${pieza.VObjectiveJson},
                backgroundColor: [
                    'rgba(100,100,100, 0.2)'
                ],
                borderColor: [
                    'rgba(0, 0, 200, 1)'
                ],
                borderWidth: 1
            },
            {
                label: 'Límite superior',
                data: ${pieza.VLimiteSuperior},
                backgroundColor: [
                    'rgba(100,100,100, 0.2)'
                ],
                borderColor: [
                    'rgba(0, 0, 0, 0.3)'
                ],
                borderDash: [10,5],
                borderWidth: 1
            },
            {
                label: 'Límite inferior',
                data: ${pieza.VLimiteInferior},
                backgroundColor: [
                    'rgba(0, 0, 0, 0.2)'
                ],
                borderColor: [
                    'rgba(0, 0, 0, 0.3)'
                ],
                borderDash: [10,5],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
            	x: {
                    type: 'time',
                    time: {
                        unit: 'second'
                    }
                }
            }
        }
    });
    
    for (i = 0; i < myChart.data.datasets[0].data.length; i++) {
        if (myChart.data.datasets[0].data[i].y > ${pieza.voltage * (100 + pieza.tolerance)/100} || myChart.data.datasets[0].data[i].y < ${pieza.voltage * (100 - pieza.tolerance)/100}) {
            pointBackgroundColors.push("#f58368");
            pointBorderColors.push("#f58368");
        } else {
            pointBackgroundColors.push("#90cd8a");
            pointBorderColors.push("#90cd8a");
        }
    }

    myChart.update();
    
    var pointBackgroundColorsI = [];
    var pointBorderColorsI = [];
    const ctxI = document.getElementById('myChartI');
    const myChartI = new Chart(ctxI, {
        type: 'line',
        data: {
            datasets: [{
                label: 'Lecturas',
                data: ${pieza.readingsIAsJson},
                backgroundColor: [
                    '#90cd8a'
                ],
                borderColor: [
                    '#90cd8a'
                ],
                borderWidth: 2,
                pointStyle: 'circle',
                pointBackgroundColor: pointBackgroundColorsI,
                pointBorderColor: pointBorderColorsI
            },
            {
                label: 'Valor objetivo',
                data: ${pieza.IObjectiveJson},
                backgroundColor: [
                    'rgba(100,100,100, 0.2)'
                ],
                borderColor: [
                    'rgba(100, 100, 100, 1)'
                ],
                borderWidth: 1
            },
            {
                label: 'Límite superior',
                data: ${pieza.ILimiteSuperior},
                backgroundColor: [
                    'rgba(100,100,100, 0.2)'
                ],
                borderColor: [
                    'rgba(100, 100, 100, 1)'
                ],
                borderDash: [10,5],
                borderWidth: 1
            },
            {
                label: 'Límite inferior',
                data: ${pieza.ILimiteInferior},
                backgroundColor: [
                    'rgba(100,100,100, 0.2)'
                ],
                borderColor: [
                    'rgba(150, 0, 150, 0.5)'
                ],
                borderDash: [10,5],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
            	x: {
                    type: 'time',
                    time: {
                        unit: 'second'
                    }
                }
            }
        }
    });
    
    for (i = 0; i < myChartI.data.datasets[0].data.length; i++) {
        if (myChartI.data.datasets[0].data[i].y > ${pieza.current * (100 + pieza.tolerance)/100} || myChartI.data.datasets[0].data[i].y < ${pieza.current * (100 - pieza.tolerance)/100}) {
            pointBackgroundColorsI.push("#f58368");
            pointBorderColorsI.push("#f58368");
        } else {
        	pointBackgroundColorsI.push("#90cd8a");
        	pointBorderColorsI.push("#90cd8a");
        }
    }

    myChartI.update();
    
});

</script>
