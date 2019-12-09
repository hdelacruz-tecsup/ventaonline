package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import pe.edu.tecsup.ventasonline.entities.Tienda;

public interface TiendaService {
	
	public List<Tienda> findAll();
	
	public Tienda findById(Long id_ti);
	
	public void save(Tienda tienda);
	
	public void deleteById(Long id_ti);


}
