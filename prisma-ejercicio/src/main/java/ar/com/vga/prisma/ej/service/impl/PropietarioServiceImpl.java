package ar.com.vga.prisma.ej.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.vga.prisma.ej.domain.Propietario;
import ar.com.vga.prisma.ej.exception.ServiceException;
import ar.com.vga.prisma.ej.repository.PropietarioRepository;
import ar.com.vga.prisma.ej.service.PropietarioService;

@Service
public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepository propietarioRepository;

	@Override
	public Long save(Propietario propietario) throws ServiceException {
		try {
			Propietario result = propietarioRepository.save(propietario);
			return result.getId();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Optional<Propietario> findOne(Long id) {
		Propietario propietario = propietarioRepository.findOne(id);
		return Optional.ofNullable(propietario);
	}

	@Override
	public Optional<Propietario> update(Long id, Propietario propietario) {
		Optional<Propietario> propietarioOptional = this.findOne(id);

		if (propietarioOptional.isPresent()) {
			Propietario propietarioOriginal = propietarioOptional.get();
			propietarioOriginal.setApellido(propietario.getApellido());
			propietarioOriginal.setNombre(propietario.getNombre());
			propietarioOriginal.setDomicilio(propietario.getDomicilio());
			propietarioOriginal.setFechaNacimiento(propietario.getFechaNacimiento());
			propietarioOriginal.setSexo(propietario.getSexo());
			propietarioOriginal.setTeléfono(propietario.getTeléfono());

			Propietario propietarioActualizado = propietarioRepository.save(propietarioOriginal);
			return Optional.of(propietarioActualizado);
		}

		return propietarioOptional;
	}

}
