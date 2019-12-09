package pe.edu.tecsup.ventasonline.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import pe.edu.tecsup.ventasonline.entities.Producto;
import pe.edu.tecsup.ventasonline.services.ProductoService;

@RestController
public class ProductoController {

	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Value("${app.storage.path}")
	private String STORAGEPATH;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> productos() {
		logger.info("call productos");
		
		List<Producto> productos = productoService.findAll();
		logger.info("productos: " + productos);
		
		return productos;
	}
	
	@GetMapping("/productos/images/{filename:.+}")
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

	@PostMapping("/productos")
	public Producto crear(@RequestParam(name="imagen_p", required=false) MultipartFile imagen_p, @RequestParam("Nombre_p") String Nombre_p,@RequestParam("Descripcion_p") String Descripcion_p,@RequestParam("Precio_p") double Precio_p,@RequestParam("id_tienda") Long id_tienda,@RequestParam("id_cliente") Long id_cliente) throws Exception {
	logger.info("call crear(" + Nombre_p + ", " + Descripcion_p + ", " + imagen_p + ", " + Precio_p + ", " + id_cliente + ","+ id_tienda +")");

	Producto producto = new Producto();
	producto.setNombre_p(Nombre_p);
	producto.setDescripcion_p(Descripcion_p);
	producto.setPrecio_p(Precio_p);
	producto.setId_cliente(id_cliente);
	producto.setId_tienda(id_tienda);
		
		if (imagen_p != null && !imagen_p.isEmpty()) {
			String filename = System.currentTimeMillis() + imagen_p.getOriginalFilename().substring(imagen_p.getOriginalFilename().lastIndexOf("."));
			producto.setImagen_p(filename);
			if(Files.notExists(Paths.get(STORAGEPATH))){
		        Files.createDirectories(Paths.get(STORAGEPATH));
		    }
			Files.copy(imagen_p.getInputStream(), Paths.get(STORAGEPATH).resolve(filename));
		}
		
		productoService.save(producto);
		
		return producto;
	}

	@DeleteMapping("/productos/{id_p}")
	public ResponseEntity<String > eliminar(@PathVariable Long id_p) {
		logger.info("call eliminar: " + id_p);
		
		productoService.deleteById(id_p);
		
		return ResponseEntity.ok().body("Registro eliminado");
	}


	@GetMapping("/productos/{id_p}")
	public Producto obtener(@PathVariable Long id_p) {
		logger.info("call obtener: " + id_p);
		
		Producto producto = productoService.findById(id_p);
		
		return producto;
	}

	@PutMapping("/productos/{id_p}")
    public ResponseEntity<?> updaProducto(@PathVariable(value ="id_p")Long id_p,@RequestBody Producto producto) {
       
		//enfermedadService.updateById(id);
    Producto enf= null;
    enf=productoService.findById(id_p);
		//return enfermedadService.findById(id){
       if(enf != null){
			enf.setNombre_p(producto.getNombre_p());
			enf.setDescripcion_p(producto.getDescripcion_p());
			enf.setImagen_p(producto.getImagen_p());
			enf.setPrecio_p(producto.getPrecio_p());
            productoService.save(enf);
            return new ResponseEntity<>(enf, HttpStatus.OK);
       }else{
		  return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	   }
    }
	
}
























