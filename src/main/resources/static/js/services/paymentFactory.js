/**
 * Created by Hp on 5/17/2017.
 */

angular.module('kidnergardenerApp.PaymentFactory', [])
    .factory('PaymentFactory', function($http){

        var factory = {};

        factory.getPaymentsByChild = function(child, month, year){
            return $http.get('/paymentsByChild/' + child.id + '/' + month + '/' + year);
        };

        factory.getPaymentsByInstitution = function(institution, month, year){
            return $http.get('/paymentsByInstitution/' + institution.id + '/' + month + '/' + year);
        };

        factory.addPayment = function (payment){
            return $http.post('/payment', payment);
        };

        factory.updatePayment = function (payment){
            return $http.put('/payment', payment);
        };

        factory.removePayment = function (payment){
            return $http.delete('/payment/' + payment.id);
        };

        return factory;

    });

