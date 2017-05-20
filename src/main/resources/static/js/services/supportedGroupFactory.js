/**
 * Created by Hp on 5/6/2017.
 */

angular.module('kidnergardenerApp.SupportedGroupFactory', [])
    .factory('SupportedGroupFactory', function($http){

        var factory = {};

        factory.getSuitableSupportedGroups = function(ageGroup, language, institution){
            return $http.get('/supportedGroups/' + ageGroup.id + '/' + language.id + '/' + institution.id);
        };

        return factory;

    });

