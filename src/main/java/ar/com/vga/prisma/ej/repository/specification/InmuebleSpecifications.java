package ar.com.vga.prisma.ej.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import ar.com.vga.prisma.ej.domain.Inmueble;

public class InmuebleSpecifications {

	public static Specification<Inmueble> categoriaEq(Long idCategoria) {
		return (root, query, cb) -> {
			Join<Object, Object> categoria = root.join("categoria", JoinType.INNER);
			return cb.equal(categoria.get("id"), idCategoria);
		};
	}

}
