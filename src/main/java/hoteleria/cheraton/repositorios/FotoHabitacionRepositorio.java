package hoteleria.cheraton.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hoteleria.cheraton.modelos.FotoHabitacion;

public interface FotoHabitacionRepositorio extends JpaRepository<FotoHabitacion, String>{

	@Transactional
	@Modifying
	@Query(value = "{call guardarFoto(:cadenaFoto,:id_habitacion)}", nativeQuery = true)
	void guardarFoto(@Param("cadenaFoto") String foto ,@Param("id_habitacion") String idHabitacion);
	
	List<FotoHabitacion> findByIdHabitacion(String idHabitacion);
}
