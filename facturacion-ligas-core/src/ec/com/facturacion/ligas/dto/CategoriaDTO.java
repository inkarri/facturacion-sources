/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b> DTO asociado a la tabla categorias. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "categorias")
public class CategoriaDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "categoriasseq", sequenceName = "categoriasseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoriasseq")
	@Column(name = "idcategoria")
	private Long idCategoria;

	@Column(name = "nombrecategoria")
	private String nombreCategoria;

	@Column(name = "estado")
	private String estado;

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
