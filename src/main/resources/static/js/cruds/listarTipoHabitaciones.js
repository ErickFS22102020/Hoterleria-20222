$(document).on("click", ".btn-actualizar", function () {

    $("#idTipoHabitacion").val($(this).attr("data-idTipoHabitacion"));
    $("#categoria").val($(this).attr("data-categoria"));
    $("#eliminado").val($(this).attr("data-eliminado"));
    $("#camas").val($(this).attr("data-camas"));
	if($(this).attr("data-jacuzzi") === "SI") document.querySelector("#jacuzzi1").checked="checked";
	if($(this).attr("data-netflix") === "SI") document.querySelector("#netflix1").checked="checked";
	if($(this).attr("data-internet") === "SI") document.querySelector("#internet1").checked="checked";
	if($(this).attr("data-exterior") === "SI") document.querySelector("#exterior1").checked="checked";
	if($(this).attr("data-salon") === "SI") document.querySelector("#salon1").checked="checked";
	if($(this).attr("data-terraza") === "SI") document.querySelector("#terraza1").checked="checked";
	document.getElementById("exampleModalLabel").innerHTML = "EDITAR TIPO HABITACION";
	
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