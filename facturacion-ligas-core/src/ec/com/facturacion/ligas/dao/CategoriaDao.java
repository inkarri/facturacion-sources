/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao;

import javax.ejb.Local;

import ec.com.facturacion.ligas.dto.CategoriaDTO;

/**
 * <b> Dao asociado a la tabla categoria. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Local
public interface CategoriaDao {

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
