package pe.edu.uni.eureka.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CONTADOR")
public class Contador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column("VCH_CONTTABLA")
	private String tabla;
	
	@Column("INT_CONTITEM")
	private int contador;
	
	@Column("INT_CONTLONGITUD")
	private int longitud;
	
	public Contador() {
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
}
