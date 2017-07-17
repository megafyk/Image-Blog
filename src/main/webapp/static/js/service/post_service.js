'use strict';

app.factory('PostService', ['$http', '$q', function ($http, $q) {
    var REST_SERVICE_API = 'http://localhost:8080/post';
    var factory = {
        fetchAllPosts: fetchAllPosts,
    };
    return factory;

    function fetchAllPosts() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_API)
            .then(
                function (response) {
                    console.log(response.data);
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Posts');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

}]);