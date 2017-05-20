/**
 * Created by Hp on 5/6/2017.
 */

angular.module('kindergartenerApp.UserFactory', [])
    .factory('UserFactory', function($http){

        var factory = {};

        factory.getParents = function(institution){
            return $http.get('/parents/' + institution.id);
        };

        return factory;

    });
