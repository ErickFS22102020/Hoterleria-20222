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
@Table(name="pais")
public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idPais")
	private String idPais;
	
	@Column(name="eliminado")
	private String eliminado = "0";
	
	@Column(name="nombrePais")
	private String nombrePais;
	
	@OneToMany(mappedBy = "idPais")
	@JsonBackReference(value="listaUsuarios")
	private List<Usuario> listaUsuarios;
}
