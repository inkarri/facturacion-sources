/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao.impl;

import javax.ejb.Stateless;

import org.hibernate.Session;

import ec.com.facturacion.ligas.dao.CommonsDao;
import ec.com.facturacion.ligas.dao.EquipoDao;
import ec.com.facturacion.ligas.dto.EquipoDTO;

/**
 * <b> Implementacion del dao asociado a la tabla equipo. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
@Stateless
public class EquipoDaoImpl extends CommonsDao implements EquipoDao {

	/**
	 * @see EquipoDao#obtenerEquipoPorId(Long)
	 */
	@Override
	public EquipoDTO obtenerEquipoPorId(Long idEquipo) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT eq FROM EquipoDTO eq ");
		hql.append("WHERE  eq.idEquipo = :idEquipo ");

		Session session = (Session) em.getDelegate();
		session.clear();
		org.hibernate.Query query = session.createQuery(hql.toString());
		query.setParameter("idEquipo", idEquipo);

		return (EquipoDTO) query.uniqueResult();
	}

}
