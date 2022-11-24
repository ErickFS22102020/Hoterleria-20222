package hoteleria.cheraton.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hoteleria.cheraton.modelos.Habitacion;
import hoteleria.cheraton.modelos.TipoHabitacion;
import hoteleria.cheraton.servicios.HabitacionServicioNombres;
import hoteleria.cheraton.servicios.TipoHabitacionServicioNombres;

@Controller
@RequestMapping("/menu/mantenimiento/habitaciones")
public class HabitacionController {
	
	@Autowired
	private HabitacionServicioNombres servicioHabitacion;
	
	@Autowired
	private TipoHabitacionServicioNombres servicioTipoHabitacion;
	
	@GetMapping("/listar")
	public String listar(Model modelo, Habitacion habitacion)
	{
		List<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		List<TipoHabitacion> listaTipoHabitaciones = servicioTipoHabitacion.retornarListaTipoHabitaciones();
		int totalEliminados = 0;
		
		for(Habitacion i : servicioHabitacion.retonarListaHabitaciones())
		{
			if(i.getEliminado().equals("1")) totalEliminados += 1;
			else 
			{
				listaHabitaciones.add(i);
			}
		}
		
		int totalHabitaciones = listaHabitaciones.size();
		
		modelo.addAttribute("listaHabitaciones",listaHabitaciones);
		modelo.addAttribute("listaTipoHabitaciones",listaTipoHabitaciones);
		modelo.addAttribute("totalEliminados",totalEliminados);
		modelo.addAttribute("totalHabitaciones",totalHabitaciones);
		
		return "moduloHabitaciones/listarHabitaciones";
	}
	
	@PostMapping("/guardar")
	public String guardar(Habitacion habitacion)
	{
		servicioHabitacion.guardarHabitacion(habitacion);
		return "redirect:/menu/mantenimiento/habitaciones/listar";
	}
	
	@GetMapping("/eliminar{idHabitacion}")
	public String eliminar(Habitacion habitacion)
	{
		servicioHabitacion.eliminacionLogicaHabitacion(habitacion.getIdHabitacion());
		return "redirect:/menu/mantenimiento/habitaciones/listar";
	}
}
