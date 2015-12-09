/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.servicio.factura;

import java.util.List;

import javax.ejb.Local;

import ec.com.facturacion.ligas.commons.exception.FacturacionExcepction;
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
	EquipoDTO obtenerEquipoPorId(Long idEquipo) throws FacturacionExcepction;
	
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
	EquipoDTO insertarEquipo(EquipoDTO equipo) throws FacturacionExcepction;

	/**
	 * <b> Inactiva un registro correspondiente a un equipo. </b>
	 * <p>
	 * [Author: inkarri, Date: 24/11/2015]
	 * </p>
	 *
	 * @param equipo
	 *            datos del equipo a inactivar
	 */
	void inactivarEquipo(EquipoDTO equipo) throws FacturacionExcepction;
	
	/**
	 * <b> Agrega una categoria a la base de datos. </b>
	 * <p>
	 * [Author: inkarri, Date: 23/11/2015]
	 * </p>
	 *
	 * @param categoria
	 * @return
	 */
	CategoriaDTO insertarCategoria(CategoriaDTO categoria) throws FacturacionExcepction;
	
	/**
	 * <b> Otiene las categorias filtadas por un estado. </b>
	 * <p>
	 * [Author: inkarri, Date: 1/12/2015]
	 * </p>
	 *
	 * @param estado
	 *            puede ser activo o inactivo
	 * @return categias registradas
	 * @throws FacturacionExcepction
	 *             excecion propagada en caso de existir un error
	 */
	List<CategoriaDTO> obtenerCategorias(String estado) throws FacturacionExcepction;
	
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
	 * @throws FacturacionExcepction
	 *             excecion propagada en caso de existir un error
	 */
	public List<Long> obtenerIdsCategorias(String nombreCategoria, String estado) throws FacturacionExcepction;
	
	/**
	 * <b> Actualiza datos de la categoria dependiendo de los datos que tenga el objeto que se le paa como parametro. </b>
	 * <p>
	 * [Author: inkarri, Date: 8/12/2015]
	 * </p>
	 *
	 * @param categoria
	 *            objeto que contiene los datos que seran actualizados
	 * @throws FacturacionExcepction
	 *             excecion propagada en caso de existir un error
	 */
	public void actualizarCategoria(CategoriaDTO categoria) throws FacturacionExcepction;
	
	/**
	 * <b> Registra o actualiza una categoria; si el nombre de la categoria ya existe pero esta inactiva unicamente sera activada; de no ser
	 * el caso se creara un registro en la base. </b>
	 * <p>
	 * [Author: inkarri, Date: 8/12/2015]
	 * </p>
	 *
	 * @param categoria
	 *            contiene los datos para crear o atualizar la categoria
	 * @return categoria registrada
	 * @throws FacturacionExcepction
	 *             excecion propagada en caso de existir un error
	 */
	public CategoriaDTO registrarActualizarCategoria(CategoriaDTO categoria) throws FacturacionExcepction;

}
