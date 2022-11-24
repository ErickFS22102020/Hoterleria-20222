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
@Table(name = "tiposervicio")
public class TipoServicio implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idTipoServicio")
	private String idTipoServicio;
	
	@Column(name="nombreServicio")
	private String nombreServicio;
	
	@OneToMany(mappedBy = "idTipoServicio")
	@JsonBackReference(value="listaServicios")
	private List<Servicio> listaServicios;
}
