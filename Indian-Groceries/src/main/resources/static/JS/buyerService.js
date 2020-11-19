/**
 * 
 */
 
 'use strict';
 
app.factory('buyerService', ['$http', '$q', function($http, $q){
 
    
    var factory = {
        getAllBuyers: getAllBuyers,
        addNewBuyer: addNewBuyer,
        updateBuyer: updateBuyer,
        deleteBuyer: deleteBuyer,
        getBuyerById:getBuyerById
    };
 
    return factory;
 
    function getAllBuyers() {
        var deferred = $q.defer();
        $http({ 
                method:'GET',
                url:'buyer/allBuyers'
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
 
    function addNewBuyer(buyer) {
        var deferred = $q.defer();
        $http({
                  method : 'POST',
                  url : 'buyer/addBuyer',
                  data : angular.toJson(buyer),
                  headers : {
                     'Content-Type' : 'application/json'
                      }
                }).then(function(response){
            	
                console.log("Successfully Updated");
                deferred.resolve(response.data.response);
            	},function(errResponse) {
                deferred.reject(errResponse.data.response);
                console.log("Problem while adding buyer " +errResponse.data.response);
            
           } 
        );
        return deferred.promise;
    }
 
 
    function updateBuyer(buyer) {
        var deferred = $q.defer();
        $http({
                        method : 'PUT',
                        url : 'buyer/updateBuyer',
                        data : angular.toJson(buyer),
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
                console.log("Problem while Updating buyer " +errResponse.data.response);
            
           } 
        );
        return deferred.promise;
    }
 
    function deleteBuyer(buyer_id) {
        var deferred = $q.defer();
        let method='DELETE';
        let url= 'buyer/deleteBuyer/' + buyer_id;
                    $http({
                        method : method,
                        url : url
                    }).then(
            function(response){
            	
                console.log("Successfully Updated");
                deferred.resolve(response.data.response);
            	},function(errResponse) {
                deferred.reject(errResponse.data.response);
                console.log("Problem while deleting buyer " +errResponse.data.response);
            
           } 
        );
        return deferred.promise;
    }
	
	function getBuyerById(buyer_id){
	 var deferred = $q.defer();
        $http({ 
                method:'GET',
                url:'buyer/getBuyerName/'+buyer_id
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
}
]);