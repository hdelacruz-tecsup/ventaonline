package pe.edu.tecsup.ventasonline.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_p;
	
	private String Nombre_p;

	private String Descripcion_p;
	
	private String imagen_p;
	
	private double Precio_p;
	
	private Long id_tienda;
	
	private Long id_cliente;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_producto",referencedColumnName="id_p")
	private List<Factura> factura=new ArrayList<>();

	public Long getId_p() {
		return id_p;
	}

	public void setId_p(Long id_p) {
		this.id_p = id_p;
	}

	public String getNombre_p() {
		return Nombre_p;
	}

	public void setNombre_p(String nombre_p) {
		Nombre_p = nombre_p;
	}

	public String getDescripcion_p() {
		return Descripcion_p;
	}

	public void setDescripcion_p(String descripcion_p) {
		Descripcion_p = descripcion_p;
	}

	public String getImagen_p() {
		return imagen_p;
	}

	public void setImagen_p(String imagen_p) {
		this.imagen_p = imagen_p;
	}

	public double getPrecio_p() {
		return Precio_p;
	}

	public void setPrecio_p(double precio_p) {
		Precio_p = precio_p;
	}

	public Long getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(Long id_tienda) {
		this.id_tienda = id_tienda;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public List<Factura> getFactura() {
		return factura;
	}

	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Producto [id_p=" + id_p + ", Nombre_p=" + Nombre_p + ", Descripcion_p=" + Descripcion_p + ", imagen_p="
				+ imagen_p + ", Precio_p=" + Precio_p + ", id_tienda=" + id_tienda + ", id_cliente=" + id_cliente
				+ ", factura=" + factura + "]";
	}

	
}

