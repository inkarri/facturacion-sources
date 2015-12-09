/*
 * IntiSoft 2015  
 */
package ec.com.facturacion.ligas.commons.constantes;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * <b> Obtiene las constantes definidas en el archivo de propiedades. </b>
 * 
 * @author inkarri, Date: 8/12/2015
 */
public final class FacturacionResources {

	private FacturacionResources() {
	}

	private static final String NOMBRE_RECURSO = "ec.com.facturacion.ligas.commons.constantes.FacturacionResources";

	private static ResourceBundle RECURSO_BUNDLE = ResourceBundle.getBundle(NOMBRE_RECURSO);

	public static String getString(String key) throws MissingResourceException {
		return RECURSO_BUNDLE.getString(key);
	}

	public static Integer getInteger(String key) throws MissingResourceException {
		return Integer.valueOf(RECURSO_BUNDLE.getString(key));
	}

	public static Long getLong(String key) throws MissingResourceException {
		return Long.valueOf(RECURSO_BUNDLE.getString(key));
	}

	public static String getString(final String key, final String... parameters) {
		try {
			final MessageFormat formatter = new MessageFormat(RECURSO_BUNDLE.getString(key));
			return formatter.format(parameters);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}

}
