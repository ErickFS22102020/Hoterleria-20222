package hoteleria.cheraton.repositorios;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hoteleria.cheraton.modelos.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,String>{

	@Transactional
	@Modifying
	@Query(value = "{call registrarCliente(:idPais,:nombre,:apellidoPadre,:apellidoMadre,:telefono,:direccion,:correo,:contrasena)}", nativeQuery = true)
	void registrarCliente(@Param("idPais") String idPais, @Param("nombre") String nombre,
						  @Param("apellidoPadre") String apellidoPadre, @Param("apellidoMadre") String apellidoMadre,
						  @Param("direccion") String direccion, @Param("telefono") String telefono,
						  @Param("correo") String correo, @Param("contrasena") String contrasena);

	Usuario findByCorreo(String correo);

}
