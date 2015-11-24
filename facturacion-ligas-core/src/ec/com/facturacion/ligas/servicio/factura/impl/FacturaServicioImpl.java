/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.servicio.factura.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.hibernate.HibernateException;

import ec.com.facturacion.ligas.commons.exception.FacturacionExcepction;
import ec.com.facturacion.ligas.dao.EquipoDao;
import ec.com.facturacion.ligas.dto.EquipoDTO;
import ec.com.facturacion.ligas.servicio.factura.FacturaServicio;

/**
 * <b> Impementacion de los servicios asociados al proceso de facturacion. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Stateless
public class FacturaServicioImpl implements FacturaServicio {

	@EJB
	private EquipoDao equioDao;

	/**
	 * @see FacturaServicio#obtenerEquipoPorId(Long)
	 */
	@Override
	public EquipoDTO obtenerEquipoPorId(Long idEquipo) {
		try {
			if (idEquipo == null) {
				throw new FacturacionExcepction("Es necesaria la clave para realizar la busqueda");
			}

			EquipoDTO equipo = equioDao.obtenerEquipoPorId(idEquipo);
			if (equipo == null) {
				throw new FacturacionExcepction("No existe un equipo con la clave ".concat(idEquipo.toString()));
			}
			return equipo;
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Error al tratar de obtener el equipo", e);
		}
	}

}
