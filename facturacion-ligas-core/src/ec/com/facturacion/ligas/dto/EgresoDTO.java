/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b> DTO asicado a la tabla egresos. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "egresos")
public class EgresoDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "egresosseq", sequenceName = "egresosseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "egresosseq")
	@Column(name = "idegreso")
	private Long idEgreso;

	@Column(name = "idcuenta")
	private Long idCuenta;

	@Column(name = "estado")
	private String estado;

	@Column(name = "detalleegreso")
	private String detalleEgreso;

	@Column(name = "comprobante")
	private String comprobante;

	@Column(name = "valor")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcuenta", insertable = false, updatable = false)
	private CuentaDTO cuenta;

	public Long getIdEgreso() {
		return idEgreso;
	}

	public void setIdEgreso(Long idEgreso) {
		this.idEgreso = idEgreso;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDetalleEgreso() {
		return detalleEgreso;
	}

	public void setDetalleEgreso(String detalleEgreso) {
		this.detalleEgreso = detalleEgreso;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

}
