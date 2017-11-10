package ar.com.vga.prisma.ej.web.resource;

import org.springframework.hateoas.ResourceSupport;

public class CategoriaResource extends ResourceSupport {

	private Long categoriaId;
	private String descripcion;

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
