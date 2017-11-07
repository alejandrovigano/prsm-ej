package ar.com.vga.prisma.ej.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vga.prisma.ej.domain.Propietario;
import ar.com.vga.prisma.ej.exception.ServiceException;
import ar.com.vga.prisma.ej.service.PropietarioService;
import ar.com.vga.prisma.ej.web.resource.PropietarioResource;
import ar.com.vga.prisma.ej.web.resource.assembler.PropietarioResourceAssembler;

@RestController
@RequestMapping("/propietario")
@ExposesResourceFor(Propietario.class)
public class PropietarioRestController {

	@Autowired
	private PropietarioService propietarioService;

	@Autowired
	private PropietarioResourceAssembler propietarioResourceAssembler;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Propietario propietario) {
		try {
			Long id = propietarioService.save(propietario);
			return ResponseEntity.ok().body("Creado el propietario: " + id);
		} catch (ServiceException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<PropietarioResource> get(@PathVariable("id") Long id) {
		Optional<Propietario> propietario = propietarioService.findOne(id);
		if (propietario.isPresent()) {
			PropietarioResource resource = propietarioResourceAssembler.toResource(propietario.get());
			return ResponseEntity.ok().body(resource);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Propietario propietario) {
		Optional<Propietario> propietarioActualizado = propietarioService.update(id, propietario);
		if (propietarioActualizado.isPresent()) {
			return ResponseEntity.ok().body("Propietario actualizado: " + id);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
