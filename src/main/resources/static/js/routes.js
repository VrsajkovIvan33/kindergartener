/**
 * Created by Hp on 4/29/2017.
 */

var app = angular.module('kindergartenerApp.routes', ['ngRoute']);

app.config(['$routeProvider','$httpProvider', function ($routeProvider, $httpProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'html/welcome.html'
        })
        .when('/admin', {
            templateUrl: 'html/admin.html'
        })
        .when('/teacher', {
            templateUrl: 'html/teacher.html'
        })
        .when('/accountant', {
            templateUrl: 'html/accountant.html'
        });
}]);