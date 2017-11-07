package ar.com.vga.prisma.ej.service;

import java.util.Optional;

import ar.com.vga.prisma.ej.domain.Propietario;
import ar.com.vga.prisma.ej.exception.ServiceException;

public interface PropietarioService {

	Long save(Propietario propietario) throws ServiceException;

	Optional<Propietario> findOne(Long id);

	Optional<Propietario> update(Long id, Propietario propietario);

}
