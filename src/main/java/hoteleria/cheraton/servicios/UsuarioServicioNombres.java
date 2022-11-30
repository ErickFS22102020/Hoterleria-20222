package hoteleria.cheraton.servicios;

import java.util.List;

import hoteleria.cheraton.modelos.Usuario;

public interface UsuarioServicioNombres {
	
	public List<Usuario> retornarListaUsuarios();
	public Usuario retornarUltimoUsuario();
	public void guardarUsuario(Usuario usuario);
	public void eliminarUsuario(Usuario usuario);
	public void eliminacionLogicaUsuario(String idUsuario);
	public Usuario encontrarUsuarioPorId(String idUsuario);
	public Usuario encontrarUsuarioPorCorreo(String correo);
	public void registrarCliente(String idPais, String nombre, String apellidoPadre, String apellidoMadre, String direccion, String telefono, String correo, String contrasena);
}
