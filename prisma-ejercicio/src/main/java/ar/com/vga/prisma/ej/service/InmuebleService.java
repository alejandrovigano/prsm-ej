package ar.com.vga.prisma.ej.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ar.com.vga.prisma.ej.domain.Inmueble;

public interface InmuebleService {

	Optional<Inmueble> findOne(Long id);

	Optional<Inmueble> deletePropietario(Long id);

	Page<Inmueble> findByCategoriaId(Long categoriaId, Pageable pageable);

}
