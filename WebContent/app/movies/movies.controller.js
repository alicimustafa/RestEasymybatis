(function(){
	
	'use strict';
	
	angular.module('movieModule')
	.controller('movieController', movieController);
	
	movieController.$inject = ['$routeParams','movieService','pagingService'];
	
	function movieController($routeParams, movieService, pagingService){
		var vm = this;
		vm.movies = null;
		vm.movie = null;
		vm.col = "title";
		vm.dir = "asc";
		vm.currentPage = 1;
		vm.totalPages = 1;
		vm.pager = {};
		vm.setPage = setPage;
		vm.sortMovies = sortMovies;
		
		init();
		function init(){
			if($routeParams.id){
				vm.movies = null;
			} else {
				setPage(1);
			}
		}
		
		function loadMovies(){
			movieService.getMoviesPage(vm.currentPage, vm.col, vm.dir)
			.then(function(res){
				vm.movies = res.data.data.films;
				vm.totalPages = res.data.data.pages;
				vm.pager = pagingService.getPager(vm.totalPages, vm.currentPage);
			})
			.catch(function(err){
				console.log(err);
			});
		}
		
		function setPage(page) {
			if (page < 1 || page > vm.totalPages) {
				return;
	        }
			vm.currentPage = page;
			loadMovies();
	    }
		
		function sortMovies(col, dir){
			vm.col = col;
			vm.dir = dir;
			setPage(1);
		}
	}
})();