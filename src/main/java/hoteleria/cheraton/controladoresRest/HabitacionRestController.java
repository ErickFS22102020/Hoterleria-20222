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

import hoteleria.cheraton.modelos.Habitacion;
import hoteleria.cheraton.servicios.HabitacionServicioNombres;

@RestController
@RequestMapping("/menu/mantenimiento/habitaciones")
public class HabitacionRestController {
	
	@Autowired
	private HabitacionServicioNombres servicio;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Habitacion> lista = servicio.retonarListaHabitaciones();
		return new ResponseEntity<>(lista,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") String id){
		Habitacion entidad = servicio.encontrarHabitacionPorId(id);
		if(entidad == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Habitacion no encontrada, id  proporcionado no es correcto");
		return new ResponseEntity<Object>(entidad,HttpStatus.OK);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> crear(@RequestBody Habitacion entidad){
		servicio.guardarHabitacion(entidad);
		return new ResponseEntity<Object>("Habitacion registrada correctamente",HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> actualizar(@PathVariable("id") String id, @RequestBody Habitacion entidad){
		servicio.guardarHabitacion(entidad);
		return new ResponseEntity<Object>("Habitacion actualizada correctamente",HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") String id){
		servicio.eliminacionLogicaHabitacion(id);
		return new ResponseEntity<Object>("Habitacion eliminada correctamente",HttpStatus.OK);
	}
}
