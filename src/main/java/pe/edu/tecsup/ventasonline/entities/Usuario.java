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
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_u;
	
	private String Nombre_u;
	
	private String Apellidos_u;
	
	private int DNI_u;
	
	private String Gmail_u;
	
	private String Direccion_u;
	
	private int Celular_u;
	
	private String Password_u;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_usuariot",referencedColumnName="id_u")
	private List<Tienda> tienda=new ArrayList<>();


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_usuario",referencedColumnName="id_u")
	private List<Factura> factura=new ArrayList<>();


	public Long getId_u() {
		return id_u;
	}


	public void setId_u(Long id_u) {
		this.id_u = id_u;
	}


	public String getNombre_u() {
		return Nombre_u;
	}


	public void setNombre_u(String nombre_u) {
		Nombre_u = nombre_u;
	}


	public String getApellidos_u() {
		return Apellidos_u;
	}


	public void setApellidos_u(String apellidos_u) {
		Apellidos_u = apellidos_u;
	}


	public int getDNI_u() {
		return DNI_u;
	}


	public void setDNI_u(int dNI_u) {
		DNI_u = dNI_u;
	}


	public String getGmail_u() {
		return Gmail_u;
	}


	public void setGmail_u(String gmail_u) {
		Gmail_u = gmail_u;
	}


	public String getDireccion_u() {
		return Direccion_u;
	}


	public void setDireccion_u(String direccion_u) {
		Direccion_u = direccion_u;
	}


	public int getCelular_u() {
		return Celular_u;
	}


	public void setCelular_u(int celular_u) {
		Celular_u = celular_u;
	}


	public String getPassword_u() {
		return Password_u;
	}


	public void setPassword_u(String password_u) {
		Password_u = password_u;
	}


	public List<Tienda> getTienda() {
		return tienda;
	}


	public void setTienda(List<Tienda> tienda) {
		this.tienda = tienda;
	}


	public List<Factura> getFactura() {
		return factura;
	}


	public void setFactura(List<Factura> factura) {
		this.factura = factura;
	}


	@Override
	public String toString() {
		return "Usuario [id_u=" + id_u + ", Nombre_u=" + Nombre_u + ", Apellidos_u=" + Apellidos_u + ", DNI_u=" + DNI_u
				+ ", Gmail_u=" + Gmail_u + ", Direccion_u=" + Direccion_u + ", Celular_u=" + Celular_u + ", Password_u="
				+ Password_u + ", tienda=" + tienda + ", factura=" + factura + "]";
	}

	
	
}
