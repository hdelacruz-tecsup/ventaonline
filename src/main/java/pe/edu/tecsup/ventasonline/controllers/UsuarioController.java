package pe.edu.tecsup.ventasonline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.ventasonline.entities.LoginRequest;
import pe.edu.tecsup.ventasonline.entities.Usuario;
import pe.edu.tecsup.ventasonline.services.UsuarioService;

@RestController
public class UsuarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
    private UsuarioService usuarioService;

	@PostMapping("login")
	public Usuario login(@RequestParam LoginRequest loginrequest)throws Exception{
		logger.info("login("+loginrequest.getGmail_u()+", "+loginrequest.getPassword_u());
		String Gmail_u = loginrequest.getGmail_u();
		String Password_u = loginrequest.getPassword_u();
	//public Usuario login(@RequestParam String Gmail_u, @RequestParam String Password_u) throws Exception{
		//logger.info("login("+Gmail_u+", "+Password_u+")");
		
		Usuario usuario = usuarioService.findByUsernameAndPassword(Gmail_u, Password_u);
		logger.info("Login success: " + usuario);
		
		if(usuario == null)
			throw new Exception("Usuario y/o clave invalido");
		return usuario;
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> usuarios() {
		logger.info("call usuarios");
		
		List<Usuario> usuarios = usuarioService.findAll();
		logger.info("usuarios: " + usuarios);
		
		return usuarios;
	}
	
	@PostMapping("/usuarios")
	public Usuario crear( @RequestParam("Nombre_u") String Nombre_u,@RequestParam("Apellidos_u") String Apellidos_u,@RequestParam("DNI_u") String password_usu,@RequestParam("DNI_u") int DNI_u,@RequestParam("Gmail_u") String Gmail_u,@RequestParam("Direccion_u") String Direccion_u,@RequestParam("Celular_u") int Celular,@RequestParam("Password_u") String Password_u) throws Exception {
		logger.info("call crear(" + Nombre_u + ", " + Apellidos_u + ", " + DNI_u + ", " + Gmail_u + ", " + Direccion_u + ", " + Celular + "," + Password_u + ")");
		
		Usuario usuario = new Usuario();
		usuario.setApellidos_u(Apellidos_u);
		usuario.setNombre_u(Nombre_u);
		usuario.setDNI_u(DNI_u);
		usuario.setGmail_u(Gmail_u);
		usuario.setDireccion_u(Direccion_u);
		usuario.setCelular_u(Celular);
		usuario.setPassword_u(Password_u);
		usuarioService.save(usuario);
		return usuario;
	}
	
	@DeleteMapping("/usuarios/{id_u}")
	public ResponseEntity<String> eliminar(@PathVariable Long id_u) {
		logger.info("call eliminar: " + id_u);
		
		usuarioService.deleteById(id_u);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}
	
	@GetMapping("/usuarios/{id_u}")
	public Usuario obtener(@PathVariable Long id_u) {
		logger.info("call obtener: " + id_u);
		Usuario usuarios = usuarioService.findById(id_u);
		return usuarios;
	}	

}
