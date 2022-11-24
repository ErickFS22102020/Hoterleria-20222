let lista = ["ADMINISTRADOR","EMPLEADO","CLIENTE"]

let contrasenaAntigua = "";
const inputContrasena = document.querySelector("#contrasena");

$(document).ready(function(){
	
	for(var i = 0;  lista.length > i ; i++){
		const input = document.querySelector("#" + `${lista[i]}`);
		input.name = input.id;
	}
	
	contrasenaAntigua = document.querySelector("#contrasena").value;
	
});

$("#cambiarContrasena").change(function(){
	
	if(inputContrasena.readOnly !== true) 
	{
		inputContrasena.value = contrasenaAntigua; 
		inputContrasena.readOnly = true;
	}
	else
	{
		inputContrasena.value = ""; 
		inputContrasena.readOnly = false;
	}
	
});

function guardar()
{
	$(".formulario input").each(function () {
        if (this.value === "") {
            inputContrasena.value = contrasenaAntigua; 
			inputContrasena.readOnly = true;
        }
    });
    
    if(! validarEmail(document.querySelector("#correo").value))
    {
		inputContrasena.value = contrasenaAntigua; 
		inputContrasena.readOnly = true;
	}
}

function validarEmail(correo)
{
	let regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if(regex.test(correo)) return true;
    else return false;
}







