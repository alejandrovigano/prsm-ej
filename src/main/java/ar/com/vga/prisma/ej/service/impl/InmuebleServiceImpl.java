package ar.com.vga.prisma.ej.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.repository.InmuebleRepository;
import ar.com.vga.prisma.ej.service.InmuebleService;

import static ar.com.vga.prisma.ej.repository.specification.InmuebleSpecifications.categoriaEq;
import static org.springframework.data.jpa.domain.Specifications.*;

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

	//Ampliable, por eso el uso de specifications
	@Override
	public Page<Inmueble> findByCategoriaId(Long categoriaId, Pageable pageable) {
		if(categoriaId != null) {			
			//return inmuebleRepository.findAll(where(categoriaEq(categoriaId)).and().or()...., pageable);
			return inmuebleRepository.findAll(where(categoriaEq(categoriaId)), pageable);
		}else {
			return inmuebleRepository.findAll(pageable);
		}
	}

}
