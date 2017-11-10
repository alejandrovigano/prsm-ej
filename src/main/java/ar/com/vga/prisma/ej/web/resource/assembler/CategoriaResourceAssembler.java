package ar.com.vga.prisma.ej.web.resource.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ar.com.vga.prisma.ej.domain.Categoria;
import ar.com.vga.prisma.ej.web.controller.CategoriaRestController;
import ar.com.vga.prisma.ej.web.resource.CategoriaResource;

@Component
public class CategoriaResourceAssembler extends ResourceAssemblerSupport<Categoria, CategoriaResource> {

	public CategoriaResourceAssembler() {
		super(CategoriaRestController.class, CategoriaResource.class);
	}

	public CategoriaResource toResource(Categoria categoria) {
		CategoriaResource res = new CategoriaResource();

		res.setCategoriaId(categoria.getId());
		res.setDescripcion(categoria.getDescripcion());

		return res;
	}
}
