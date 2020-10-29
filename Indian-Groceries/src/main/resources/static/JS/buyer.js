/**
 Buyer page controlling using angular
 */

 //OnClick buttons
 		app.controller("displayControl",['$scope','buyerService',
 		function($scope,buyerService){
 			$scope.newBuyer=true;
 			$scope.allBuyers=false;
 			$scope.allOrders=false;
 			$scope.buyers=[];
 			$scope.invoice=[];
 			$scope.form={
 				buyer_id:-1,
 				buyer_name:"",
 				address:"",
 				country:"",
 				state:"",
 				city:"",
 				gstin:""				
 			};
			$scope.message="";
 			$scope.showMessage=false;
 			$scope.buyer_name="";
 			$scope.buyer={
 			buyer_id:0,
 			buyer_name:"",
 			address:"",
 			gstin:""
 			};
 			
 		$scope.locations={
 			'Andhra Pradesh' : ['Adoni','Amaravati','Anantapur','Bapatla','Bhimavaram','Chilakaluripet',
 								'Chirala','Chittoor','Dharmavaram','Eluru','Gudivada','Guntur','Hindupur',
 								'Kadapa','Kakinada','Kurnool','Machilipatnam','Madanapalle','Mangalagiri',
 								'Nandyal','Narasaraopet','Ongole','Proddatur','Rajamahendravaram'],
				
			'Tamil Nadu':['Chennai','Kanyakumari','Coimbatore','Madurai','Vellore','Ooty','Kanchipuram'],
			'Kerala':['Kochi','Yernakulam','Thiruvananthapuram','Alappuzha','Kottayam','Munnar']
				};
 			 			
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
 					console.log($scope.form.city.value);
 					$scope.buyer.buyer_id=$scope.form.buyer_id;
 					$scope.buyer.buyer_name=$scope.form.buyer_name;
 					$scope.buyer.address=$scope.form.address+", "+$scope.form.city+", "+$scope.form.state;
 					$scope.buyer.gstin=$scope.form.gstin;
 			           if ($scope.form.buyer_id == -1) {
                        //Id is absent so add Product - POST operation
                        buyerService.addNewBuyer($scope.buyer).then(_success(response),_error(response));
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                       buyerService.updateBuyer($scope.buyer)
                       .then(function(res){
                        	_success(res);
                       },
                       function(errRes){
                       		_error(errRes);
                       });
                    }
         		};
                   
                
                //HTTP DELETE- delete buyer by Id
                $scope.removeBuyer = function(buyer_id) {
                	
                	buyerService.deleteBuyer(buyer_id).then(function(res){
                        	_success(res);
                        	$scope.showBuyers();
                       },
                       function(errRes){
                       		_error(errRes);
                       });
                };
 
                //In case of edit product, populate form with product data
                $scope.editBuyer = function(buyer) {
                	let address=buyer.address.split(', ');
                	
                	console.log("In Edit Buyer"+ address);
                	$scope.addNewBuyer();
                	$scope.form.buyer_id = buyer.buyer_id;
                    $scope.form.buyer_name = buyer.buyer_name;
                    $scope.form.address = address[0];
                    $scope.form.gstin = buyer.gstin;         
                };
                
               function getAllBuyers(){
                	buyerService.getAllBuyers()
			.then(function(data){
				$scope.buyers=data;
				console.log($scope.buyers);
				},function(errRes){
				 console.log("Error while fetching buyers "+errRes);
				}
			);
               		}
               		
               	$scope.getOrders=function(buyer_id){
               		$scope.form.buyer_id=buyer_id;
               		$scope.getAllOrders();
               	}
               		
               	$scope.getAllOrders=function(){
               		console.log($scope.form.buyer_id);
               		$scope.getPrevOrders();
               		buyerService.getBuyerById($scope.form.buyer_id)
               			.then(function successCallback(response) {
               				console.log(response +" in buyer.js");
               				$scope.buyer =response;
               				console.log($scope.buyer);
               				console.log('name is ' + $scope.buyer.buyer_name);
               				
               			},function errorCallback(response){
               			console.log(response.statusText);
               			});
               			
               	}           		
               		            		
                
                function _success(response) {
                	$scope.showMessage=true;
                	
                	$scope.message = response;
                	$scope.message= $scope.message.charAt(0).toUpperCase()+$scope.message.slice(1);
                	console.log($scope.message);
                    _clearForm();
                    
                }
         
                function _error(response) {
                	$scope.showMessage=true;
                	$scope.message = response;
                	$scope.message= $scope.message.charAt(0).toUpperCase()+$scope.message.slice(1)
                    _clearForm();
                }
                
                //Clear the form
                function _clearForm() {
                    $scope.form.buyer_id =-1;
                    $scope.form.buyer_name = "";
                    $scope.form.address = "";
                    $scope.form.gstin="";
                    $scope.form.state="";
                    $scope.form.city="";
                };
 		}]);
 		
