/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.facturacion.ligas.dto.id.CatalogoValorID;

/**
 * <b> DTO asociado a la tabla catalogovalor. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "catalogovalor")
public class CatalagoValorDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CatalogoValorID id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estado")
	private String estado;

	public CatalogoValorID getId() {
		return id;
	}

	public void setId(CatalogoValorID id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
