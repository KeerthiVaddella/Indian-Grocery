/**
 Buyer page controlling using angular
 */
 
 let app =angular.module("buyerOps",[]);
 
 		//OnClick buttons
 		app.controller("displayControl",function($scope){
 			$scope.newBuyer=false;
 			$scope.allBuyers=false;
 			$scope.allOrders=false;
 			
 			//displays Buyer Form
 			$scope.addNewBuyer=function(){
 				console.log("entered addNewBuyer");
 				$scope.newBuyer=true;
 				$scope.allBuyers=false;
 				$scope.allOrders=false;			
 			};
 			
 			//displays List of Buyers
 			$scope.showBuyers=function(){
 				$scope.allBuyers=true;
 				$scope.newBuyer=false;
 				$scope.allOrders=false;
 			}
 			
 			//displays Previous Orders of a Buyer
 			$scope.getPrevOrders=function(){
 				$scope.allOrders=true;
 				$scope.newBuyer=false;
 				$scope.allBuyers=false;
 			}
 		});