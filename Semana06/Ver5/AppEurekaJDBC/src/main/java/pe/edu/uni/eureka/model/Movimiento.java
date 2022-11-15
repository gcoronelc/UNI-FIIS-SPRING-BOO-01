package pe.edu.uni.eureka.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

public class Movimiento implements Serializable, Persistable<String> {

	private static final long serialVersionUID = 1L;

	@Column("CHR_CUENCODIGO")
	private String cuenta;
	@Column("INT_MOVINUMERO")
	private int numero;
	@Column("DTT_MOVIFECHA")
	private Date fecha;
	@Column("CHR_EMPLCODIGO")
	private String empleado;
	@Column("CHR_TIPOCODIGO")
	private String tipo;
	@Column("DEC_MOVIIMPORTE")
	private double importe;
	@Column("CHR_CUENREFERENCIA")
	private String referencia;
	
	@Transient
	private boolean nuevo;

	public Movimiento() {
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}
	
	@Override
	public String getId() {
		return null;
	}

	@Override
	public boolean isNew() {
		return nuevo;
	}

}
