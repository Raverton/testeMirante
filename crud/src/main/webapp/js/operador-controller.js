var app = angular.module('crud');

app.controller('operadorController', ['$scope', '$http', function($scope, $http) {
    
	$scope.operador = {};
	
	listar();
	
	function listar(){
		
		$http.get("servicos/operador/")
	    .then(function(response) {
	        $scope.operadors = response.data;
	    });
		
	}
	
	$scope.salvar = function(){
		
		if($scope.operador.id == undefined){
			
			$http.post("servicos/operador/", $scope.operador)
		    .then(function(response) {
		        console.log("cadastrado com sucesso");
		        listar();
		        $scope.operador = {};
		    });
		
		} else{
			
			$http.put("servicos/operador/", $scope.operador)
		    .then(function(response) {
		        console.log("cadastrado com sucesso");
		        listar();
		        $scope.operador = {};
		    });
			
		}
	}
	
	$scope.excluir = function(idoperador){
		
		$http.delete("servicos/operador/" + idoperador)
	    .then(function(response) {
	        console.log("excluido com sucesso");
	        listar();
	    });
		
	}
	
	$scope.limpar = function(idoperador){
		
		$scope.operador = {};
		
	}
	
	$scope.alterar = function(operador){
		
		$scope.operador = operador;
		
	}
	
	$scope.values =[{"1": "ADMINISTRADOR" },{"2": "GERENTE" },{"3": "ANALISTA" }];

	
    
}]);