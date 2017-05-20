/**
 * Created by Hp on 5/17/2017.
 */

angular.module('kidnergardenerApp.DebitFactory', [])
    .factory('DebitFactory', function ($http){

        var factory = {};

        factory.calculateDebit = function (child, year){
            return $http.get('/debit/' + child.id + '/' + year);
        };

        return factory;

    });
