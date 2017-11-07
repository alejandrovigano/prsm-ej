package ar.com.vga.prisma.ej.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.repository.InmuebleRepository;
import ar.com.vga.prisma.ej.service.InmuebleService;

@Service
public class InmuebleServiceImpl implements InmuebleService {

	@Autowired
	private InmuebleRepository inmuebleRepository;

	@Override
	public Optional<Inmueble> findOne(Long id) {
		Inmueble inmueble = inmuebleRepository.findOne(id);
		return Optional.ofNullable(inmueble);
	}

	@Override
	public Optional<Inmueble> deletePropietario(Long id) {
		Optional<Inmueble> inmueble = this.findOne(id);
		if (inmueble.isPresent()) {
			Inmueble entity = inmueble.get();
			entity.setPropietario(null);
			inmuebleRepository.save(entity);
		}
		return inmueble;
	}

	@Override
	public Page<Inmueble> findByCategoriaId(Long categoriaId, Pageable pageable) {
		return inmuebleRepository.findByCategoriaId(categoriaId, pageable);
	}

}
