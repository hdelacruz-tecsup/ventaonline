package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import pe.edu.tecsup.ventasonline.entities.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id_p);
	
	public void save(Producto producto);
	
	public void deleteById(Long id_p);
}
