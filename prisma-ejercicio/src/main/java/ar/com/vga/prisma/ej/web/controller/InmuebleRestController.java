package ar.com.vga.prisma.ej.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.service.InmuebleService;
import ar.com.vga.prisma.ej.web.resource.InmuebleItemResource;
import ar.com.vga.prisma.ej.web.resource.InmuebleResource;
import ar.com.vga.prisma.ej.web.resource.assembler.InmuebleItemResourceAssembler;
import ar.com.vga.prisma.ej.web.resource.assembler.InmuebleResourceAssembler;

@RestController
@RequestMapping("/inmueble")
@ExposesResourceFor(Inmueble.class)
public class InmuebleRestController {

	@Autowired
	private InmuebleService inmuebleService;

	@Autowired
	private InmuebleResourceAssembler inmuebleResourceAssembler;

	@Autowired
	private InmuebleItemResourceAssembler inmuebleItemResourceAssembler;

	@GetMapping("/{id}")
	public ResponseEntity<InmuebleResource> get(@PathVariable("id") Long id) {
		Optional<Inmueble> inmueble = inmuebleService.findOne(id);
		if (inmueble.isPresent()) {
			InmuebleResource resource = inmuebleResourceAssembler.toResource(inmueble.get());
			return ResponseEntity.ok().body(resource);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}/propietario")
	public ResponseEntity<?> deletePropietario(@PathVariable("id") Long id) {
		Optional<Inmueble> inmueble = inmuebleService.deletePropietario(id);
		if (inmueble.isPresent()) {
			return ResponseEntity.ok().body("Relacion con el propietario eliminada: " + id);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	// para muchos mas atributos a filtrar, encapsular en un objeto o usar un
	// parametro ?q=..
	@GetMapping("/")
	@SuppressWarnings("all")
	public ResponseEntity<PagedResources<InmuebleItemResource>> search(@RequestParam("categoria") Long categoriaId,
			@PageableDefault Pageable pageable, PagedResourcesAssembler assembler) {
		Page<Inmueble> page = inmuebleService.findByCategoriaId(categoriaId, pageable);

		PagedResources<InmuebleItemResource> resources = assembler.toResource(page, inmuebleItemResourceAssembler);

		return ResponseEntity.ok().body(resources);
	}

}
