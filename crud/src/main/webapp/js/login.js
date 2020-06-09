//app.js
(function() {
  var app = angular.module('crud', ['ui.router']);
  
   app.run(function($rootScope, $location, $state, LoginService) {
     console.clear();
     console.log('running');
    if(!LoginService.isAuthenticated()) {
        $state.transitionTo('login');
      }
  });
  
  app.config(['$stateProvider', '$urlRouterProvider', 
  function($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('login', {
        url : '/login',
        templateUrl : 'login.html',
        controller : 'LoginController'
      })
      .state('operador', {
        url : '/operador',
        templateUrl : 'operador.html',
        controller : 'operador-controller'
      });
      
       $urlRouterProvider.otherwise('/login');
  }]);

})();