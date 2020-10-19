/**
 Buyer page controlling using angular
 */
 let app =angular.module("buyerOps",[]);
 
 		//OnClick buttons
 		app.service('getBuyers',function($scope){
 	return $scope.buyers;
}).controller("displayControl",['getBuyers',
 		function($scope,$http,getBuyers){
 			$scope.newBuyer=true;
 			$scope.allBuyers=false;
 			$scope.allOrders=false;
 			$scope.buyers=[];
 			$scope.invoice=[];
 			$scope.form={
 				buyer_id:-1,
 				buyer_name:"",
 				address:"",
 				gstin:""				
 			};
			$scope.message="";
 			$scope.showMessage=false;
 			$scope.buyer_name="";
 			
 			
 			 			
 			//displays Buyer Form
 			$scope.addNewBuyer=function(){
 				$scope.showMessage=false;
 				$scope.newBuyer=true;
 				$scope.allBuyers=false;
 				$scope.allOrders=false;	
 				_clearForm();		
 			};
 			
 			//displays List of Buyers
 			$scope.showBuyers=function(){
 				$scope.showMessage=false;
 				$scope.allBuyers=true;
 				$scope.newBuyer=false;
 				$scope.allOrders=false;
 				getAllBuyers();
 			}
 			
 			//displays Previous Orders of a Buyer
 			$scope.getPrevOrders=function(){
 				$scope.showMessage=false;
 				$scope.allOrders=true;
 				$scope.newBuyer=false;
 				$scope.allBuyers=false;
 			}
 			
 			//adds or update a buyer
 			$scope.addBuyer=function(){
 					var method = "";
                    var url = "";
                    if ($scope.form.buyer_id == -1) {
                        //Id is absent so add Product - POST operation
                        console.log($scope.form.buyer_name);
                        method = "POST";
                        url = 'buyer/addBuyer';
                        
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = 'buyer/updateBuyer';
                        console.log("Put method"+ url);
                    }
         
                    $http({
                        method : method,
                        url : url,
                        data : angular.toJson($scope.form),
                        headers : {
                            'Content-Type' : 'application/json'
                        }
                    }).then( _success, _error );
                };
                
                //HTTP DELETE- delete buyer by Id
                $scope.removeBuyer = function(buyer_id) {
                	
                	let method='DELETE';
                	let url= 'buyer/deleteBuyer/' + buyer_id
                    $http({
                        method : method,
                        url : url
                    }).then(_success, _error);
                };
 
                //In case of edit product, populate form with product data
                $scope.editBuyer = function(buyer) {
                	console.log("In Edit Buyer");
                	$scope.addNewBuyer();
                	$scope.form.buyer_id = buyer.buyer_id;
                    $scope.form.buyer_name = buyer.buyer_name;
                    $scope.form.address = buyer.address;
                    $scope.form.gstin = buyer.gstin;         
                };
                
               function getAllBuyers(){
                	$http({ 
                		method:'GET',
                		url:'buyer/allBuyers'
                		}).then(function successCallback(response) {
                        $scope.buyers = response.data;
                        console.log(response.data);
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
               		}
               		
               	$scope.getOrders=function(buyer_id){
               		$scope.form.buyer_id=buyer_id;
               		$scope.getAllOrders();
               	}
               		
               	$scope.getAllOrders=function(){
               		console.log($scope.form.buyer_id);
               		$scope.getPrevOrders();
               		$http({
               			method:'GET',
               			url:'buyer/getBuyerName/' + $scope.form.buyer_id
               			}).then(function successCallback(response) {
               				$scope.buyer =response.data;
               				console.log('name is ' + $scope.buyer.buyer_name);
               				/*$http({
               					method:'GET',
               					url:'invoice/getInvoiceByBuyer/'+$scope.form.buyer_id
               				}).then(function successCallback(response){
               				$scope.invoice=response.data;
               				},function errorCallback(response){
               					console.log(response.statusText);
               				});*/
               			},function errorCallback(response){
               			console.log(response.statusText);
               			});
               			
               	}           		
               		            		
                
                function _success() {
                	$scope.showMessage=true;
                	let params=response.message.split('?')[1].split('&');
                	$scope.message = decodeURIComponent(params[0].split('=')[1]);
                    _clearForm()
                }
         
                function _error(response) {
                	$scope.showMessage=true;
                	let params=response.message.split('?')[1].split('&');
                	$scope.message = decodeURIComponent(params[0].split('=')[1]);
                    _clearForm();
                }
                
                //Clear the form
                function _clearForm() {
                    $scope.form.buyer_id =-1;
                    $scope.form.buyer_name = "";
                    $scope.form.address = "";
                    $scope.form.gstin="";
                };
 		}]);
 		
