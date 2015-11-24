/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao;

import javax.ejb.Local;

import ec.com.facturacion.ligas.dto.EquipoDTO;

/**
 * <b> Dao asociado a la tabla equipo. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Local
public interface EquipoDao {

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

}
