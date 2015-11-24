/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b> DTO asociado a la tabla cuentas. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "cuentas")
public class CuentaDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "cuentasseq", sequenceName = "cuentasseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuentasseq")
	@Column(name = "idcuenta")
	private Long idCuenta;

	@Column(name = "codigotipocuenta")
	private Long codigoTipoCuenta;

	@Column(name = "valortipocuenta")
	private String valorTipoCuenta;

	@Column(name = "nombrecuenta")
	private String nombreCuenta;

	@Column(name = "estado")
	private String estado;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "comision")
	private Double comision;

	@Column(name = "valor")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "codigotipocuenta", referencedColumnName = "codigocatalogotipo", insertable = false, updatable = false),
			@JoinColumn(name = "valortipocuenta", referencedColumnName = "codigoCatalogoValor", insertable = false, updatable = false) })
	private CatalagoValorDTO tipoCuenta;

	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<IngresoDTO> ingresos;

	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<EgresoDTO> egresos;

	@OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private List<OtroIngresoDTO> otrosIngresos;

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Long getCodigoTipoCuenta() {
		return codigoTipoCuenta;
	}

	public void setCodigoTipoCuenta(Long codigoTipoCuenta) {
		this.codigoTipoCuenta = codigoTipoCuenta;
	}

	public String getValorTipoCuenta() {
		return valorTipoCuenta;
	}

	public void setValorTipoCuenta(String valorTipoCuenta) {
		this.valorTipoCuenta = valorTipoCuenta;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public CatalagoValorDTO getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(CatalagoValorDTO tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public List<IngresoDTO> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<IngresoDTO> ingresos) {
		this.ingresos = ingresos;
	}

	public List<EgresoDTO> getEgresos() {
		return egresos;
	}

	public void setEgresos(List<EgresoDTO> egresos) {
		this.egresos = egresos;
	}

	public List<OtroIngresoDTO> getOtrosIngresos() {
		return otrosIngresos;
	}

	public void setOtrosIngresos(List<OtroIngresoDTO> otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

}
