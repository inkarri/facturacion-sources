
angular.module('fcturacionLigasApp').service('CategoriaService',
		[ '$appConstants', 'CategoriaFactory', categoriaServicio ]);

function categoriaServicio($appConstants, CategoriaFactory) {
	
    var validarExisteCategoria = function(nombreCategoria) {
    	var categorias = CategoriaFactory.getCategorias();
//    	if (categorias) {
        	var nombreCategoriaRegistrada;
        	nombreCategoria = nombreCategoria.toUpperCase().trim();
    		for (var i = 0; i < categorias.length; i++) {
    			nombreCategoriaRegistrada = categorias[i].nombreCategoria.toUpperCase().trim();
    			if (nombreCategoriaRegistrada === nombreCategoria) {
    				throw "La categoria ".concat(nombreCategoria).concat(" ya esta registrada.");
    			}
    		}
//    	}
	};
	
    this.validarExisteCategoria = validarExisteCategoria;
    
};