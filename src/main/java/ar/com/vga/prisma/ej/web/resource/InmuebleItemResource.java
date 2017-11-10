package ar.com.vga.prisma.ej.web.resource;

import org.springframework.hateoas.ResourceSupport;

public class InmuebleItemResource extends ResourceSupport {

	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
