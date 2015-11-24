/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * <b> Dao comun que contiene el manejador para el motor de eristencias. </b>
 * 
 * @author inkarri, Date: 23/11/2015
 */
public class CommonsDao {

	@PersistenceContext
	protected EntityManager em;

}
