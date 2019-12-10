package pe.edu.tecsup.ventasonline.entities;

import java.sql.Date;
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
@Table(name="tienda")
public class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ti;
	
	private String Nombre_ti;
	
	private Date Fechaini_ti;
	
	private Long Ruc_ti;
	
	private String Imagen_ti;
	
	private String Descripcion_ti;
	
	private String Categoria_ti;
	
	private Long id_usuariot;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_tienda",referencedColumnName="id_ti")
	private List<Factura> factura=new ArrayList<>();

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_tienda",referencedColumnName="id_ti")
	private List<Producto> producto=new ArrayList<>();

	public Long getId_ti() {
		return id_ti;
	}

	public void setId_ti(Long id_ti) {
		this.id_ti = id_ti;
	}

	public String getNombre_ti() {
		return Nombre_ti;
	}

	public void setNombre_ti(String nombre_ti) {
		Nombre_ti = nombre_ti;
	}

	public Date getFechaini_ti() {
		return Fechaini_ti;
	}

	public void setFechaini_ti(Date fechaini_ti) {
		Fechaini_ti = fechaini_ti;
	}

	public Long getRuc_ti() {
		return Ruc_ti;
	}

	public void setRuc_ti(Long ruc_ti) {
		Ruc_ti = ruc_ti;
	}

	public String getImagen_ti() {
		return Imagen_ti;
	}

	public void setImagen_ti(String imagen_ti) {
		Imagen_ti = imagen_ti;
	}

	public String getDescripcion_ti() {
		return Descripcion_ti;
	}

	public void setDescripcion_ti(String descripcion_ti) {
		Descripcion_ti = descripcion_ti;
	}

	public String getCategoria_ti() {
		return Categoria_ti;
	}

	public void setCategoria_ti(String categoria_ti) {
		Categoria_ti = categoria_ti;
	}

	public Long getId_usuariot() {
		return id_usuariot;
	}

	public void setId_usuariot(Long id_usuariot) {
		this.id_usuariot = id_usuariot;
	}

	public List<Factura> getFactura() {
		return factura;
	}

	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Tienda [id_ti=" + id_ti + ", Nombre_ti=" + Nombre_ti + ", Fechaini_ti=" + Fechaini_ti + ", Ruc_ti="
				+ Ruc_ti + ", Imagen_ti=" + Imagen_ti + ", Descripcion_ti=" + Descripcion_ti + ", Categoria_ti="
				+ Categoria_ti + ", id_usuariot=" + id_usuariot + ", factura=" + factura + ", producto=" + producto
				+ "]";
	}	
	
}
