package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.ventasonline.entities.Factura;
import pe.edu.tecsup.ventasonline.repositories.FacturaRepository;

@Service
@Transactional
public class FacturaServiceImpl implements FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura findById(Long id_fac) {
		return facturaRepository.findById(id_fac).orElseThrow(() -> new
				EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Factura factura) {
		facturaRepository.save(factura);

	}

	@Override
	public void deleteById(Long id_fac) {
		facturaRepository.deleteById(id_fac);

	}

}
