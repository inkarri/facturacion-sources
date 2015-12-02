/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao.impl;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.Query;

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

	/**
	 * @see EquipoDao#insertarEquipo(EquipoDTO)
	 */
	@Override
	public EquipoDTO insertarEquipo(EquipoDTO equipo) {
		em.persist(equipo);
		return equipo;
	}

	/**
	 * @see EquipoDao#inactivarEquipo(EquipoDTO)
	 */
	@Override
	public void inactivarEquipo(EquipoDTO equipo) {
		StringBuilder hql = new StringBuilder();
		hql.append("UPDATE EquipoDTO eq ");
		hql.append("SET eq.estado = :estado, eq.fechaModificacion = :fechaModificacion, ");
		hql.append("eq.usuarioRegistro = :usuarioRegistro ");
		hql.append("WHERE eq.id = :idEquipo ");

		Query query = em.createQuery(hql.toString());
		query.setParameter("estado", equipo.getEstado());
		query.setParameter("fechaModificacion", Calendar.getInstance());
		query.setParameter("usuarioRegistro", equipo.getUsuarioRegistro());
		query.executeUpdate();
	}

}
