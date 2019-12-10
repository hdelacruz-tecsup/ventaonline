package pe.edu.tecsup.ventasonline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.tecsup.ventasonline.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.Gmail_u=:Gmail_u AND u.Password_u=:Password_u")
	Usuario findByUsernameAndPassword(@Param("Gmail_u") String Gmail_u, @Param("Password_u") String Password_u);

	@Query("SELECT u FROM Usuario u WHERE u.Gmail_u=:Gmail_u")
	Usuario findByUsername(@Param("Gmail_u") String Gmail_u);
	
	@Override
	List<Usuario> findAll();

}
