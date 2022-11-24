package hoteleria.cheraton.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hoteleria.cheraton.modelos.Pais;
import hoteleria.cheraton.servicios.PaisServicioNombres;

@Controller
@RequestMapping("/menu/mantenimiento/paises")
public class PaisController {
	
	@Autowired
	private PaisServicioNombres servicioPais;
	
	@GetMapping("/listar")
	public String listar(Model modelo, Pais pais) 
	{
		List<Pais> listaPaises = new ArrayList<Pais>();
		int totalEliminados = 0;
		
		for(Pais i : servicioPais.retornarListaPaises()) 
		{
			if(i.getEliminado().equals("1")) totalEliminados += 1;
			else 
			{
				listaPaises.add(i);
			}
		}
		int totalPaises = listaPaises.size();
		
		modelo.addAttribute("listaPaises",listaPaises);
		modelo.addAttribute("totalPaises",totalPaises);
		modelo.addAttribute("totalEliminados",totalEliminados);
		
		return "moduloPaises/listarPaises";
	}
	
	@PostMapping("/guardar")
	public String guardar(Pais pais) 
	{
		servicioPais.guardarPais(pais);
		return "redirect:/menu/mantenimiento/paises/listar";
	}
	
	@GetMapping("/eliminar{idPais}")
	public String eliminar(Pais pais) 
	{
		servicioPais.eliminacionLogicaPais(pais.getIdPais());
		return "redirect:/menu/mantenimiento/paises/listar";
	}
}
