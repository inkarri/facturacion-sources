/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <b> ID compuesto para la tabla catalogovalor. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Embeddable
public class CatalogoValorID implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "codigocatalogotipo")
	private Long codigoCatalogoTipo;

	@Column(name = "codigocatalogovalor")
	private String codigoCatalogoValor;

	public Long getCodigoCatalogoTipo() {
		return codigoCatalogoTipo;
	}

	public void setCodigoCatalogoTipo(Long codigoCatalogoTipo) {
		this.codigoCatalogoTipo = codigoCatalogoTipo;
	}

	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	public void setCodigoCatalogoValor(String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCatalogoTipo == null) ? 0 : codigoCatalogoTipo.hashCode());
		result = prime * result + ((codigoCatalogoValor == null) ? 0 : codigoCatalogoValor.hashCode());
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
		CatalogoValorID other = (CatalogoValorID) obj;
		if (codigoCatalogoTipo == null) {
			if (other.codigoCatalogoTipo != null) {
				return false;
			}
		} else if (!codigoCatalogoTipo.equals(other.codigoCatalogoTipo)) {
			return false;
		}
		if (codigoCatalogoValor == null) {
			if (other.codigoCatalogoValor != null) {
				return false;
			}
		} else if (!codigoCatalogoValor.equals(other.codigoCatalogoValor)) {
			return false;
		}
		return true;
	}

}
