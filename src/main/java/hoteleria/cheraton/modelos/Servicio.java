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
@Table(name = "servicio")
public class Servicio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idServicio")
	private String idServicio;
	
	@ManyToOne
	@JoinColumn(name = "idTipoServicio")
	private TipoServicio idTipoServicio;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@OneToMany(mappedBy = "idServicio")
	@JsonBackReference(value="listaGastos")
	private List<Gastos> listaGastos;

}
