angular.module('microservices')
	.controller('LojasComCarrosCtrl', function($scope, $http, $routeParams) {
		$http({
			method : 'GET',
			url : '/lojas'
		}).then(function(response) {
			$scope.lojas = response.data;
		}, function(response) {
			console.error('Erro requisitando lojas com carros.')
		});
	});
