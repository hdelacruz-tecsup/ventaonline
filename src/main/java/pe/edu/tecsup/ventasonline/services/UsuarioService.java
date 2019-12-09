package pe.edu.tecsup.ventasonline.services;

import java.util.List;

import pe.edu.tecsup.ventasonline.entities.Usuario;

public interface UsuarioService {
	
	Usuario findByUsernameAndPassword(String Gmail_u, String Password_u);
	
	Usuario findByUsername(String Gmail_u);
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id_u);
	
	public void save(Usuario usuarios);
	
	public void deleteById(Long id_u);


}
