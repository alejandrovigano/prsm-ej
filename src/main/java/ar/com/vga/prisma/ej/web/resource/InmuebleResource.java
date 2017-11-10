package ar.com.vga.prisma.ej.web.resource;

import org.springframework.hateoas.ResourceSupport;

public class InmuebleResource extends ResourceSupport {

	private String descripcion;
	private CategoriaResource categoria;

	public CategoriaResource getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaResource categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
