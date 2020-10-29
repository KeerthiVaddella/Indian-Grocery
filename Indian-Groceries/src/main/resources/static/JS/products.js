
         
            //Controller Part
            app.controller("ProductManagementController",['$scope','productService',
 		function($scope,productService){
                //Initialize page with default data
                $scope.products = [];
                
                $scope.form = {
                    id : -1,
                    description : "",
                    price : "",
                };
         
         
                //Now load the data from server
                _refreshPageData();
         
         
                //method for add/edit Product
                $scope.submitProduct = function() {
         			
                    if ($scope.form.id == -1) {
                        //new product
                        productService.addNewProduct($scope.form).then(_success,_error);
                        
                    } else {
                        //If Id is present, it's edit operation - PUT operation
                        productService.updateProduct($scope.form).then( _success, _error );
                        }
                };
                
         
                //delete product by Id
                $scope.removeProduct = function(product_id) {
                	console.log("entered delete angular"+product_id);
                	productService.deleteProduct(product_id)
                    .then(_success, _error);
                };
 
 
                //In case of edit product, populate form with product data
                $scope.editProduct = function(product) {
                	$scope.form.id = product.product_id;
                    $scope.form.description = product.description;
                    $scope.form.price = product.price;
                    
                };
         
         
                
                //get all products collection
                function _refreshPageData() {
                console.log("entered get");
                   productService.getAllProducts().then(function successCallback(response) {
                        $scope.products = response;
                        console.log(response);
                    }, function errorCallback(response) {
                        console.log("Error while fetching products "+response);
                    });
                }
         
         
                function _success() {
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
                
            }
           ]);