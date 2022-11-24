package hoteleria.cheraton.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idRol")
	private String idRol;
	
	@Column(name = "nombreRol")
	private String nombreRol;
	
	@ManyToOne
    @JoinColumn(name = "idUsuario")
	private Usuario idUsuario;
}
