package ar.com.vga.prisma.ej.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.vga.prisma.ej.domain.Categoria;
import ar.com.vga.prisma.ej.domain.Propietario;
import ar.com.vga.prisma.ej.service.CategoriaService;
import ar.com.vga.prisma.ej.web.resource.CategoriaResource;
import ar.com.vga.prisma.ej.web.resource.assembler.CategoriaResourceAssembler;

@RestController
@RequestMapping("/categoria")
@ExposesResourceFor(Propietario.class)
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private CategoriaResourceAssembler categoriaResourceAssembler;

	@GetMapping
	public ResponseEntity<List<CategoriaResource>> list() {
		List<Categoria> categorias = categoriaService.findAll();

		List<CategoriaResource> resources = categoriaResourceAssembler.toResources(categorias);
		return ResponseEntity.ok().body(resources);
	}

}
