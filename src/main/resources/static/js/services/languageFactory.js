/**
 * Created by Hp on 5/14/2017.
 */

angular.module('kidnergardenerApp.LanguageFactory', [])
    .factory('LanguageFactory', function($http){

        var factory = {};

        factory.getLanguages = function(){
            return $http.get('/languages');
        };

        return factory;

    });
