angular.module('homeModule')
  .component('home', {
    templateUrl: 'app/appModule/home/home.component.html',
    controller: function(){
      vm = this;
      vm.arr = ['hello', 'goodbye', 'where ar you going'];
      vm.intro = "this is home page";
      vm.format = 'M/d/yy h:mm:ss a';
      vm.obj = [
        {elem : 'h1', cont : 'this my header 1'},
        {elem : 'p', cont : 'this my paragraph'},
        {elem : 'h4', cont : 'this my header 3'}
      ];
    },
    controllerAs : 'vm'
  });

  