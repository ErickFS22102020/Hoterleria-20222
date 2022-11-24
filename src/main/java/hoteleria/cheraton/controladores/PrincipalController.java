package hoteleria.cheraton.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hoteleria.cheraton.metodos.General;
import hoteleria.cheraton.modelos.Rol;
import hoteleria.cheraton.modelos.Usuario;
import hoteleria.cheraton.servicios.PaisServicioNombres;
import hoteleria.cheraton.servicios.UsuarioServicioNombres;

@Controller
public class PrincipalController {
	
	@Autowired
	private UsuarioServicioNombres servicioUsuario;
	
	@Autowired
	private PaisServicioNombres servicioPais;

	@RequestMapping("/")
	public String salir_ingresar(@AuthenticationPrincipal User user) 
	{
		return "moduloMenu/inicio";
	}
	
	@RequestMapping("/login")
	public String login(Model modelo) 
	{
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario",usuario);
		modelo.addAttribute("listaPaises",servicioPais.retornarListaPaises());
		return "moduloLogin/login";
	}
	
	@PostMapping("/registrarse")
	public String Registrarse(@ModelAttribute("usuario") Usuario usuario)
	{
		usuario.setContrasena(General.encriptarPassword(usuario.getContrasena()));
		
		Usuario nuevoUsuario = servicioUsuario.encontrarUsuarioPorCorreo(usuario.getCorreo());
		
		var roles = new ArrayList<GrantedAuthority>();
		
		for(Rol rol : nuevoUsuario.getListaRoles())
		{
			roles.add(new SimpleGrantedAuthority("ROLE_" + rol.getNombreRol()));
		}
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario.getCorreo(), usuario.getContrasena(), roles);
	    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	    
		return "redirect:/";
	}
}
