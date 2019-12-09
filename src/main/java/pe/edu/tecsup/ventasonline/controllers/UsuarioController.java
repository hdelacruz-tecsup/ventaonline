package pe.edu.tecsup.ventasonline.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.ventasonline.entities.Usuario;
import pe.edu.tecsup.ventasonline.services.UsuarioService;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
    private UsuarioService usuarioService;

	@PostMapping("login")
	public Usuario login(@RequestParam String Gmail_u, @RequestParam String Password_u) throws Exception{
		logger.info("login("+Gmail_u+", "+Password_u+")");
		
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

}
