/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao;

import java.util.List;

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
	
	/**
	 * <b> Otiene las categorias filtadas por un estado. </b>
	 * <p>
	 * [Author: inkarri, Date: 1/12/2015]
	 * </p>
	 *
	 * @param estado
	 *            puede ser activo o inactivo
	 * @return categias registradas
	 */
	List<CategoriaDTO> obtenerCategorias(String estado);
	
	/**
		 * <b> Obtiene los ids de las categorias filtradas por el nombre y un estado determinado. </b>
	 * <p>
	 * [Author: inkarri, Date: 8/12/2015]
	 * </p>
	 *
	 * @param nombreCategoria
	 *            nombre de la categoria a buscar
	 * @param estado
	 *            filtra la busqueda por el estado de la categoria (1, 0)
	 * @return codigos de las categorias que cumplan con los criterios de busqueda
	 */
	public List<Long> obtenerIdsCategorias(String nombreCategoria, String estado);
	
	/**
	 * <b> Actualiza datos de la categoria dependiendo de los datos que tenga el objeto que se le paa como parametro. </b>
	 * <p>
	 * [Author: inkarri, Date: 8/12/2015]
	 * </p>
	 *
	 * @param categoria
	 *            objeto que contiene los datos que seran actualizados
	 */
	public void actualizarCategoria(CategoriaDTO categoria);

}
