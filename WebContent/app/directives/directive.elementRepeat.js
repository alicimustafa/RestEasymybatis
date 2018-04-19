angular.module('appModule').directive('repeatElements', repeatElements);

function repeatElements() {
  var elemList = '';
	return {
		restric : 'E',
		link : link
		
	}
		function link(scope, element, attrs) {

			function buildElement(collection){
				for (let i = 0; i < collection.length; i++) {
					element.append(angular.element('<'+collection[i].elem+'>'+collection[i].cont+'</'+collection[i].elem+'>'));
				}
			}
			scope.$watchCollection(attrs.list, function(collection){
				
				buildElement(collection);
			});
			
		}
		
		
	
}