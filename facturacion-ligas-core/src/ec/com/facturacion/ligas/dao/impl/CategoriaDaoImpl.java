/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

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

	/**
	* @see CategoriaDao#obtenerCategorias(String)
	*/ 
	@Override
	public List<CategoriaDTO> obtenerCategorias(String estado) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT cat FROM CategoriaDTO cat ".
		    concat("WHERE cat.estado = :estado "));

		Query query = em.createQuery(hql.toString());
		query.setParameter("estado", estado);
		return query.getResultList();
	}
	
	/**
	 * @see CategoriaDao#obtenerIdsCategorias(String, String)
	 */
	@Override
	public List<Long> obtenerIdsCategorias(String nombreCategoria, String estado) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT cat.idCategoria FROM CategoriaDTO cat ".
		    concat("WHERE cat.estado = :estado ").
		    concat("AND UPPER(TRIM(cat.nombreCategoria)) LIKE  UPPER(TRIM(:nombreCategoria)) "));

		Query query = em.createQuery(hql.toString());
		query.setParameter("estado", estado);
		query.setParameter("nombreCategoria", nombreCategoria);
		return query.getResultList();
	}

	/**
	 * @see CategoriaDao#actualizarCategoria(CategoriaDTO)
	 */
	@Override
	public void actualizarCategoria(CategoriaDTO categoria) {
		StringBuilder hql = new StringBuilder();
		hql.append("UPDATE CategoriaDTO cat SET cat.fechaModificacion = :fechaModificacion ");
		if (categoria.getEstado() != null) {
			hql.append(",cat.estado = :estado ");
		}
		if (categoria.getNombreCategoria() != null) {
			hql.append(",cat.nombreCategoria = :nombreCategoria ");
		}
		hql.append("WHERE cat.idCategoria = :idCategoria ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("fechaModificacion", categoria.getFechaModificacion());
		query.setParameter("idCategoria", categoria.getIdCategoria());
		if (categoria.getEstado() != null) {
			query.setParameter("estado", categoria.getEstado());
		}
		if (categoria.getNombreCategoria() != null) {
			query.setParameter("nombreCategoria", categoria.getNombreCategoria());
		}
		query.executeUpdate();
	}

}
