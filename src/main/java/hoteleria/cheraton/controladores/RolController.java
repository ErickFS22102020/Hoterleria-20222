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

import hoteleria.cheraton.modelos.Rol;
import hoteleria.cheraton.modelos.Usuario;
import hoteleria.cheraton.servicios.RolServicioNombres;
import hoteleria.cheraton.servicios.UsuarioServicioNombres;

@Controller
@RequestMapping("/menu/mantenimiento/roles")
public class RolController {
	
	@Autowired
	private RolServicioNombres servicioRol;
	
	@Autowired
	private UsuarioServicioNombres servicioUsuario;
	
	@GetMapping("/listar")
	public String listar(Model modelo, Rol rol)
	{
		List<Rol> listaRoles = servicioRol.retornarListaRoles();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for (Usuario i : servicioUsuario.retornarListaUsuarios()) if(i.getListaRoles().size() < 3) listaUsuarios.add(i);
		
		
		int clientes = 0;
		int empleados = 0;
		int administradores = 0;
		
		for(Rol i : listaRoles)
		{
			if (i.getNombreRol().equals("CLIENTE")) clientes += 1; 
			if (i.getNombreRol().equals("EMPLEADO")) empleados += 1; 
			if (i.getNombreRol().equals("ADMINISTRADOR")) administradores += 1; 
		}

		modelo.addAttribute("servicioUsuario",this.servicioUsuario);
		modelo.addAttribute("listaRoles",listaRoles);
		modelo.addAttribute("listaUsuarios",listaUsuarios);
		modelo.addAttribute("clientes",clientes);
		modelo.addAttribute("empleados",empleados);
		modelo.addAttribute("administradores",administradores);
		
		return "moduloRoles/listarRoles";
	}
	
	@PostMapping("/guardar")
	public String guardar(Rol rol) 
	{
		servicioRol.guardarRol(rol);
		return "redirect:/menu/mantenimiento/roles/listar";
	}
	
	@GetMapping("/eliminar{idRol}")
	public String eliminar(Rol rol)
	{
		servicioRol.eliminarRol(rol.getIdRol());
		return "redirect:/menu/mantenimiento/roles/listar";
	}
	
	@GetMapping("/JSON")
	@ResponseBody
	public List<Rol> listarUsuariosJSON()
	{
		return servicioRol.retornarListaRoles();
	}
}
