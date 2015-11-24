/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <b> ID compuesto para la tabla equipocategoria </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Embeddable
public class EquipoCategoriaID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "idequipo")
	private Long idEquipo;

	@Column(name = "idcategoria")
	private Long idCategoria;

	public Long getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Long idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + ((idEquipo == null) ? 0 : idEquipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EquipoCategoriaID other = (EquipoCategoriaID) obj;
		if (idCategoria == null) {
			if (other.idCategoria != null) {
				return false;
			}
		} else if (!idCategoria.equals(other.idCategoria)) {
			return false;
		}
		if (idEquipo == null) {
			if (other.idEquipo != null) {
				return false;
			}
		} else if (!idEquipo.equals(other.idEquipo)) {
			return false;
		}
		return true;
	}

}
