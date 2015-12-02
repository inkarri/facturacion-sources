/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.servicio.factura;

import javax.ejb.Local;

import ec.com.facturacion.ligas.dto.CategoriaDTO;
import ec.com.facturacion.ligas.dto.EquipoDTO;

/**
 * <b> Servicio asociado al proceso de facturacion; expone los metodos necesarios para el proceso de facturacion. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Local
public interface FacturaServicio {

	/**
	 * <b> Obtiene un equipo en base a su identificador. </b>
	 * <p>
	 * [Author: inkarri, Date: 23/11/2015]
	 * </p>
	 *
	 * @param idEquipo
	 *            identificador de un equipo
	 * @return equipo registrado en la base de datos
	 */
	EquipoDTO obtenerEquipoPorId(Long idEquipo);
	
	/**
	 * <b> Inserta un equipo en la base de datos. </b>
	 * <p>
	 * [Author: inkarri, Date: 24/11/2015]
	 * </p>
	 *
	 * @param equipo
	 *            datos a insertar
	 * @return data insertado en la base
	 */
	EquipoDTO insertarEquipo(EquipoDTO equipo);

	/**
	 * <b> Inactiva un registro correspondiente a un equipo. </b>
	 * <p>
	 * [Author: inkarri, Date: 24/11/2015]
	 * </p>
	 *
	 * @param equipo
	 *            datos del equipo a inactivar
	 */
	void inactivarEquipo(EquipoDTO equipo);
	
	/**
	 * <b> Agrega una categoria a la base de datos. </b>
	 * <p>
	 * [Author: inkarri, Date: 23/11/2015]
	 * </p>
	 *
	 * @param categoria
	 * @return
	 */
	CategoriaDTO insertarCategoria(CategoriaDTO categoria);

}
