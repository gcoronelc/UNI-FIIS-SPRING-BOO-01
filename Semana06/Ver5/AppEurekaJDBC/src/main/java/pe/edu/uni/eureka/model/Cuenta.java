package pe.edu.uni.eureka.model;

import java.sql.Date;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CUENTA")
public class Cuenta {

	@Column("CHR_CUENCODIGO")
	private String cuenta;
	@Column("CHR_MONECODIGO")
	private String moneda;
	@Column("CHR_SUCUCODIGO")
	private String sucursal;
	@Column("CHR_EMPLCREACUENTA")
	private String empleado;
	@Column("CHR_CLIECODIGO")
	private String cliente;
	@Column("DEC_CUENSALDO")
	private double saldo;
	@Column("DTT_CUENFECHACREACION")
	private Date fecha;
	@Column("VCH_CUENESTADO")
	private String estado;
	@Column("INT_CUENCONTMOV")
	private int contador;
	@Column("CHR_CUENCLAVE")
	private String clave;
	
	public Cuenta() {
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public String getEmpleado() {
		return empleado;
	}

	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
