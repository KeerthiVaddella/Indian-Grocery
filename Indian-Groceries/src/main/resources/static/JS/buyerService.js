/**
 * 
 */
 
 'use strict';
 
angular.module('IGApp').factory('buyerService', ['$http', '$q', function($http, $q){
 
    
    var factory = {
        getAllBuyers: getAllBuyers,
        addNewBuyer: addNewBuyer,
        updateBuyer: updateBuyer,
        deleteBuyer: deleteBuyer
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
                }).then(function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
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
                            'Content-Type' : 'application/json'
                        }
                    })
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
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
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);