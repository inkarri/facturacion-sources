/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.ws.factura;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ec.com.facturacion.ligas.dto.EquipoDTO;
import ec.com.facturacion.ligas.servicio.factura.FacturaServicio;
import ec.com.facturacion.ligas.ws.commons.exception.FacturacionWebServiceException;

/**
 * <b> Srvicios web asoiados al proceso de facturacion. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Path("/facturacion")
@Stateless
public class FacturaWebService {

	@EJB
	private FacturaServicio facturaServicio;

	@GET
	@Path("/obtenerEquipoPorId/{idEquipo}")
	@Produces(MediaType.APPLICATION_JSON)
	public EquipoDTO obtenerEquipoPorId(@PathParam(value = "idEquipo") Long idEquipo) {
		try {
			return facturaServicio.obtenerEquipoPorId(idEquipo);
		} catch (RuntimeException e) {
			throw new FacturacionWebServiceException(e.getMessage());
		}
	}

}
