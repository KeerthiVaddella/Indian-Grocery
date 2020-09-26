var app = angular.module("ProductManagement", []);
         
            //Controller Part
            app.controller("ProductManagementController", function($scope, $http) {
         
                //Initialize page with default data which is blank in this example
                $scope.products = [];
                $scope.form = {
                    id : -1,
                    description : "",
                    price : "",
                };
         
                //Now load the data from server
                _refreshPageData();
         
                //HTTP POST/PUT methods for add/edit Product
                $scope.submitProduct = function() {
         			console.log("entered submit function");
                    var method = "";
                    var url = "";
                    if ($scope.form.id == -1) {
                        //Id is absent so add Product - POST operation
                        console.log("It came to angular post");
                        method = "POST";
                        url = 'product/addProduct';
                        
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        method = "PUT";
                        url = 'product/updatePrice/' + $scope.form.id;
                        console.log("Put method");
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
         
                //HTTP DELETE- delete product by Id
                $scope.removeProduct = function(product_id) {
                	console.log("entered delete angular"+product_id);
                	let method='DELETE';
                	let url= 'product/deleteProduct/' + product_id
                    $http({
                        method : method,
                        url : url
                    }).then(_success, _error);
                };
 
                //In case of edit product, populate form with product data
                $scope.editProduct = function(product) {
                	$scope.form.id = product.product_id;
                    $scope.form.description = product.description;
                    $scope.form.price = product.price;
                    
                };
         
                /* Private Methods */
                //HTTP GET- get all products collection
                function _refreshPageData() {
                console.log("entered get");
                    $http({
                        method : 'GET',
                        url : 'product/allProducts'
                    }).then(function successCallback(response) {
                        $scope.products = response.data;
                        console.log(response.data);
                    }, function errorCallback(response) {
                        console.log(response.statusText);
                    });
                }
         
                function _success(response) {
                    _refreshPageData();
                    _clearForm()
                }
         
                function _error(response) {
                    console.log(response.statusText);
                }
         
                //Clear the form
                function _clearForm() {
                    $scope.form.description = "";
                    $scope.form.price = "";
                    $scope.form.id = -1;
                };
            });