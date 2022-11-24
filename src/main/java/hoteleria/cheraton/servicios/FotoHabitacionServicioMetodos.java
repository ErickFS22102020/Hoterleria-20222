package hoteleria.cheraton.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoteleria.cheraton.modelos.FotoHabitacion;
import hoteleria.cheraton.repositorios.FotoHabitacionRepositorio;

@Service
public class FotoHabitacionServicioMetodos implements FotoHabitacionServicioNombres{

	@Autowired
	private FotoHabitacionRepositorio fotoHabitacionRepositorio;
	
	@Override
	@Transactional
	public void guardarFoto(String base64Foto, String idHabitacion ) {
		fotoHabitacionRepositorio.guardarFoto(base64Foto, idHabitacion);	
	}

	@Override
	@Transactional
	public void eliminarFoto(FotoHabitacion fotoHabitacion) {
		fotoHabitacionRepositorio.delete(fotoHabitacion);
	}
	
	@Override
	@Transactional
	public List<FotoHabitacion> listarFotos(FotoHabitacion fotoHabitacion) {
		return fotoHabitacionRepositorio.findAll();
	}

	@Override
	@Transactional
	public List<FotoHabitacion> buscarFotoPorIdHabitacion(String idHabitacion) {
		return fotoHabitacionRepositorio.findByIdHabitacion(idHabitacion);
	}
}
