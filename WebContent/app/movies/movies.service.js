(function(){

  'use strict'

  angular.module('movieModule')
  .factory('movieService', movieService);

  movieService.$inject = ['$http'];

  function movieService($http){
    var services = {

    };

    function getMoviesPage(page, filter){
      return $http({
        method : 'GET',
				url : `services/film/short/${filter}/${page}`
      });
    }
    return services;
  }
})();