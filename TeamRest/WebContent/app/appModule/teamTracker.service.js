angular.module('team')
.factory('teamService', function($http) {
  
	var service = {};
	

	  service.index = function() {
	    return $http({
	      method : 'GET',
	      url : "rest/teams/"
	    })
	  };
	  
	  service.show = function(id) {
		  console.log("in show")
		    return $http({
		      method : 'GET',
		      url : "rest/teams/"
		    })
		  }

		  service.create = function(team) {
		    return $http({
		      method : 'POST',
		      url : "rest/teams/",
		      headers : {
		        'Content-Type' : 'application/json'
		      },
		      data : team
		    })
		  };

		  service.update = function(id, team) {
			  console.log(id);
			  console.log(team);
		    return $http({
		      method : 'PUT',
		      url : "rest/teams/" + id,
		      headers : {
		        'Content-Type' : 'application/json'
		      },
		      data : team
		    })
		  };

		service.destroy = function(id) {
			console.log(id);
		   return $http({
		      method : 'DELETE',
		      url : "rest/teams/" + id
		    })
		  };

		  return service;
});