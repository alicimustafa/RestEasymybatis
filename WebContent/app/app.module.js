(function() {
	
	'use strict';
	
	angular.module('appModule', [ 
		'ngRoute', 
		'homeModule', 
		'navModule',
		'errModule', 
		'actorModule', 
		'movieModule' 
	]);
})();