
$(document).on("click", ".btn-actualizar", function () {

    $("#idUsuario").val($(this).attr("data-idUsuario"));
    $("#eliminado").val($(this).attr("data-eliminado"));
    $("#idPais").val($(this).attr("data-idPais"));
    $("#nombre").val($(this).attr("data-nombre"));
    $("#apellidoPadre").val($(this).attr("data-apellidoPadre"));
    $("#apellidoMadre").val($(this).attr("data-apellidoMadre"));
    $("#direccion").val($(this).attr("data-direccion"));
    $("#telefono").val($(this).attr("data-telefono"));
    $("#correo").val($(this).attr("data-correo"));
    $("#contrasena").val($(this).attr("data-contrasena"));

	document.getElementById("exampleModalLabel").innerHTML = "EDITAR USUARIO";
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

