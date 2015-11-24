/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * <b> DTO asociado a la tabla ingresos. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Entity
@Table(name = "ingresos")
public class IngresoDTO extends AuditoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ingresosseq", sequenceName = "ingresosseq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingresosseq")
	@Column(name = "idingreso")
	private Long idIngreso;

	@Column(name = "codigotipoconcepto")
	private Long codigoTipoConcepto;

	@Column(name = "valortipoconcepto")
	private String valorTipoConcepto;

	@Column(name = "idcuenta")
	private Long idCuenta;

	@Column(name = "idequipo")
	private Long idEquipo;

	@Column(name = "idcategoria")
	private Long idCategoria;

	@Column(name = "estado")
	private String estado;

	@Column(name = "fechasancion")
	private Calendar fechaSancion;

	@Column(name = "fechapago")
	private Calendar fechaPago;

	@Column(name = "fechacobro")
	private Calendar fechaCobro;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "referencia")
	private String referencia;

	@Column(name = "deuda")
	private Double deuda;

	@Column(name = "cobro")
	private Double cobro;

	@Column(name = "saldo")
	private Double saldo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "idequipo", referencedColumnName = "idequipo", insertable = false, updatable = false),
			@JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria", insertable = false, updatable = false) })
	private EquipoCategoriaDTO equipoCategoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcuenta", insertable = false, updatable = false)
	private CuentaDTO cuenta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "codigotipoconcepto", referencedColumnName = "codigocatalogotipo", insertable = false, updatable = false),
			@JoinColumn(name = "valortipoconcepto", referencedColumnName = "codigocatalogovalor", insertable = false, updatable = false) })
	private CatalagoValorDTO tipoConcepto;

	public Long getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(Long idIngreso) {
		this.idIngreso = idIngreso;
	}

	public Long getCodigoTipoConcepto() {
		return codigoTipoConcepto;
	}

	public void setCodigoTipoConcepto(Long codigoTipoConcepto) {
		this.codigoTipoConcepto = codigoTipoConcepto;
	}

	public String getValorTipoConcepto() {
		return valorTipoConcepto;
	}

	public void setValorTipoConcepto(String valorTipoConcepto) {
		this.valorTipoConcepto = valorTipoConcepto;
	}

	public Long getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Long idCuenta) {
		this.idCuenta = idCuenta;
	}

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Calendar getFechaSancion() {
		return fechaSancion;
	}

	public void setFechaSancion(Calendar fechaSancion) {
		this.fechaSancion = fechaSancion;
	}

	public Calendar getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Calendar fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Calendar getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(Calendar fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Double getDeuda() {
		return deuda;
	}

	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}

	public Double getCobro() {
		return cobro;
	}

	public void setCobro(Double cobro) {
		this.cobro = cobro;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public EquipoCategoriaDTO getEquipoCategoria() {
		return equipoCategoria;
	}

	public void setEquipoCategoria(EquipoCategoriaDTO equipoCategoria) {
		this.equipoCategoria = equipoCategoria;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	public CatalagoValorDTO getTipoConcepto() {
		return tipoConcepto;
	}

	public void setTipoConcepto(CatalagoValorDTO tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}

}
