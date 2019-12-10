package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.ventasonline.entities.Usuario;
import pe.edu.tecsup.ventasonline.repositories.UsuarioRepository;


@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario findByUsernameAndPassword(String Gmail_u, String Password_u) {
		return usuarioRepository.findByUsernameAndPassword(Gmail_u, Password_u);
	}

	@Override
	public Usuario findByUsername(String Gmail_u) {
		return usuarioRepository.findByUsername(Gmail_u);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id_u) {
		return usuarioRepository.findById(id_u).orElseThrow(() -> new EntityNotFoundException("No existe registro"));

	}

	@Override
	public void save(Usuario usuarios) {
		usuarioRepository.save(usuarios);
		
	}

	@Override
	public void deleteById(Long id_u) {
		usuarioRepository.deleteById(id_u);
		
	}

	

}
