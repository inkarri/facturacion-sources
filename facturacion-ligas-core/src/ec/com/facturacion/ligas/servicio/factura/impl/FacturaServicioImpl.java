/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.servicio.factura.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.hibernate.HibernateException;

import ec.com.facturacion.ligas.commons.exception.FacturacionExcepction;
import ec.com.facturacion.ligas.dao.CategoriaDao;
import ec.com.facturacion.ligas.dao.EquipoDao;
import ec.com.facturacion.ligas.dto.CategoriaDTO;
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

	@EJB
	private CategoriaDao categoriaDao;

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

	/**
	 * @see FacturaServicio#insertarCategoria(CategoriaDTO)
	 */
	@Override
	public CategoriaDTO insertarCategoria(CategoriaDTO categoria) {
		try {
			if (categoria == null) {
				throw new FacturacionExcepction("Los datos para insertar la categoria no deben estar vacios.");
			}

			return categoriaDao.insertarCategoria(categoria);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de insertar la categoria en la base de datos.", e);
		}
	}

	@Override
	public EquipoDTO insertarEquipo(EquipoDTO equipo) {
		try {
			if (equipo == null) {
				throw new FacturacionExcepction("Los datos para insertar el equipo no deben estar vacios.");
			}

			return equioDao.insertarEquipo(equipo);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de insertar el equipo en la base de datos.", e);
		}
	}

	@Override
	public void inactivarEquipo(EquipoDTO equipo) {
		try {
			if (equipo == null) {
				throw new FacturacionExcepction("Los datos para inactivar el equipo no deben estar vacios.");
			}

			equioDao.inactivarEquipo(equipo);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de inactivar el equipo en la base de datos.", e);
		}
	}

}
