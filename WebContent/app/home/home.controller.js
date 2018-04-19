(function(){
	
	'use stricy';
	
	angular.module('homeModule')
	.controller('homeController', homeController);
	
	homeController.$inject = [];
	
	function homeController(){
		var vm = this;
	}
})();