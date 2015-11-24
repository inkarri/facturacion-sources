/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ec.com.facturacion.ligas.dto.id.EquipoCategoriaID;

/**
 * <b> DTO asociado a la tabla equipocategoria. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "equipocategoria")
public class EquipoCategoriaDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipoCategoriaID id;

	@Column(name = "estado")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria", insertable = false, updatable = false)
	private CategoriaDTO categoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idequipo", insertable = false, updatable = false)
	private EquipoDTO equipo;

	@OneToMany(mappedBy = "equipoCategoria", fetch = FetchType.LAZY)
	private List<IngresoDTO> ingresos;

	public EquipoCategoriaID getId() {
		return id;
	}

	public void setId(EquipoCategoriaID id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public EquipoDTO getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoDTO equipo) {
		this.equipo = equipo;
	}

	public List<IngresoDTO> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<IngresoDTO> ingresos) {
		this.ingresos = ingresos;
	}

}
