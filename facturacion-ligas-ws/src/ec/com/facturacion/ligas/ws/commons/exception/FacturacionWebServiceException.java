/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.ws.commons.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * <b> Maneja las excepciones en la parte de los web services. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
public class FacturacionWebServiceException extends WebApplicationException {

	private static final long serialVersionUID = -118141592640297941L;

	public FacturacionWebServiceException() {
		super(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build());
	}

	public FacturacionWebServiceException(String message) {
		super(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message == null ? "Error desconocido" : message)
				.type("text/plain").build());
	}

}
