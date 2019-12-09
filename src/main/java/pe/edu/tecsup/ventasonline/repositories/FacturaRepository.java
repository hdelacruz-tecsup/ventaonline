package pe.edu.tecsup.ventasonline.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pe.edu.tecsup.ventasonline.entities.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long>{
	
	@Override
	List<Factura> findAll();

}
