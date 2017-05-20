/**
 * Created by Hp on 4/29/2017.
 */

var app = angular.module('kindergartenerApp', [
    'kindergartenerApp.routes',
    'kindergartenerApp.controllers',
    'kindergartenerApp.services',
    'ngMaterial',
    'ngStorage',
    'ui.calendar']);

app.config(function($mdThemingProvider) {
    $mdThemingProvider.theme('default')
        .primaryPalette('purple')
        .accentPalette('yellow');
});