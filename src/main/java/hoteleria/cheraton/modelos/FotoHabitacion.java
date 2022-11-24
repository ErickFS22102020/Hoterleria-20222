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
@Table(name = "fotohabitacion")
public class FotoHabitacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idFotoHabitacion")
	private String idFotoHabitacion;
	
	@Column(name="foto")
	private byte[] foto;

	@ManyToOne
    @JoinColumn(name = "idHabitacion")
	private Habitacion idHabitacion;
}
