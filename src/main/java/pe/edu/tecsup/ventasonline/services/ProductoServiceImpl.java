package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.ventasonline.entities.Producto;
import pe.edu.tecsup.ventasonline.repositories.ProductoRepository;


@Service
@Transactional

public class ProductoServiceImpl  implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	public Producto findById(Long id_p) {
		return productoRepository.findById(id_p).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void deleteById(Long id_p) {
		productoRepository.deleteById(id_p);
		
	}
}
