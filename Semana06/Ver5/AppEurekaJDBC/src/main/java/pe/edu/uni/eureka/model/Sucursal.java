package pe.edu.uni.eureka.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("SUCURSAL")
public class Sucursal {

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

}
