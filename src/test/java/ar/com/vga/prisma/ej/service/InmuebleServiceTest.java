package ar.com.vga.prisma.ej.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import ar.com.vga.prisma.ej.domain.Inmueble;
import ar.com.vga.prisma.ej.domain.Propietario;
import ar.com.vga.prisma.ej.repository.InmuebleRepository;
import ar.com.vga.prisma.ej.service.impl.InmuebleServiceImpl;

/**
 * Test aislado - la alternativa era usar SpringRunner pero no se justifica para
 * el caso
 * 
 * @author alejandrovigano
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class InmuebleServiceTest {

	@InjectMocks
	private InmuebleService inmuebleService = new InmuebleServiceImpl();

	@Mock
	private InmuebleRepository inmuebleRepository;

	@Test
	public void findOneOk() {
		when(inmuebleRepository.findOne(anyLong())).thenReturn(new Inmueble());
		Optional<Inmueble> inmueble = inmuebleService.findOne(0L);
		assertTrue(inmueble.isPresent());
	}

	@Test
	public void findOneNull() {
		when(inmuebleRepository.findOne(anyLong())).thenReturn(null);
		Optional<Inmueble> inmueble = inmuebleService.findOne(0L);
		assertTrue(!inmueble.isPresent());
	}

	@Test
	public void deletePropietario() {

		Inmueble mockInmueble = new Inmueble();
		mockInmueble.setPropietario(new Propietario());
		when(inmuebleRepository.findOne(anyLong())).thenReturn(mockInmueble);

		Optional<Inmueble> inmueble = inmuebleService.deletePropietario(0L);
		assertTrue(inmueble.isPresent());
		assertNull(inmueble.get().getPropietario());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void findByCategoriaId() {
		Page<Inmueble> page = mock(Page.class);
		when(inmuebleRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(page);

		Page<Inmueble> inmueble = inmuebleService.findByCategoriaId(0L, null);

		assertNotNull(inmueble);
	}
}
