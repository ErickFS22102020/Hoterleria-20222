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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hoteleria.cheraton.modelos.Rol;
import hoteleria.cheraton.servicios.RolServicioNombres;

@RestController
@RequestMapping("/menu/mantenimiento/roles")
public class RolRestController {
	
	@Autowired
	private RolServicioNombres servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Rol> lista = servicio.retornarListaRoles();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear(@RequestBody Rol entidad){
		servicio.guardarRol(entidad);
		return new ResponseEntity<Object>("Rol agregado correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") String id){
		servicio.eliminarRol(id);
		return new ResponseEntity<Object>("Rol eliminado correctamente",HttpStatus.OK);
	}
}
