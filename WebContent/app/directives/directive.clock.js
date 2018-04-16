angular.module('appModule')
.directive('myClock', ['$interval','dateFilter',myClock]);

function myClock($interval,dateFilter){


  function link(scope, element, attrs){
    var format, timeoutId;

    function updateTime(){
      element.text(dateFilter(new Date(), format));
    }

    scope.$watch(attrs.myClock, function(value){
      format = value;
      console.log('sfurr'+format);
      updateTime();
    })

    element.on('$destroy', function(){
      $interval.cancel(timeoutId);
    })

    timeoutId = $interval(function(){
      updateTime();
    },1000);
  }
  return {
    link: link
  }
}