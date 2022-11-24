package hoteleria.cheraton.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="tipohabitacion")
public class TipoHabitacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idTipoHabitacion")
	private String idTipoHabitacion;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="eliminado")
	private String eliminado = "0";
	
	@Column(name="camas")
	private int camas;
	
	@Column(name="jacuzzi")
	private String jacuzzi = "NO";
	
	@Column(name="netflix")
	private String netflix = "NO";
	
	@Column(name="internet")
	private String internet = "NO";
	
	@Column(name="exterior")
	private String exterior = "NO";
	
	@Column(name="salon")
	private String salon = "NO";
	
	@Column(name="terraza")
	private String terraza = "NO";
	
	@OneToMany(mappedBy = "idTipoHabitacion")
	@JsonBackReference(value="listaHabitaciones")
	private List<Habitacion> listaHabitaciones;
}
