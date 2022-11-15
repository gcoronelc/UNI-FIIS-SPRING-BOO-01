package pe.edu.uni.eureka.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("SUCURSAL")
public class Sucursal implements Serializable, Persistable<String> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column("CHR_SUCUCODIGO")
	private String codigo;
	@Column("VCH_SUCUNOMBRE")
	private String nombre;
	@Column("VCH_SUCUCIUDAD")
	private String ciudad;
	@Column("VCH_SUCUDIRECCION")
	private String direccion;
	@Column("INT_SUCUCONTCUENTA")
	private int contador;

	@Transient
	private boolean nuevo;

	public Sucursal() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	@Override
	public String getId() {
		return codigo;
	}

	@Override
	public boolean isNew() {
		return nuevo;
	}

}
