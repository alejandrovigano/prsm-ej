package ar.com.vga.prisma.ej.web.resource.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.web.controller.InmuebleRestController;
import ar.com.vga.prisma.ej.web.resource.InmuebleResource;

/**
 * Mapea un inmueble a un item, una version reducida para mostrar en un listado
 * @author alejandrovigano
 *
 */
@Component
public class InmuebleItemResourceAssembler extends ResourceAssemblerSupport<Inmueble, InmuebleResource> {

	public InmuebleItemResourceAssembler() {
		super(InmuebleRestController.class, InmuebleResource.class);
	}

	@Override
	public InmuebleResource toResource(Inmueble entity) {
		InmuebleResource resource = this.createResourceWithId(entity.getId(), entity);
		resource.setDescripcion(entity.getDescripcion());
		return resource;
	}

}
