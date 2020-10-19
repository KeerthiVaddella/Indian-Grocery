

let app1 = angular.module("orderApp",[]);

	//Controller part
	app1.controller("placeOrders",
	function($scope,$http,getBuyers){
		
		//Initializing data
		$scope.products=[];
		$scope.buyers=getBuyers;
	
	});