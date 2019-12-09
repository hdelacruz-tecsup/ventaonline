package pe.edu.tecsup.ventasonline.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Usuario usuarios) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id_u) {
		// TODO Auto-generated method stub
		
	}

	

}
