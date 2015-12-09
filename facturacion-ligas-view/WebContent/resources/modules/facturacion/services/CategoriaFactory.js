
angular.module('fcturacionLigasApp').factory('CategoriaFactory', categoriaFabrica );

categoriaFabrica.$inject = [ '$http', '$resource', '$appConstants' ];

function categoriaFabrica($http, $resource, $appConstants) {
	
	var _categorias = null;
	
	var setCategorias = function(categorias) {
		_categorias = categorias;
	}
	
	var getCategorias = function() {
		return _categorias;
	}

	var registrarCategoria = function(categoria) {
		return $http.post($appConstants.URL.REGISTRAR_CATEGORIA, categoria);
	};
	
	var inactivarCategoria = function(categoria) {
		return $http.post($appConstants.URL.INACTIVAR_CATEGORIA, categoria);
	};
	
	var obtenerCategorias = function(estado) {
		var url = $appConstants.URL.OBTENER_CATEGORIAS;
		var config = {
	        params: {
	            'estado': estado
	       }
	    };
		return $http.get(url, config);
	};
	
	return {
		registrarCategoria: registrarCategoria,
		inactivarCategoria: inactivarCategoria,
		obtenerCategorias: obtenerCategorias,
		setCategorias: setCategorias,
		getCategorias: getCategorias
	};
};