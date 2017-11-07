package ar.com.vga.prisma.ej.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.vga.prisma.ej.domain.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

	Page<Inmueble> findByCategoriaId(Long idCategoria, Pageable pageable);

}
