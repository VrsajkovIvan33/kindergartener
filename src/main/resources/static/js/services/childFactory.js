/**
 * Created by Hp on 5/6/2017.
 */

angular.module('kindergartenerApp.ChildFactory', [])
    .factory('ChildFactory', function($http){

        var factory = {};

        factory.getChildrenByInstitution = function(user){
            return $http.get('/childrenByInstitution/' + user.institution.id);
        };

        factory.getChildrenByGroup = function(group){
            return $http.get('/childrenByGroup/' + group.id);
        };

        factory.addChild = function(child){
            return $http.post('/child', child);
        };

        factory.updateChild = function(child){
            return $http.put('/child', child);
        };

        factory.removeChild = function(child){
            return $http.delete('/child/' + child.id);
        };

        return factory;

    });
