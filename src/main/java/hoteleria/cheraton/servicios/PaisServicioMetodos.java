package hoteleria.cheraton.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoteleria.cheraton.modelos.Pais;
import hoteleria.cheraton.repositorios.PaisRepositorio;

@Service
public class PaisServicioMetodos implements PaisServicioNombres{

	@Autowired
	private PaisRepositorio paisRepositorio;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pais> retornarListaPaises() {
		return paisRepositorio.findAll();
	}

	@Override
	@Transactional
	public Pais encontrarPaisPorNombre(String nombre) {
		for (Pais pais : paisRepositorio.findAll()) 
		{
			if (pais.getNombrePais().equals(nombre)) return pais;
		}
		return new Pais();
	}

	@Override
	@Transactional
	public Pais encontrarPaisPorId(String id) {
		return paisRepositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void guardarPais(Pais pais) {
		paisRepositorio.save(pais);
		
	}

	@Override
	@Transactional
	public void eliminacionLogicaPais(String idPais) {
		Pais pais = paisRepositorio.findById(idPais).orElse(null);
		if(pais != null)
		{
			pais.setEliminado("1");
			paisRepositorio.save(pais);
		}
	}

}
