package hoteleria.cheraton.servicios;

import java.util.List;

import hoteleria.cheraton.modelos.Habitacion;

public interface HabitacionServicioNombres{
	
	public List<Habitacion> retonarListaHabitaciones();
	public void guardarHabitacion(Habitacion habitacion);
	public void eliminarHabitacion(Habitacion habitacion);
	public void eliminacionLogicaHabitacion(String idHabitacion);
	public Habitacion encontrarHabitacionPorId(String idHabitacion);
}
