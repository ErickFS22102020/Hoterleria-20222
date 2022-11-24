$(document).on("click", ".btn-actualizar", function () {

    $("#idPais").val($(this).attr("data-idPais"));
    $("#nombrePais").val($(this).attr("data-nombrePais"));
    $("#eliminado").val($(this).attr("data-eliminado"));

	document.getElementById("exampleModalLabel").innerHTML = "EDITAR PAIS";
});

$('#exampleModal').on('hidden.bs.modal', function () {
 location.reload();
})

$(document).ready(function() {
	$('#ejemplo1').DataTable({
		language : {
			"decimal" : "",
			"emptyTable" : "Datos no disponibles en la tabla",
			"info" : "Mostrando _START_ a _END_ de _TOTAL_ registros",
			"infoEmpty" : "Mostrando 0 a 0 de 0 registros",
			"infoFiltered" : "(Filtrado de _MAX_ registros totales)",
			"infoPostFix" : "",
			"thousands" : ",",
			"lengthMenu" : "Mostrando _MENU_ ",
			"loadingRecords" : "Cargando...",
			"processing" : "Procesando...",
			"search" : "Buscar:",
			"zeroRecords" : "No se encontraron registros para la búsqueda",
			"paginate" : {
				"first" : "Primero",
				"last" : "Ultimo",
				"next" : "Siguiente",
				"previous" : "Anterior"
			},
			"aria" : {
				"sortAscending" : ": Activar para ordenar ascendente",
				"sortDescending" : ": Activar para ordenar descendente"
			}
		}
	});
	$('[data-toggle="tooltip"]').tooltip();
});
