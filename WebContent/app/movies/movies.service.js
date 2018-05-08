(function(){

  'use strict'

  angular.module('movieModule')
  .factory('movieService', movieService);

  movieService.$inject = ['$http'];

  function movieService($http){
    var services = {
    		getMoviesPage: getMoviesPage
    };

    function getMoviesPage(page, order, dir){
    	console.log(order+" "+dir+" "+page);
      return $http({
        method : 'GET',
				url : `services/film/short/${order}/${dir}/${page}`
      });
    }
    return services;
  }
})();