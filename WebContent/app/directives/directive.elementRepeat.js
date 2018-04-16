angular.module('appModule').directive('repeatElements', repeatElements);

function repeatElements() {
  var elemList = '';
	return {
		restric : 'E',
		link : function(scope, element, attrs) {
			// console.log(scope);
			// console.log(element);
			// console.log(attrs.list);
			var arr = attrs.list;
      console.log(arr);
			for (let i = 0; i < arr.length; i++) {
        console.log('stuf' + arr[i].elem);
        element.append(angular.element('<'+arr[i].elem+'>'+arr[i].cont+'</'+arr[i].elem+'>'));
			}
			
			console.log(elemList);
    }
    
	}
}