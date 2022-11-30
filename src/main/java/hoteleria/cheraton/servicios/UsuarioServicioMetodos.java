package hoteleria.cheraton.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoteleria.cheraton.modelos.Rol;
import hoteleria.cheraton.modelos.Usuario;
import hoteleria.cheraton.repositorios.UsuarioRepositorio;


@Service("userDetailsService")
public class UsuarioServicioMetodos implements UsuarioServicioNombres,UserDetailsService{

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	@Transactional
	public List<Usuario> retornarListaUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	@Transactional
	public void guardarUsuario(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}

	@Override
	@Transactional
	public void eliminarUsuario(Usuario usuario) {
		usuarioRepositorio.delete(usuario);
		
	}
	
	@Override
	@Transactional
	public void eliminacionLogicaUsuario(String idUsuario) {
		Usuario usuario = usuarioRepositorio.findById(idUsuario).orElse(null);
		
		if(usuario != null) 
		{
			usuario.setEliminado("1");
			usuarioRepositorio.save(usuario);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario encontrarUsuarioPorId(String idUsuario) {
		return usuarioRepositorio.findById(idUsuario).orElse(null);
		
	}

	@Override
	@Transactional
	public Usuario retornarUltimoUsuario() {
		int cantidad = usuarioRepositorio.findAll().size();
		return usuarioRepositorio.findAll().get(cantidad - 1);
	}

	@Override
	@Transactional
	public Usuario encontrarUsuarioPorCorreo(String correo) {
		return usuarioRepositorio.findByCorreo(correo);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByCorreo(correo);
		
		if(usuario == null) throw new UsernameNotFoundException(correo);
		
		var roles = new ArrayList<GrantedAuthority>();
		
		for(Rol rol : usuario.getListaRoles())
		{
			roles.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombreRol()));
		}
		
		return new User(usuario.getCorreo(),usuario.getContrasena(),roles);
	}

	@Override
	@Transactional
	public void registrarCliente(String idPais, String nombre, String apellidoPadre, String apellidoMadre,
			String direccion, String telefono, String correo, String contrasena) {
		
		usuarioRepositorio.registrarCliente(idPais, nombre, apellidoPadre, apellidoMadre, direccion, telefono, correo, contrasena);	
	}

	
}
