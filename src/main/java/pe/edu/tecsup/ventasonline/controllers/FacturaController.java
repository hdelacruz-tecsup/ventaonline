package pe.edu.tecsup.ventasonline.controllers;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.tecsup.ventasonline.entities.Factura;
import pe.edu.tecsup.ventasonline.services.FacturaService;

@RestController
public class FacturaController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

	
	@Autowired
	private FacturaService facturaService;
	
	@GetMapping("/factura")
	public List<Factura> productos() {
		logger.info("call facturas");
		
		List<Factura> facturas = facturaService.findAll();
		logger.info("facturas: " + facturas);
		
		return facturas;
	}

	@PostMapping("/factura")
	public Factura crear (@RequestParam("id_usuario") Long id_usuario, @RequestParam("id_producto") Long id_producto, @RequestParam("id_cliente") Long id_cliente, @RequestParam("id_tienda") Long id_tienda, @RequestParam("total_fac") double total_fac, @RequestParam("fechaexp_fac") Date fechaexp_fac ) throws Exception {
		logger.info("call crear(" + id_usuario + ", " + id_cliente + ", " + id_producto + ", " + id_tienda + ", " + fechaexp_fac + ", " + total_fac + ")");
		
		Factura factura = new Factura();
		factura.setFechaExp_fac(fechaexp_fac);
		factura.setId_cliente(id_cliente);
		factura.setId_producto(id_producto);
		factura.setId_tienda(id_tienda);
		factura.setId_usuario(id_usuario);
		factura.setTotal_fac(total_fac);
		facturaService.save(factura);
		return factura;
	}

	@DeleteMapping("/factura/{id_fac}")
	public ResponseEntity<String > eliminar(@PathVariable Long id_fac) {
		logger.info("call eliminar: " + id_fac);
		
		facturaService.deleteById(id_fac);
		
		return ResponseEntity.ok().body("Factura eliminada");
	}

	
	@GetMapping("/factura/{id_fac}")
	public Factura obtener(@PathVariable Long id_fac) {
		logger.info("call obtener: " + id_fac);
		
		Factura factura = facturaService.findById(id_fac);
		
		return factura;
	}

	
}
























