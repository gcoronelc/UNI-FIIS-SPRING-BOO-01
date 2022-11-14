package pe.edu.uni.eureka.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column("CHR_CLIECODIGO")
	private String codigo;

	@Column("VCH_CLIEPATERNO")
	private String paterno;

	@Column("VCH_CLIEMATERNO")
	private String materno;

	@Column("VCH_CLIENOMBRE")
	private String nombre;

	@Column("CHR_CLIEDNI")
	private String dni;

	@Column("VCH_CLIECIUDAD")
	private String ciudad;

	@Column("VCH_CLIEDIRECCION")
	private String direccion;

	@Column("VCH_CLIETELEFONO")
	private String telefono;

	@Column("VCH_CLIEEMAIL")
	private String email;


	public Cliente() {
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
