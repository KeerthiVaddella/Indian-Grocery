let app1 = angular.module("orderApp",[]);

	//Controller part
	app1.controller("placeOrders",['$scope','$rootScope',
	function($scope,$http){
		
		//Initializing data
		$scope.products=[];
		$scope.buyers=[];
		
		$rootScope.$emit("getBuyers",{});
		
	
	}]);