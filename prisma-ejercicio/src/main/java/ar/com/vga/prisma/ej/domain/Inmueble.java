package ar.com.vga.prisma.ej.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "categoria_id", nullable = true)
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "propietario_id", nullable = true)
	private Propietario propietario;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
