angular.module('team')
  .component('teamList', {
    templateUrl: 'app/appModule/teamTracker.component.html',
 
  
    		controller: function(teamService){
	  
    		var vm = this;
    		
		vm.team = [];

		
		vm.reload = function(){
			  teamService.index()
			  .then(function(res){
				vm.todos = res.data;
			  });
		  }
		  
		vm.reload();
		
//		teamService.index()
//		.then(function(res){
//			
//			vm.team = res.data
//			
//		});
//		 
		vm.createTeam = function(team){
			console.log(team);
			teamService.create(team)
			.then(function(response){
				vm.reload();
			});
		} 
		
		vm.updateTeam = function(team){
			  console.log(team);
			 teamService.update(team.id, team)
			 .then(function(res){
				 vm.selected = res.data;
				 vm.team = null;
				 vm.reload();
			 });
		  }
		  
		  vm.deleteTeam = function(id){
			  teamService.destroy(id)
			  .then(function(res){
				  vm.reload();
			  });
		  }
		
		
			
  
  	},
  	 controllerAs : 'vm'
  });