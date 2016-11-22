angular.module('microservices', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/lojas', {
			templateUrl : 'views/main.html',
			controller : 'MainCtrl'
		}).when('/lojas/:id/carros', {
			templateUrl : 'views/carros.html',
			controller : 'CarrosCtrl'
		}).otherwise({
			redirectTo : '/lojas'
		});
	});
