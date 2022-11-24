package hoteleria.cheraton.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hoteleria.cheraton.metodos.ConexionHoteleria;
import hoteleria.cheraton.modelos.Habitacion;
import hoteleria.cheraton.servicios.HabitacionServicioNombres;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private HabitacionServicioNombres servicioHabitacion;
	
	@RequestMapping("/inicio")
	public String login() 
	{
		return "moduloMenu/inicio";
	}
	
	@RequestMapping("/mantenimiento")
	public String mantenimiento() 
	{
		return "moduloMenu/mantenimiento";
	}
	
	@RequestMapping("/galerias")
	public String galerias() 
	{
		return "moduloMenu/galerias";
	}
	
	@RequestMapping("/reservaciones")
	public String reservaciones(Model modelo) 
	{
		List<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		servicioHabitacion.retonarListaHabitaciones().forEach(i -> {if(i.getEliminado().equals("0")) listaHabitaciones.add(i);});
		
		ConexionHoteleria funciones = new ConexionHoteleria();
		
		modelo.addAttribute("listaHabitaciones",listaHabitaciones);
		modelo.addAttribute("funciones",funciones);
		
		return "moduloMenu/reservaciones";
	}
	
	@RequestMapping("/nosotros")
	public String nosotros() 
	{
		return "moduloMenu/nosotros";
	}
	
	@RequestMapping("/contactos")
	public String contactos() 
	{
		return "moduloMenu/contactos";
	}
}
