package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import pe.edu.tecsup.ventasonline.entities.Factura;

public interface FacturaService {
	
	public List<Factura> findAll();
	
	public Factura findById(Long id_fac);
	
	public void save(Factura factura);
	
	public void deleteById(Long id_fac);


}
