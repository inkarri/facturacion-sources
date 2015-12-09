/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.servicio.factura.impl;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.hibernate.HibernateException;

import ec.com.facturacion.ligas.commons.constantes.FacturacionConstantes;
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
	public EquipoDTO obtenerEquipoPorId(Long idEquipo) throws FacturacionExcepction {
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
	public CategoriaDTO insertarCategoria(CategoriaDTO categoria) throws FacturacionExcepction {
		try {
			if (categoria == null) {
				throw new FacturacionExcepction("Los datos para insertar la categoria no deben estar vacios.");
			}

			return categoriaDao.insertarCategoria(categoria);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de insertar la categoria en la base de datos.", e);
		}
	}

	/**
	 * @see FacturaServicio#insertarEquipo(EquipoDTO)
	 */
	@Override
	public EquipoDTO insertarEquipo(EquipoDTO equipo) throws FacturacionExcepction {
		try {
			if (equipo == null) {
				throw new FacturacionExcepction("Los datos para insertar el equipo no deben estar vacios.");
			}

			return equioDao.insertarEquipo(equipo);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de insertar el equipo en la base de datos.", e);
		}
	}

	/**
	 * @see FacturaServicio#inactivarEquipo(EquipoDTO)
	 */
	@Override
	public void inactivarEquipo(EquipoDTO equipo) throws FacturacionExcepction {
		try {
			if (equipo == null) {
				throw new FacturacionExcepction("Los datos para inactivar el equipo no deben estar vacios.");
			}

			equioDao.inactivarEquipo(equipo);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de inactivar el equipo en la base de datos.", e);
		}
	}

	/**
	 * @see FacturaServicio#obtenerCategorias(String)
	 */
	@Override
	public List<CategoriaDTO> obtenerCategorias(String estado) throws FacturacionExcepction {
		try {
			List<CategoriaDTO> categorias = categoriaDao.obtenerCategorias(estado);
			if (categorias.isEmpty()) {
				categorias = Collections.emptyList();
			}
			return categorias;
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de obtener las categorias.", e);
		}
	}

	/**
	 * @see FacturaServicio#obtenerIdsCategorias(String, String)
	 */
	@Override
	public List<Long> obtenerIdsCategorias(String nombreCategoria, String estado) throws FacturacionExcepction {
		try {
			if (nombreCategoria == null || estado == null) {
				throw new FacturacionExcepction("El nombre y el estado de la categoria son necesarios para filtrar la busqueda.");
			}
			return categoriaDao.obtenerIdsCategorias(nombreCategoria, estado);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de obtener las categorias filtradas por el estado.", e);
		}
	}

	/**
	 * @see FacturaServicio#actualizarCategoria(CategoriaDTO)
	 */
	@Override
	public void actualizarCategoria(CategoriaDTO categoria) throws FacturacionExcepction {
		try {
			if (categoria == null) {
				throw new FacturacionExcepction("Los datos para realizar la actualizacion no deben estar vacios.");
			}
			if (categoria.getIdCategoria() == null) {
				throw new FacturacionExcepction("El identificador para actualizar la categoria es necesario.");
			}
			categoria.setFechaModificacion(Calendar.getInstance());
			categoriaDao.actualizarCategoria(categoria);
		} catch (HibernateException e) {
			throw new FacturacionExcepction("Ocurrio un error al tratar de actualizar la categoria.", e);
		}
	}
	
	/**
	 * @see FacturaServicio#registrarActualizarCategoria(CategoriaDTO)
	 */
	@Override
	public CategoriaDTO registrarActualizarCategoria(CategoriaDTO categoria) throws FacturacionExcepction {
		CategoriaDTO categoriaRegistro;
		List<Long> idCategorias = obtenerIdsCategorias(categoria.getNombreCategoria(), FacturacionConstantes.ESTADO_INACTIVO);
		if (idCategorias.isEmpty()) {
			categoriaRegistro = insertarCategoria(categoria);
		} else {
			categoriaRegistro = categoria;
			categoriaRegistro.setIdCategoria(idCategorias.iterator().next());
			categoriaRegistro.setEstado(FacturacionConstantes.ESTADO_ACTIVO);
			actualizarCategoria(categoriaRegistro);
		}

		return categoriaRegistro;
	}

}
