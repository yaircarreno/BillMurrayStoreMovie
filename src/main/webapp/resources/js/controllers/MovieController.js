'use strict';

/**
 * MovieController
 */

var MovieController = function($scope, $http, $timeout) {
	
	$scope.fetchMovieList = function(name) {
        $http.get('movies/cast').success(function(){ 	
            $scope.actorname = name;
        });
    };
    
    $scope.searchPerson = function(name) {
    	
    	$scope.resetError();
    	$scope.loading = true;
    	$scope.actor = null;
    	
        $http.get('movies/search/'+ name).success(function(actorlist){
        	
            $scope.actorname = name;
            $scope.actorlist = actorlist;
            $scope.actor = actorlist[0];
           
            if (typeof actorlist !== 'undefined' && actorlist.length > 0){
            	$scope.validateImages(actorlist[0]);
            	$scope.movies = actorlist[0].movies;
            } else {
            	$scope.setError('Im sorry, could not get data about this name!');
            }
            $scope.loading = false;
        }).error(function() {
            $scope.setError('Im sorry, could not get data about this name!');
        });
    };
    
	$scope.rechargeActor = function(actor) {
	    	
	    	$scope.resetError();
	    	$scope.loading = true;
	    	$scope.actor = actor;
	    	$scope.validateImages(actor);
	    	$scope.movies = actor.movies;
	    	$scope.loading = false;
	    	
	    };
    
    $scope.numberOfPages=function(){
        return Math.ceil($scope.movies.length/$scope.pageSize);                
    };
    
    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
        $scope.cleanContext();
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
        $scope.cleanContext();
    };
    
    $scope.closeAlert = function() {
    	$scope.resetError();
    };
    
    $scope.cleanContext = function() {
    	$scope.actor = null;
        $scope.actorname = null;
        $scope.loading = false;
        $scope.currentPage = 0;
        $scope.pageSize = 2;
    };
    

	$scope.validateImages = function(actor) {
		
		var movies = actor.movies;
		var path_actor = actor.profile_path;
		var pathImageServer = 'http://image.tmdb.org/t/p/w154';
		var pathImageLocal = './resources/images/imagenotavailable.png';
        var i;
        
        
        if (path_actor == null || path_actor === undefined){
        	actor.profile_path = pathImageLocal;
        } else {
        	actor.profile_path = pathImageServer + path_actor;
        }
        
		for ( i = 0; i < movies.length; i++) {
			var path = movies[i].poster_path;
			if (path == null || path === undefined ) {
				
				movies[i].poster_path = pathImageLocal;
			} else {
				movies[i].poster_path = pathImageServer + path;
			}
		}
		actor.movies = movies;
		$scope.actor = actor;
	};
	
	$scope.movies = [];
    $scope.loading = false;
    $scope.currentPage = 0;
    $scope.pageSize = 2;
    
};