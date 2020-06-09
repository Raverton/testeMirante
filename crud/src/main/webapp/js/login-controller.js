
 var app = angular.module('crud');

 app.controller('LoginController', ['$scope', '$http', function($scope, $http) {
     
	    $scope.formSubmit = function() {
	        if(LoginService.login($scope.username, $scope.password)) {
	          $rootScope.userName = $scope.username;
	          $scope.error = '';
	          $scope.username = '';
	          $scope.password = '';
	          $state.transitionTo('home');
	        } else {
	          $scope.error = "Incorrect username/password !";
	        }   
	      };  
	      
	      app.factory('LoginService', function() {
	    	    var admin = 'admin';
	    	    var pass = 'password';
	    	    var isAuthenticated = false;
	    	    
	    	    return {
	    	      login : function(username, password) {
	    	        isAuthenticated = username === admin && password === pass;
	    	        return isAuthenticated;
	    	      },
	    	      isAuthenticated : function() {
	    	        return isAuthenticated;
	    	      }
	    	    };
	    	    
	    	  });
	      
 	
     
 }]);
 
 