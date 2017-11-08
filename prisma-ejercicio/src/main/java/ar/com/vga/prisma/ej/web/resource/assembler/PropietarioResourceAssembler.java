package ar.com.vga.prisma.ej.web.resource.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.domain.Propietario;
import ar.com.vga.prisma.ej.utils.PrismaUtils;
import ar.com.vga.prisma.ej.web.controller.PropietarioRestController;
import ar.com.vga.prisma.ej.web.resource.InmuebleResource;
import ar.com.vga.prisma.ej.web.resource.PropietarioResource;

@Component
public class PropietarioResourceAssembler extends ResourceAssemblerSupport<Propietario, PropietarioResource> {

	@Autowired
	private InmuebleItemResourceAssembler inmuebleResourceAssembler;

	public PropietarioResourceAssembler() {
		super(PropietarioRestController.class, PropietarioResource.class);
	}

	@Override
	public PropietarioResource toResource(Propietario entity) {

		PropietarioResource resource = createResourceWithId(entity.getId(), entity);
		resource.setApellido(entity.getApellido());
		resource.setNombre(entity.getNombre());
		resource.setDomicilio(entity.getDomicilio());
		resource.setFechaNacimiento(PrismaUtils.format(entity.getFechaNacimiento()));
		resource.setSexo(entity.getSexo());
		resource.setTelefono(entity.getTelefono());

		resource.setInmuebles(toResource(entity.getInmuebles()));

		return resource;
	}

	private List<InmuebleResource> toResource(List<Inmueble> inmuebles) {
		return inmuebles.stream().map(inmuebleResourceAssembler::toResource).collect(Collectors.toList());
	}

}
