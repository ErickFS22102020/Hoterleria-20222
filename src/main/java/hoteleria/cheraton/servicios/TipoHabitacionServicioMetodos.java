package hoteleria.cheraton.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoteleria.cheraton.modelos.TipoHabitacion;
import hoteleria.cheraton.repositorios.TipoHabitacionRepositorio;

@Service
public class TipoHabitacionServicioMetodos implements TipoHabitacionServicioNombres{

	@Autowired
	private TipoHabitacionRepositorio tipoHabitacionRepositorio;
	
	@Override
	@Transactional
	public List<TipoHabitacion> retornarListaTipoHabitaciones() {
		return tipoHabitacionRepositorio.findAll();
	}

	@Override
	@Transactional
	public void guardarTipoHabitacion(TipoHabitacion tipoHabitacion) {
		if(tipoHabitacion.getJacuzzi() == null) tipoHabitacion.setJacuzzi("NO");
		if(tipoHabitacion.getNetflix() == null) tipoHabitacion.setNetflix("NO");
		if(tipoHabitacion.getInternet() == null) tipoHabitacion.setInternet("NO");
		if(tipoHabitacion.getExterior() == null) tipoHabitacion.setExterior("NO");
		if(tipoHabitacion.getSalon() == null) tipoHabitacion.setSalon("NO");
		if(tipoHabitacion.getTerraza() == null) tipoHabitacion.setTerraza("NO");
		tipoHabitacionRepositorio.save(tipoHabitacion);
	}

	@Override
	@Transactional
	public TipoHabitacion encontrarTipoHabitacionPorId(String id) {
		return tipoHabitacionRepositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminacionLogicaTipoHabitacion(String id) {
		TipoHabitacion tipoHabitacion = tipoHabitacionRepositorio.findById(id).orElse(null);
		if (tipoHabitacion != null)
		{
			tipoHabitacion.setEliminado("1");
			tipoHabitacionRepositorio.save(tipoHabitacion);
		}
	}

}
