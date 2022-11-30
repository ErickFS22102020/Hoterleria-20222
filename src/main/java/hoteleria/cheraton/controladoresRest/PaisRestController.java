package hoteleria.cheraton.controladoresRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hoteleria.cheraton.modelos.Pais;
import hoteleria.cheraton.servicios.PaisServicioNombres;

@RestController
@RequestMapping("/menu/mantenimiento/paises")
public class PaisRestController {
	
	@Autowired
	private PaisServicioNombres servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Pais> lista = servicio.retornarListaPaises();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") String id){
		Pais entidad = servicio.encontrarPaisPorId(id);
		if(entidad == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pais no encontrado, id  proporcionado no es correcto");
		return new ResponseEntity<Object>(entidad,HttpStatus.OK);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear(@RequestBody Pais entidad){
		servicio.guardarPais(entidad);
		return new ResponseEntity<Object>("Pais registrado correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") String id, @RequestBody Pais entidad){
		servicio.guardarPais(entidad);
		return new ResponseEntity<Object>("Pais actualizado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") String id){
		servicio.eliminacionLogicaPais(id);
		return new ResponseEntity<Object>("Pais eliminado correctamente",HttpStatus.OK);
	}
}
