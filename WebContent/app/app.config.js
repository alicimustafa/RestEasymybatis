(function(){
	
	'use strict';
	
	angular.module('appModule').config(configure)
	
	function configure($routeProvider) {
		$routeProvider.when('/', {
			templateUrl : 'app/home/home.template.html',
			controller : 'homeController',
			controllerAs : 'vm'
		}).when('/movies', {
			templateUrl : 'app/movies/movies.template.html',
			controller : 'movieController',
			controllerAs : 'vm'
		}).when('/movies/:id', {
			templateUrl : 'app/movies/movies.template.html',
			controller : 'movieController',
			controllerAs : 'vm'
		}).when('/actors', {
			templateUrl : 'app/actors/actors.template.html',
			controller : 'actorController',
			controllerAs : 'vm'
		}).when('/actors/:id', {
			templateUrl : 'app/actors/actors.template.html',
			controller : 'actorController',
			controllerAs : 'vm'
		}).otherwise({
			templateUrl : 'app/error/error.template.html',
			controller : 'errorController',
			controllerAs : 'vm'
		});
	}
})();