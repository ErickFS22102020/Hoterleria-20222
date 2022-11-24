package hoteleria.cheraton.servicios;

import java.util.List;

import hoteleria.cheraton.modelos.Rol;

public interface RolServicioNombres {
	
	public List<Rol> retornarListaRoles();
	public List<Rol> retornarRolesPorIdUsuario(String idUsuario);
	public void guardarRol(Rol rol);
	public void eliminarRol(Rol rol);
}
