/**
 * Created by Hp on 5/6/2017.
 */

angular.module('kindergartenerApp.CategoryFactory', [])
    .factory('CategoryFactory', function($http){

        var factory = {};

        factory.findSuitable = function(category){
            return $http.post('/category', category);
        };

        factory.getDefault = function(){
            return $http.get('/defaultCategory');
        };

        return factory;

    });
