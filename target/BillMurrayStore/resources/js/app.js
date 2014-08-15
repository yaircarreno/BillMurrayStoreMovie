'use strict';

var BillMurrayStore = {};

var App = angular.module('BillMurrayStore', ['BillMurrayStore.filters', 'BillMurrayStore.services', 'BillMurrayStore.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    
    $routeProvider.when('/documentation', {
        templateUrl: 'documentation/layout',
        controller: DocumentController
    });
    
    $routeProvider.when('/movies', {
        templateUrl: 'movies/layout',
        controller: MovieController
    });

    $routeProvider.otherwise({redirectTo: '/movies'});
    
}]);
