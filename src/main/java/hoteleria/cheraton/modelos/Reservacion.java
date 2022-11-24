package hoteleria.cheraton.modelos;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "reservacion")
public class Reservacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idReservacion")
	private String idReservacion;
	
	@Column(name="fechaEntrada")
	private Date fechaEntrada;
	
	@Column(name="fechaSalida")
	private Date fechaSalida;
	
	@Column(name="precio")
	private double precio;
	
	@ManyToOne
	@JoinColumn(name = "idHabitacion")
	private Habitacion idHabitacion;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idUsuario;
	
	@OneToMany(mappedBy = "idReservacion")
	@JsonBackReference(value="listaGastos")
	private List<Gastos> listaGastos;

}
