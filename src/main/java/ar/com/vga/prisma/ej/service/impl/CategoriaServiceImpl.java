package ar.com.vga.prisma.ej.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.vga.prisma.ej.domain.Categoria;
import ar.com.vga.prisma.ej.repository.CategoriaRepository;
import ar.com.vga.prisma.ej.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

}
