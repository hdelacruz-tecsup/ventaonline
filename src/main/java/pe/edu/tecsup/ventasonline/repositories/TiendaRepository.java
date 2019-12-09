package pe.edu.tecsup.ventasonline.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import pe.edu.tecsup.ventasonline.entities.Tienda;

public interface TiendaRepository  extends CrudRepository<Tienda, Long>{

	@Override
	List<Tienda>findAll();
	

}
