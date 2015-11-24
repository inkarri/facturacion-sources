/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.commons.exception;

import javax.ejb.ApplicationException;

/**
 * <b> Excepcion que maneja la transaccion en los servicios. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@ApplicationException(rollback = true)
public class FacturacionExcepction extends RuntimeException {

	private static final long serialVersionUID = -1784180190395806924L;

	public FacturacionExcepction() {
	}

	public FacturacionExcepction(String mensaje) {
		super(mensaje);
	}

	public FacturacionExcepction(Throwable causa) {
		super(causa);
	}

	public FacturacionExcepction(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
