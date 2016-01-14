angular.module('fcturacionLigasApp').controller('categoriaController', ctegoriaControlador);

ctegoriaControlador.$inject = [ '$scope', '$appConstants', 'CategoriaFactory', 'CategoriaService'];

function ctegoriaControlador($scope, $appConstants, CategoriaFactory, CategoriaService) {
	var vm = this;
	vm.nuevaCategoria = {};
	vm.categorias = CategoriaFactory.getCategorias();
	
	vm.alerts = [];
//	{ type: 'success', msg: 'Well done! You successfully read this important alert message.' }

	vm.registrarCategoria = function() {
		try {
			vm.closeAlert(0);
			if (!vm.nuevaCategoria.nombreCategoria) {
				throw "Ingrese un nombre de categoria.";
			}
			CategoriaService.validarExisteCategoria(vm.nuevaCategoria.nombreCategoria);
			vm.nuevaCategoria.estado = $appConstants.ESTADO.ACTIVO;
			vm.nuevaCategoria.usuarioRegistro = $appConstants.USUARIO;
			vm.nuevaCategoria.fechaCreacion = new Date();
			vm.nuevaCategoria.nombreCategoria = vm.nuevaCategoria.nombreCategoria.toUpperCase().trim();
			CategoriaFactory.registrarCategoria(vm.nuevaCategoria).then(function(result) {
				vm.nuevaCategoria = {};
				vm.categorias.push(result.data);
			}, function(err) {
				throw err.data
			});
		} catch (e) {
			vm.alerts.push({ type: 'danger', msg: e });
			console.log(e);
		}
	};
	
	var obtenerCategorias = function() {
		if (vm.categorias === null) {
			CategoriaFactory.obtenerCategorias($appConstants.ESTADO.ACTIVO).then(function(result) {
				vm.categorias = result.data;
				CategoriaFactory.setCategorias(vm.categorias);
				console.info(result.data);
			}, function(err) {
				throw err.data
			});
		}
	}();
	
	var elimianrCategoria = function(categoria, index) {
		try {
			categoria.estado = $appConstants.ESTADO.INACTIVO;
			CategoriaFactory.inactivarCategoria(categoria).then(function(result) {
				console.info("Correcto "+result);
				vm.categorias.splice(index, 1);
			}, function(err) {
				throw err.data
			});
		} catch (e) {
			console.log(e);
		}
	};
	
	vm.elimianrCategoria = elimianrCategoria;
	

	vm.closeAlert = function(index) {
		vm.alerts.splice(index, 1);
	};
	
};