package hoteleria.cheraton.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hoteleria.cheraton.metodos.General;
import hoteleria.cheraton.modelos.Pais;
import hoteleria.cheraton.modelos.Usuario;
import hoteleria.cheraton.servicios.PaisServicioNombres;
import hoteleria.cheraton.servicios.UsuarioServicioNombres;

@Controller
@RequestMapping("/menu/mantenimiento/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioServicioNombres servicioUsuario;
	
	@Autowired	
	private PaisServicioNombres servicioPais;
	
	@GetMapping("/listar")
	public String listar(Model modelo,Usuario usuario) 
	{
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		List<Pais> listaPaises = servicioPais.retornarListaPaises();
		
		int totalPeruanos = 0;
		int totalEliminados = 0;
		
		for(Usuario i : servicioUsuario.retornarListaUsuarios()) 
		{
			if(i.getEliminado().equals("1")) totalEliminados += 1;
			else 
			{
				if(i.getIdPais().getNombrePais().equals("Perú")) totalPeruanos += 1;
				listaUsuarios.add(i);
			}
		}
		
		int totalUsuarios = listaUsuarios.size();
		
		modelo.addAttribute("listaUsuarios",listaUsuarios);
		modelo.addAttribute("listaPaises",listaPaises);
		modelo.addAttribute("totalEliminados",totalEliminados);
		modelo.addAttribute("totalUsuarios",totalUsuarios);
		modelo.addAttribute("totalPeruanos",totalPeruanos);
		return "moduloUsuarios/listarUsuarios";
	}
	
	@PostMapping("/guardar")
	public String registrar(Usuario usuario)
	{	
		System.out.println("-------------------------------");
		System.out.println(usuario.getIdUsuario());
		System.out.println("-------------------------------");
		
		
		if(! usuario.getIdUsuario().equals(""))
		{
			String antiguoPassword = servicioUsuario.encontrarUsuarioPorId(usuario.getIdUsuario()).getContrasena();
			if(! usuario.getContrasena().equals(antiguoPassword)) usuario.setContrasena(General.encriptarPassword(usuario.getContrasena()));
		}
		else usuario.setContrasena(General.encriptarPassword(usuario.getContrasena()));
		servicioUsuario.guardarUsuario(usuario);
		return "redirect:/menu/mantenimiento/usuarios/listar";
	}
	
	@GetMapping("/eliminar{idUsuario}")
	public String eliminar(Usuario usuario)
	{
		servicioUsuario.eliminacionLogicaUsuario(usuario.getIdUsuario());
		return "redirect:/menu/mantenimiento/usuarios/listar";
	}
	
	@GetMapping("/JSON")
	@ResponseBody
	public List<Usuario> listarUsuariosJSON()
	{
		return servicioUsuario.retornarListaUsuarios();
	}
	
}