package pe.edu.tecsup.ventasonline.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.tecsup.ventasonline.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>  {
	
	@Override
	List<Producto> findAll();
}
