package hoteleria.cheraton.modelos;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="gastos")
public class Gastos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idGastos")
	private String idGastos;
	
	@ManyToOne
	@JoinColumn(name = "idReservacion")
	private Reservacion idReservacion;
	
	@ManyToOne
	@JoinColumn(name = "idServicio")
	private Servicio idServicio;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "precio")
	private double precio;
}
