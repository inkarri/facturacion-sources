
angular
  .module('fcturacionLigasApp', [
    'ngAnimate',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ui.grid',
    'ui.bootstrap'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/categorias', {
        templateUrl: 'facturacion/view/categorias.html',
        controller: 'categoriaController'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

angular.module('fcturacionLigasApp').constant('$appConstants', appConstants());
function appConstants() {
    var constants = {
        URL: {
            INSERTAR_CATEGORIA: "http://localhost:8080/facturacion-ligas-ws/rx/facturacion/insertarCategoria",
            OBTENER_CATEGORIAS: "http://localhost:8080/facturacion-ligas-ws/rx/facturacion/obtenerCategorias",
            INACTIVAR_CATEGORIA: "http://localhost:8080/facturacion-ligas-ws/rx/facturacion/inactivarCategoria",
            REGISTRAR_CATEGORIA: "http://localhost:8080/facturacion-ligas-ws/rx/facturacion/registrarActualizarCategoria"
        },
        USUARIO : 'INKARRI',
        ESTADO: {
        	ACTIVO: "1",
        	INACTIVO: "0"
        }
    };
    return constants;
}
