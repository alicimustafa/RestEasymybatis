(function(){
	
	'use strict';
	
	angular.module('movieModule')
	.controller('movieController', movieController);
	
	movieController.$inject = ['$routeParams','movieService'];
	
	function movieController($routeParams){
		var vm = this;
		vm.movies = [];
		vm.movie = null;
		
		console.log($routeParams.id);
		refresh();
		function refresh(){
			if($routeParams.id){
				
			} else {
				
			}
		}
	}
})();