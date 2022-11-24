$(document).ready(function(){

  $("#btnAgregar").hide();
  $("#btnEliminar").hide();
});

// ----------------------------------------------------------------------

let base64String = "";

const input = document.querySelector('#image_uploads');
const preview = document.querySelector('.vistaFoto');
const textoCodificado = document.querySelector('#imagenCodificada');

input.style.opacity = 0;
input.addEventListener('change', updateImageDisplay);

function resetearImagen(){
	const imagenAgregar = document.getElementById("imagenAgregar");
	imagenAgregar.src="";
	base64String = "";
	
	const para = document.getElementById("descripcionImagen");
	para.textContent = 'Ninguna imagen seleccionada';
	
	textoCodificado.value = base64String;
	
	$("#btnAgregar").hide();
	$("#btnEliminar").hide();
}

function updateImageDisplay() {
    while(preview.firstChild) {
        preview.removeChild(preview.firstChild);
    }

    const curFiles = input.files;
    if (curFiles.length === 0) {
        const para = document.createElement('p');
        para.id = "descripcionImagen";
        para.textContent = 'Ninguna imagen seleccionada';
        preview.appendChild(para);
    } else {
        const list = document.createElement('ol');
        preview.appendChild(list);
		
        for (const file of curFiles) {
	        const listItem = document.createElement('li');
	        const para = document.createElement('p');
	        para.id = "descripcionImagen";
	        if (validFileType(file)) {
	            para.textContent = `File name ${file.name}, file size ${returnFileSize(file.size)}.`;
	            const image = document.createElement('img');
	            image.src = URL.createObjectURL(file);
				image.class = "img-fluid"	
				image.id = "imagenAgregar"	
				
	            listItem.appendChild(image);
	            listItem.appendChild(para);
	            
	            setearBase64String();
	            
	            $("#btnAgregar").show();
	        	$("#btnEliminar").show();

	        } else {
	            para.textContent = `Nombre del archivo ${file.name}: No valido el tipo de archivo. Cambia tu seleccion.`;
	            listItem.appendChild(para);
	            $("#btnEliminar").hide();
	            $("#btnAgregar").hide();
	        }

	        list.appendChild(listItem);

        }
        
    }
}

const fileTypes = [
	"image/apng",
	"image/bmp",
	"image/gif",
	"image/jpeg",
	"image/pjpeg",
	"image/png",
	"image/svg+xml",
	"image/tiff",
	"image/webp",
	"image/x-icon"
];

function validFileType(file) {
	return fileTypes.includes(file.type);
}

function returnFileSize(number) {
    if (number < 1024) {
        return `${number} bytes`;
    } else if (number >= 1024 && number < 1048576) {
        return `${(number / 1024).toFixed(1)} KB`;
    } else if (number >= 1048576) {
        return `${(number / 1048576).toFixed(1)} MB`;
    }
}

function setearBase64String() {
	var file = document.querySelector(
		'#image_uploads')['files'][0];
	var reader = new FileReader();
	reader.onload = function () {
		base64String = reader.result.replace("data:", "").replace(/^.+,/, "");
		textoCodificado.value = base64String;
	}
	reader.readAsDataURL(file);
}

