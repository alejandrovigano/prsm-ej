package ar.com.vga.prisma.ej.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ar.com.vga.prisma.ej.domain.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long>, JpaSpecificationExecutor<Inmueble>  {

}
