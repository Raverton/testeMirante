var app = angular.module('crud');

app.controller('pessoaController', ['$scope', '$http', function($scope, $http) {
    
	$scope.pessoa = {};
	
	listar();
	
	function listar(){
		
		$http.get("servicos/pessoa/")
	    .then(function(response) {
	        $scope.pessoas = response.data;
	    });
		
	}
	
	$scope.salvar = function(){
		
		if($scope.pessoa.id == undefined){
			
			$http.post("servicos/pessoa/", $scope.pessoa)
		    .then(function(response) {
		        console.log("cadastrado com sucesso");
		        listar();
		        $scope.pessoa = {};
		    });
		
		} else{
			
			$http.put("servicos/pessoa/", $scope.pessoa)
		    .then(function(response) {
		        console.log("cadastrado com sucesso");
		        listar();
		        $scope.pessoa = {};
		    });
			
		}
	}
	
	$scope.excluir = function(idpessoa){
		
		$http.delete("servicos/pessoa/" + idpessoa)
	    .then(function(response) {
	        console.log("excluido com sucesso");
	        listar();
	    });
		
	}
	
	$scope.limpar = function(idpessoa){
		
		$scope.pessoa = {};
		
	}
	
	$scope.alterar = function(pessoa){
		
		$scope.pessoa = pessoa;
		
	}
	
	$scope.values =[{"1": "Fisica" },{"2": "Juridica" }];

	
    
}]);