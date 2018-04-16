angular.module('appModule')
.config(configure)

function configure($routeProvider){
  $routeProvider
    .when('/',{
      template: '<home></home>'
    })
}