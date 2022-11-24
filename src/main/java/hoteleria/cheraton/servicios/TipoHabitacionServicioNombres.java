package hoteleria.cheraton.servicios;

import java.util.List;

import hoteleria.cheraton.modelos.TipoHabitacion;

public interface TipoHabitacionServicioNombres {
	
	public List<TipoHabitacion> retornarListaTipoHabitaciones();
	public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion);
	public void eliminacionLogicaTipoHabitacion(String id);
	public TipoHabitacion encontrarTipoHabitacionPorId(String id);
}
