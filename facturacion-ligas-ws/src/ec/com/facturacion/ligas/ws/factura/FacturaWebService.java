/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.ws.factura;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.com.facturacion.ligas.dto.CategoriaDTO;
import ec.com.facturacion.ligas.dto.EquipoDTO;
import ec.com.facturacion.ligas.servicio.factura.FacturaServicio;
import ec.com.facturacion.ligas.ws.commons.exception.FacturacionWebServiceException;

/**
 * <b> Srvicios web asociados al proceso de facturacion. </b>
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

	@POST
	@Path("/insertarCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CategoriaDTO insertarCategoria(CategoriaDTO categoria) {
		try {
			return facturaServicio.insertarCategoria(categoria);
		} catch (RuntimeException e) {
			throw new FacturacionWebServiceException(e.getMessage());
		}
	}
	
	@GET
	@Path("/obtenerCategorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CategoriaDTO> obtenerCategorias(@QueryParam("estado") String estado) {
		try {
			return facturaServicio.obtenerCategorias(estado);
		} catch (RuntimeException e) {
			throw new FacturacionWebServiceException(e.getMessage());
		}
	}
	
	@POST
	@Path("/registrarActualizarCategoria")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CategoriaDTO registrarActualizarCategoria(CategoriaDTO categoria) {
		try {
			return facturaServicio.registrarActualizarCategoria(categoria);
		} catch (RuntimeException e) {
			throw new FacturacionWebServiceException(e.getMessage());
		}
	}
	
	@POST
	@Path("/inactivarCategoria")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inactivarCategoria(CategoriaDTO categoria) {
		try {
			facturaServicio.actualizarCategoria(categoria);
		} catch (RuntimeException e) {
			throw new FacturacionWebServiceException(e.getMessage());
		}
	}

}
