(function(){
	
	'use strict';
	
	angular.module('movieModule')
	.controller('movieController', movieController);
	
	movieController.$inject = ['$routeParams'];
	
	function movieController($routeParams){
		var vm = this;
		var movies = [];
		var movie = null;
		
	}
})();