package ar.com.vga.prisma.ej.web.resource;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class PropietarioResource extends ResourceSupport {

	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private String sexo;
	private String fechaNacimiento;

	// agrego como lista y no como link, ya que pide devolver todos los inmuebles
	// (tampoco pagino)
	private List<InmuebleResource> inmuebles;

	public List<InmuebleResource> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<InmuebleResource> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
