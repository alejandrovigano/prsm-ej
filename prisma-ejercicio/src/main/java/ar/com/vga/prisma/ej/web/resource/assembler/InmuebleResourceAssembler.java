package ar.com.vga.prisma.ej.web.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ar.com.vga.prisma.ej.domain.Categoria;
import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.web.controller.InmuebleRestController;
import ar.com.vga.prisma.ej.web.controller.PropietarioRestController;
import ar.com.vga.prisma.ej.web.resource.CategoriaResource;
import ar.com.vga.prisma.ej.web.resource.InmuebleResource;

/**
 * Mapea un inmueble a una versio completa, para ver el detalle del mismo
 * 
 * @author alejandrovigano
 *
 */
@Component
public class InmuebleResourceAssembler extends ResourceAssemblerSupport<Inmueble, InmuebleResource> {

	public InmuebleResourceAssembler() {
		super(InmuebleRestController.class, InmuebleResource.class);
	}

	@Override
	public InmuebleResource toResource(Inmueble entity) {
		InmuebleResource resource = this.createResourceWithId(entity.getId(), entity);
		resource.setDescripcion(entity.getDescripcion());
		resource.setCategoria(toResource(entity.getCategoria()));
		if (entity.getPropietario() != null) {
			Long propietarioId = entity.getPropietario().getId();
			resource.add(linkTo(methodOn(PropietarioRestController.class, propietarioId).get(propietarioId))
					.withRel("propietario"));
		}
		return resource;
	}

	private CategoriaResource toResource(Categoria categoria) {
		CategoriaResource res = new CategoriaResource();

		res.setId(categoria.getId());
		res.setDescripcion(categoria.getDescripcion());

		return res;
	}

}
