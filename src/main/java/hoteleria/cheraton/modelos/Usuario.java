package hoteleria.cheraton.modelos;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name= "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idUsuario")
	private String idUsuario;	
	
	@Column(name="eliminado")
	private String eliminado = "0";
	
	@ManyToOne
	@JoinColumn(name = "idPais")
	private Pais idPais;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidoPadre")
	private String apellidoPadre;
	
	@Column(name="apellidoMadre")
	private String apellidoMadre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="contrasena")
	private String contrasena;

	@OneToMany(mappedBy = "idUsuario")
	@JsonBackReference(value="listaRoles")
	private List<Rol> listaRoles;
	
	@OneToMany(mappedBy = "idUsuario")
	@JsonBackReference(value="listaReservaciones")
	private List<Reservacion> listaReservaciones;
}
