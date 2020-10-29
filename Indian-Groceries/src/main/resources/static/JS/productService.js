'use strict';
 
angular.module('IGApp').factory('productService', ['$http', '$q', function($http, $q){
 
    
    var factory = {
        getAllProducts: getAllProducts,
        addNewProduct: addNewProduct,
        updateProduct: updateProduct,
        deleteProduct: deleteProduct,
        getProductById:getProductById
    };
 
    return factory;
    
     function getAllProducts() {
        var deferred = $q.defer();
        $http({ 
                method:'GET',
                url:'product/allProducts'
            }).then(function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        console.log(deferred.promise);
        return deferred.promise;
    }
    
  function addNewProduct(product) {
        var deferred = $q.defer();
        $http({
                  method : 'POST',
                  url : 'product/addProduct',
                  data : angular.toJson(product),
                  headers : {
                     'Content-Type' : 'application/json'
                      }
                }).then(function(response){
            	
                console.log("Successfully Updated");
                deferred.resolve(response.data.response);
            	},function(errResponse) {
                deferred.reject(errResponse.data.response);
                console.log("Problem while adding Product " +errResponse.data.response);
            
           } 
        );
        return deferred.promise;
    }
 
 
    function updateProduct(product) {
        var deferred = $q.defer();
        $http({
                        method : 'PUT',
                        url : 'product/updateProduct/'+product.product_id,
                        data : angular.toJson(product),
                        headers : {
                            'Content-Type' : 'application/json',                           
                        },
                        responseType :'text'
                    })
            .then(function(response){
            	
                console.log("Successfully Updated");
                deferred.resolve(response.data.response);
            	},function(errResponse) {
                deferred.reject(errResponse.data.response);
                console.log("Problem while Updating Product " +errResponse.data.response);
            
           } 
        );
        return deferred.promise;
    }
 
    function deleteProduct(product_id) {
        var deferred = $q.defer();
        let method='DELETE';
        let url= 'product/deleteProduct/' + product_id;
                    $http({
                        method : method,
                        url : url
                    }).then(
            function(response){
            	
                console.log("Successfully Updated");
                deferred.resolve(response.data.response);
            	},function(errResponse) {
                deferred.reject(errResponse.data.response);
                console.log("Problem while deleting Product " +errResponse.data.response);
            
           } 
        );
        return deferred.promise;
    }
	
	function getProductById(product_id){
	 var deferred = $q.defer();
        $http({ 
                method:'GET',
                url:'product/getProductName/'+product_id
            }).then(function (response) {
            	console.log(response.data);
                deferred.resolve(response.data);
                
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        console.log(deferred.promise);
        return deferred.promise;
    }
 
 }]);