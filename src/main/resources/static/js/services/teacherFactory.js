/**
 * Created by Hp on 5/12/2017.
 */

angular.module('kidnergardenerApp.TeacherFactory', [])
    .factory('TeacherFactory', function($http){

        var factory = {};

        factory.getTeacher = function(user){
            return $http.get('/teacher/' + user.id);
        };

        return factory;

    });

