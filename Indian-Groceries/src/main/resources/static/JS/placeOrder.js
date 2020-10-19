'use strict';

	//Controller part
	angular.module('IGApp').controller("placeOrders",['$scope','buyerService',
	function($scope,buyerService){
		
		//Initializing data
		$scope.products=[];
		$scope.buyers=[];
		
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
		
	
	}]);