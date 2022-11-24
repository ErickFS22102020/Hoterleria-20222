package hoteleria.cheraton.servicios;

import java.util.List;

import hoteleria.cheraton.modelos.FotoHabitacion;

public interface FotoHabitacionServicioNombres {

	public void guardarFoto(String base64Foto, String idHabitacion );
	public void eliminarFoto(FotoHabitacion fotoHabitacion);
	public List<FotoHabitacion> listarFotos(FotoHabitacion fotoHabitacion);
	public List<FotoHabitacion> buscarFotoPorIdHabitacion(String idHabitacion);
}
