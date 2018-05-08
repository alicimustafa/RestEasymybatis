(function(){
	'use strict'
	
	angular.module('appModule')
	.factory('pagingService', pagingService);
	
	pagingService.$inject = [];
	
	function pagingService(){
		
        var service = {
        		getPager : getPager
        };

        return service;

        function getPager(totalPages, currentPage) {
            currentPage = currentPage || 1;

            var startPage, endPage;
            if (totalPages <= 10) {
                startPage = 1;
                endPage = totalPages;
            } else {
                if (currentPage <= 6) {
                    startPage = 1;
                    endPage = 10;
                } else if (currentPage + 4 >= totalPages) {
                    startPage = totalPages - 9;
                    endPage = totalPages;
                } else {
                    startPage = currentPage - 5;
                    endPage = currentPage + 4;
                }
            }

            var startIndex = (currentPage - 1) * 20;
            var endIndex = totalPages;

            var pages = [];
            for(var i = startPage; i <= endPage; i++){
            	pages.push(i);
            }

            return {
                startPage: startPage,
                endPage: endPage,
                startIndex: startIndex,
                endIndex: endIndex,
                pages: pages
            };
        }

	}
})();