package hoteleria.cheraton.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleria.cheraton.modelos.Rol;
import hoteleria.cheraton.repositorios.RolRepositorio;

@Service
public class RolServicioMetodos implements RolServicioNombres{

	@Autowired
	private RolRepositorio rolRepositorio;
	
	@Override
	@Transactional
	public List<Rol> retornarListaRoles() {
		return rolRepositorio.findAll();
	}
	
	@Override
	@Transactional
	public List<Rol> retornarRolesPorIdUsuario(String idUsuario) {
		List<Rol> roles = new ArrayList<Rol>();
		for(Rol rol : rolRepositorio.findAll())
		{
			if(rol.getIdUsuario().getIdUsuario().equals(idUsuario)) roles.add(rol);
		}
		if(roles.size() < 1) return null;
		return roles;
	}

	@Override
	@Transactional
	public void guardarRol(Rol rol) {
		rolRepositorio.save(rol);
		
	}

	@Override
	@Transactional
	public void eliminarRol(String idRol) {
		rolRepositorio.deleteById(idRol);
	}
	
}
