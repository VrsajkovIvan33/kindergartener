/**
 * Created by Hp on 4/30/2017.
 */

angular.module('kindergartenerApp.LoginFactory', [])
    .factory('LoginFactory', function($http){

        var factory = {};

        factory.login = function(user){
            return $http.post('/login', user);
        };

        return factory;

    });
