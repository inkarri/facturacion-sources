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
 * <b> DTO asociado a la tabla otrosigresos. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "otrosingresos")
public class OtroIngresoDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "otrosingresosseq", sequenceName = "otrosingresosseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "otrosingresosseq")
	@Column(name = "idotrosingreso")
	private Long idOtroIngreso;

	@Column(name = "idcuenta")
	private Long idCuenta;

	@Column(name = "estado")
	private String estado;

	@Column(name = "detalleingreso")
	private String detalleIngreso;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "valor")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcuenta", insertable = false, updatable = false)
	private CuentaDTO cuenta;

	public Long getIdOtroIngreso() {
		return idOtroIngreso;
	}

	public void setIdOtroIngreso(Long idOtroIngreso) {
		this.idOtroIngreso = idOtroIngreso;
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

	public String getDetalleIngreso() {
		return detalleIngreso;
	}

	public void setDetalleIngreso(String detalleIngreso) {
		this.detalleIngreso = detalleIngreso;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
