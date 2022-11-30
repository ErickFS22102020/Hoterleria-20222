let rolesTotales = ["CLIENTE","EMPLEADO","ADMINISTRADOR"]
let roles = document.getElementById('nombreRol')

function establecerRoles(nombreSelect){
  var rolesCadena = "" + $('option:selected', nombreSelect).attr('data-roles');
  var arrayRoles = rolesCadena.length !== 0 ? rolesCadena.split(",") : [];
  
  arrayMostrar = []
  
  for(var i = 0; rolesTotales.length > i; i++)
  {
      if(! arrayRoles.includes(rolesTotales[i])) arrayMostrar.push(rolesTotales[i])
  } 
  
  roles.innerHTML = "";
  
  arrayMostrar.forEach(function(rol){
    let opcion = document.createElement('option')
    opcion.value = rol
    opcion.text = rol
    roles.add(opcion)
  })
}

establecerRoles('#idUsuario');

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