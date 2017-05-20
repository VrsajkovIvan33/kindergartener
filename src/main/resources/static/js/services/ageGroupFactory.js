/**
 * Created by Hp on 5/6/2017.
 */

angular.module('kidnergardenerApp.AgeGroupFactory', [])
    .factory('AgeGroupFactory', function($http){

        var factory = {};

        factory.getAgeGroups = function(){
            return $http.get('/ageGroups');
        };

        return factory;

    });

