package hoteleria.cheraton.servicios;

import java.util.List;

import hoteleria.cheraton.modelos.Pais;

public interface PaisServicioNombres {
	public List<Pais> retornarListaPaises();
	public void guardarPais(Pais pais);
	public void eliminacionLogicaPais(String idPais);
	public Pais encontrarPaisPorNombre(String nombre);
	public Pais encontrarPaisPorId(String id);
}
