describe('movieController', function(){
    beforeEach(module('movieModule'));

    var movieController;
    var d;
    var movieService;
    var scope;

    beforeEach(inject(function($q, _movieService_){
        d = $q.defer();
        movieService = _movieService_;
        spyOn(myService, 'movieService').and.returnValue(d.promise);
    }));

    beforeEach(inject(function($controller, $rootScope){
        scope = $rootScope.$new();
        movieController = $controller('movieController', {
            movieService : movieService,
            scope : scope
        });
    }));

    
});