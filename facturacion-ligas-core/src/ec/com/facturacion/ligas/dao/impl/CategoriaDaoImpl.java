/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao.impl;

import javax.ejb.Stateless;

import ec.com.facturacion.ligas.dao.CategoriaDao;
import ec.com.facturacion.ligas.dao.CommonsDao;
import ec.com.facturacion.ligas.dto.CategoriaDTO;

/**
 * <b> Implementcion del dao asociada a la tabla categoria. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Stateless
public class CategoriaDaoImpl extends CommonsDao implements CategoriaDao {

	/**
	 * @see CategoriaDao#insertarCategoria(CategoriaDTO)
	 */
	@Override
	public CategoriaDTO insertarCategoria(CategoriaDTO categoria) {
		em.persist(categoria);
		return categoria;
	}

}
