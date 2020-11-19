


'use strict';

	//Controller part
	angular.module('IGApp').controller("placeOrders",['$scope','buyerService','productService',
	function($scope,buyerService,productService){
		
		//Initializing data
		$scope.products=[];
		$scope.buyers=[];
		$scope.invoice=[];
		$scope.today = new Date();
		let dd = String($scope.today.getDate()).padStart(2, '0');
		let mm = String($scope.today.getMonth() + 1).padStart(2, '0'); //January is 0!
		let yyyy = $scope.today.getFullYear();

		$scope.today = yyyy + '-' + mm + '-' + dd;
		
		
		
		function getBuyers(){
			buyerService.getAllBuyers()
			.then(function(data){
				$scope.buyers=data;
				console.log($scope.buyers);
				},function(errRes){
				 console.log("Error while fetching buyers "+errRes);
				}
			);
			
		}
		getBuyers();
		
		function getProducts(){
			productService.getAllProducts()
			.then(function(data){
				$scope.products=data;
				},function(errRes){
					console.log("Error while fetching products "+errRes);
				}
			);
		}
		getProducts();
		
		$scope.addItem=function(product){
			
		
		}
		
		
		
		
		
	}]);