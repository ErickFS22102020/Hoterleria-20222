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

import hoteleria.cheraton.modelos.TipoHabitacion;
import hoteleria.cheraton.servicios.TipoHabitacionServicioNombres;

@Controller
@RequestMapping("/menu/mantenimiento/tipoHabitaciones")
public class TipoHabitacionController {
	
	@Autowired
	private TipoHabitacionServicioNombres servicioTipoHabitacion;

	@GetMapping("/listar")
	public String listar(Model modelo, TipoHabitacion tipoHabitacion)
	{
		List<TipoHabitacion> listaTipoHabitaciones = new ArrayList<TipoHabitacion>();
		int totalEliminados = 0;
		int totalNetflix = 0;
		for(TipoHabitacion i : servicioTipoHabitacion.retornarListaTipoHabitaciones())
		{
			if(i.getEliminado().equals("1")) totalEliminados += 1;
			else 
			{
				listaTipoHabitaciones.add(i);
				if(i.getNetflix().equals("SI")) totalNetflix += 1;
			}
		}
		int totalTipoHabitaciones = listaTipoHabitaciones.size();
		
		modelo.addAttribute("totalTipoHabitaciones",totalTipoHabitaciones);
		modelo.addAttribute("totalNetflix",totalNetflix);
		modelo.addAttribute("listaTipoHabitaciones",listaTipoHabitaciones);
		modelo.addAttribute("totalEliminados",totalEliminados);
		
		return "moduloTipoHabitaciones/listarTipoHabitaciones";
	}
	
	@PostMapping("/guardar")
	public String guardar(TipoHabitacion tipoHabitacion)
	{
		servicioTipoHabitacion.guardarTipoHabitacion(tipoHabitacion);
		return "redirect:/menu/mantenimiento/tipoHabitaciones/listar";
	}
	
	@GetMapping("/eliminar{idTipoHabitacion}")
	public String eliminar(TipoHabitacion tipoHabitacion)
	{
		servicioTipoHabitacion.eliminacionLogicaTipoHabitacion(tipoHabitacion.getIdTipoHabitacion());
		return "redirect:/menu/mantenimiento/tipoHabitaciones/listar";
	}
	
	@GetMapping("/JSON")
	@ResponseBody
	public List<TipoHabitacion> listarUsuariosJSON()
	{
		return servicioTipoHabitacion.retornarListaTipoHabitaciones();
	}
}
