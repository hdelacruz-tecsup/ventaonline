package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.ventasonline.entities.Tienda;
import pe.edu.tecsup.ventasonline.repositories.TiendaRepository;


@Service
@Transactional
public class TiendaServiceImpl implements TiendaService {

	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Override
	public List<Tienda> findAll() {
		return tiendaRepository.findAll();
	}

	@Override
	public Tienda findById(Long id_ti) {
		return tiendaRepository.findById(id_ti).orElseThrow(() -> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Tienda tienda) {
		tiendaRepository.save(tienda);

	}

	@Override
	public void deleteById(Long id_ti) {
		tiendaRepository.deleteById(id_ti);

	}

	

}
