(function() {

  var directive = function() {

    var directiveMembers = {
      transclude: 'element',
      link: link
    }

    function link($scope, $element, $attr, controller, transclude) {
      var myLoop = $attr.myRepeat,
        match = myLoop.match(/^\s*(.+)\s+in\s+(.*?)\s*(\s+track\s+by\s+(.+)\s*)?$/),
        indexString = match[1],
        collectionString = match[2],
        parent = $element.parent(),
        elements = [];

      // $watchCollection is called everytime the collection is modified
      $scope.$watchCollection(collectionString, function(collection) {
        var i, block, childScope;
        console.log(collectionString);
        console.log(collection);
        // check if elements have already been rendered
        if (elements.length > 0) {
          console.log('elemments size =' +elements.length);
          // if so remove them from DOM, and destroy their scope
          for (i = 0; i < elements.length; i++) {
            elements[i].el.remove();
            elements[i].scope.$destroy();
          };
          elements = [];
        }

        for (i = 0; i < collection.length; i++) {
          // create a new scope for every element in the collection.
          childScope = $scope.$new();
          // pass the current element of the collection into that scope
          childScope[indexString] = collection[i];

          transclude(childScope, function(clone) {
            // clone the transcluded element, passing in the new scope.
            parent.append(clone); // add to DOM
            block = {};
            block.el = clone;
            block.scope = childScope;
            elements.push(block);
          });
        };
      });
    }
    
    return directiveMembers;
  }

  angular.module('appModule').directive('myRepeat', directive);
}());