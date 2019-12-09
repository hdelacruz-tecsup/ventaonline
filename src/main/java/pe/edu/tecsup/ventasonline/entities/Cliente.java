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
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cl;
	
	private String Nombre_cl;
	
	private String Direccion_cl;
	
	private int Celular_cl;
	
	private int DNI_cl;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente",referencedColumnName="id_cl")
	private List<Factura> factura=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_cliente",referencedColumnName="id_cl")
	private List<Producto> producto=new ArrayList<>();

	public Long getId_cl() {
		return id_cl;
	}

	public void setId_cl(Long id_cl) {
		this.id_cl = id_cl;
	}

	public String getNombre_cl() {
		return Nombre_cl;
	}

	public void setNombre_cl(String nombre_cl) {
		Nombre_cl = nombre_cl;
	}

	public String getDireccion_cl() {
		return Direccion_cl;
	}

	public void setDireccion_cl(String direccion_cl) {
		Direccion_cl = direccion_cl;
	}

	public int getCelular_cl() {
		return Celular_cl;
	}

	public void setCelular_cl(int celular_cl) {
		Celular_cl = celular_cl;
	}

	public int getDNI_cl() {
		return DNI_cl;
	}

	public void setDNI_cl(int dNI_cl) {
		DNI_cl = dNI_cl;
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
		return "Cliente [id_cl=" + id_cl + ", Nombre_cl=" + Nombre_cl + ", Direccion_cl=" + Direccion_cl
				+ ", Celular_cl=" + Celular_cl + ", DNI_cl=" + DNI_cl + ", factura=" + factura + ", producto="
				+ producto + "]";
	}
	
}

