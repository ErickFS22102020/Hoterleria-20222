package hoteleria.cheraton.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name="habitacion")
public class Habitacion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idHabitacion")
	private String idHabitacion;
	
	@Column(name="numeroHabitacion")
	private String numeroHabitacion;
	
	@Column(name="piso")
	private int piso;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio8Horas")
	private double precio8Horas;
	
	@Column(name="precioDia")
	private double precioDia;
	
	@Column(name="eliminado")
	private String eliminado = "0";
	
	@Column(name="estado")
	private String estado = "DISPONIBLE";
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idTipoHabitacion")
	private TipoHabitacion idTipoHabitacion;
	
	@OneToMany(mappedBy = "idHabitacion")
	@JsonBackReference(value="listaFotos")
	private List<FotoHabitacion> listaFotos;
	
	@OneToMany(mappedBy = "idHabitacion")
	@JsonBackReference(value="listaReservaciones")
	private List<Reservacion> listaReservaciones;
}
