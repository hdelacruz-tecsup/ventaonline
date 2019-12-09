package pe.edu.tecsup.ventasonline.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name="factura")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_fac;
	
	private Date Fechaexp_fac;
	
	private Long id_usuario;
	
	private Long id_producto;
	
	private Long id_cliente;
	
	private Long id_tienda;
	
	private double Total_fac;

	public Long getId_fac() {
		return id_fac;
	}

	public void setId_fac(Long id_fac) {
		this.id_fac = id_fac;
	}

	public Date getFechaExp_fac() {
		return Fechaexp_fac;
	}

	public void setFechaExp_fac(Date fechaExp_fac) {
		Fechaexp_fac = fechaExp_fac;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Long getId_tienda() {
		return id_tienda;
	}

	public void setId_tienda(Long id_tienda) {
		this.id_tienda = id_tienda;
	}

	public double getTotal_fac() {
		return Total_fac;
	}

	public void setTotal_fac(double total_fac) {
		Total_fac = total_fac;
	}

	@Override
	public String toString() {
		return "Factura [id_fac=" + id_fac + ", Fechaexp_fac=" + Fechaexp_fac + ", id_usuario=" + id_usuario
				+ ", id_producto=" + id_producto + ", id_cliente=" + id_cliente + ", id_tienda=" + id_tienda
				+ ", Total_fac=" + Total_fac + "]";
	}	
}
