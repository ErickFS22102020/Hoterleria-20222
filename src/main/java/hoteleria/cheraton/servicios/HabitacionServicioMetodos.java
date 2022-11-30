package hoteleria.cheraton.servicios;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoteleria.cheraton.modelos.Habitacion;
import hoteleria.cheraton.repositorios.HabitacionRepositorio;

@Service
public class HabitacionServicioMetodos implements HabitacionServicioNombres{

	@Autowired
	private HabitacionRepositorio habitacionRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Habitacion> retonarListaHabitaciones() {
		return habitacionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void guardarHabitacion(Habitacion habitacion) {
		habitacionRepositorio.save(habitacion);
	}

	@Override
	@Transactional
	public void eliminarHabitacion(Habitacion habitacion) {
		habitacionRepositorio.delete(habitacion);	
	}
	
	@Override
	@Transactional
	public void eliminacionLogicaHabitacion(String idHabitacion) {
		Habitacion habitacion = habitacionRepositorio.findById(idHabitacion).orElse(null);
		if(habitacion != null) 
		{
			habitacion.setEliminado("1");
			habitacionRepositorio.save(habitacion);
		}	
	}
	
	@Override
	@Transactional(readOnly = true)
	public Habitacion encontrarHabitacionPorId(String idHabitacion) {
		return habitacionRepositorio.findById(idHabitacion).orElse(null);
	}

}
