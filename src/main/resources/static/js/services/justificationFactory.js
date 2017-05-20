/**
 * Created by Hp on 5/13/2017.
 */

angular.module('kidnergardenerApp.JustificationFactory', [])
    .factory('JustificationFactory', function($http){

        var factory = {};

        factory.addJustification = function (attendances){
            return $http.post('/justification', attendances);
        };

        factory.removeJustification = function (attendances){
            return $http.put('/justification', attendances);
        };

        return factory;

    });
