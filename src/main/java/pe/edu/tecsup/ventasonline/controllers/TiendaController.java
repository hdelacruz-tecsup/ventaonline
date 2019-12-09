package pe.edu.tecsup.ventasonline.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.tecsup.ventasonline.entities.Tienda;
import pe.edu.tecsup.ventasonline.repositories.TiendaRepository;
import pe.edu.tecsup.ventasonline.services.TiendaService;

@RestController
public class TiendaController {
	
	private static final Logger logger = LoggerFactory.getLogger(TiendaController.class);
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;

	@Autowired
	private TiendaService tiendaService;
	
	@GetMapping("/tienda")
	public List<Tienda> tiendas() {
		logger.info("call tiendas");
		
		List<Tienda> tiendas = tiendaService.findAll();
		logger.info("tiendas: " + tiendas);
		
		return tiendas;
	}
	
	@GetMapping("/tienda/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		logger.info("call images: " + filename);
		
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		logger.info("Path: " + path);
		
		if(!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new UrlResource(path.toUri());
		logger.info("Resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}

	
	@PostMapping("/tienda")
	public Tienda crear(@RequestParam(name="Imagen_ti", required=false) MultipartFile Imagen_ti, @RequestParam("Nombre_ti") String Nombre_ti,@RequestParam("Fechaini_ti") Date Fechaini_ti,@RequestParam("Ruc_ti") Long Ruc_ti,@RequestParam("Descripcion_ti") String Descripcion_ti,@RequestParam("Categoria_ti") String Categoria_ti,@RequestParam("id_usuariot") Long idusuariot) throws Exception {
	logger.info("call crear(" + Imagen_ti + ", " + Nombre_ti + ", " + Fechaini_ti + ", " + Ruc_ti + ", " + Descripcion_ti + ","+ Categoria_ti +","+ idusuariot +")");

	Tienda tienda = new Tienda();
	tienda.setNombre_ti(Nombre_ti);
	tienda.setFechaini_ti(Fechaini_ti);
	tienda.setRuc_ti(Ruc_ti);
	tienda.setDescripcion_ti(Descripcion_ti);
	tienda.setCategoria_ti(Categoria_ti);
	tienda.setId_usuariot(idusuariot);
		
		if (Imagen_ti != null && !Imagen_ti.isEmpty()) {
			String filename = System.currentTimeMillis() + Imagen_ti.getOriginalFilename().substring(Imagen_ti.getOriginalFilename().lastIndexOf("."));
			tienda.setImagen_ti(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(Imagen_ti.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		
		tiendaService.save(tienda);
		
		return tienda;
	}
	
	
	@DeleteMapping("/tienda/{id_ti}")
	public ResponseEntity<String > eliminar(@PathVariable Long id_ti) {
		logger.info("call eliminar: " + id_ti);
		
		tiendaService.deleteById(id_ti);
		
		return ResponseEntity.ok().body("Tienda eliminada");
	}
	
	@GetMapping("/tienda/{id_ti}")
	public Tienda obtener(@PathVariable Long id_ti) {
		logger.info("call obtener: " + id_ti);
		
		Tienda tienda = tiendaService.findById(id_ti);
		
		return tienda;
	}
	
	@PutMapping("/tienda/{id_ti}")
    public ResponseEntity<?> updatetienda(@PathVariable(value ="id_ti")Long id_ti,@RequestBody Tienda tienda) {
       
		//enfermedadService.updateById(id);
    Tienda enf= null;
    enf=tiendaService.findById(id_ti);
		//return enfermedadService.findById(id){
       if(enf != null){
			enf.setNombre_ti(tienda.getNombre_ti());
			enf.setFechaini_ti(tienda.getFechaini_ti());
			enf.setRuc_ti(tienda.getRuc_ti());
			enf.setCategoria_ti(tienda.getCategoria_ti());
			enf.setDescripcion_ti(tienda.getDescripcion_ti());
			tiendaService.save(enf);
            return new ResponseEntity<>(enf, HttpStatus.OK);
       }else{
		  return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	   }
    }
	
	@PutMapping("tienda/{id_ti}")
	public Tienda updaterTienda(@RequestBody Tienda tienda, @PathVariable Long id_ti){
		return tiendaService.findById(id_ti).(tie ->{
			tie.setNombre_ti(tienda.getNombre_ti());
			tie.setFechaini_ti(tienda.getFechaini_ti());
			tie.setRuc_ti(tienda.getRuc_ti());
			tie.setCategoria_ti(tienda.getCategoria_ti());
			tie.setDescripcion_ti(tienda.getDescripcion_ti());
			return tiendaService.save(tie);
		}).orElseGet(() ->{
			tienda.setId_ti(id_ti);
			return tiendaService.save(tie);
		});
		
	}
	
}
































