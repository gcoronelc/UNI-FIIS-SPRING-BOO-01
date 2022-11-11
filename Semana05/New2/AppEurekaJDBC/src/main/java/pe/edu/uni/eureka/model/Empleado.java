package pe.edu.uni.eureka.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("EMPLEADO")
public class Empleado {

	@Id
	@Column("CHR_EMPLCODIGO")
	private String codigo;

	@Column("VCH_EMPLPATERNO")
	private String paterno;

	@Column("VCH_EMPLMATERNO")
	private String materno;

	@Column("VCH_EMPLNOMBRE")
	private String nombre;

	@Column("VCH_EMPLCIUDAD")
	private String ciudad;

	@Column("VCH_EMPLDIRECCION")
	private String direccion;

	@Column("VCH_EMPLUSUARIO")
	private String usuario;

	@Column("VCH_EMPLCLAVE")
	private String clave;
	
	public Empleado() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
}
