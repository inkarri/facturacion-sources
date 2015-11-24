/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * <b> Cotiene los datos de auditoria comun para todos los DTOs. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@MappedSuperclass
public class AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "fechacreacion")
	protected Calendar fechaCreacion;

	@Column(name = "fechamodificacion")
	protected Calendar fechaModificacion;

	@Column(name = "usuarioregistro")
	protected String usuarioRegistro;

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
