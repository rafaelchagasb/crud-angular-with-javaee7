var app = angular.module('crud');

app.controller('clienteController', ['$scope', '$http', function($scope, $http) {
    
	$scope.cliente = {};
	
	listar();
	
	function listar(){
		
		$http.get("servicos/cliente/")
	    .then(function(response) {
	        $scope.clientes = response.data;
	    });
		
	}
	
	$scope.salvar = function(){
		
		if($scope.cliente.id == undefined){
			
			$http.post("servicos/cliente/", $scope.cliente)
		    .then(function(response) {
		        console.log("cadastrado com sucesso");
		        listar();
		        $scope.cliente = {};
		    });
		
		} else{
			
			$http.put("servicos/cliente/", $scope.cliente)
		    .then(function(response) {
		        console.log("cadastrado com sucesso");
		        listar();
		        $scope.cliente = {};
		    });
			
		}
	}
	
	$scope.excluir = function(idCliente){
		
		$http.delete("servicos/cliente/" + idCliente)
	    .then(function(response) {
	        console.log("excluido com sucesso");
	        listar();
	    });
		
	}
	
	$scope.limpar = function(idCliente){
		
		$scope.cliente = {};
		
	}
	
	$scope.alterar = function(cliente){
		
		$scope.cliente = cliente;
		
	}
    
}]);