tennisApp.controller('homeController', ['$scope', '$http', function (scope, $http) {
	
	const baseUrl = "http://localhost:8080/api";
	
	scope.saveNewPlayer = function(){
		$http.put(baseUrl + "/ranking", scope.newPlayerName)
	    .then(function(response) {
	    	scope.showNewPlayerForm = false;
	        scope.getPlayers();
	        scope.newPlayerName = ""
	    });
	}
	
	scope.getPlayers = function() {
		$http.get(baseUrl + "/ranking")
	    .then(function(response) {
	        scope.players = response.data;
	        if(scope.players != undefined) {
	        	scope.playerNames = scope.players.map( player => player.name)
	        }
	    });
	}
	
	scope.getMatches = function() {
		$http.get(baseUrl + "/matches")
		.then(function(response) {
			scope.matches = response.data;
		});
	}
	
	scope.saveResult = function() {
		console.log("saving result: " + scope.winner + scope.loser + scope.result)
		const data = {
			"winner" : scope.winner,
			"loser" : scope.loser,
			"result" : scope.result
		}
		$http.post(baseUrl + "/matches", data)
		.then(function(response) {
			scope.getMatches();
			scope.getPlayers();
			scope.winner = undefined;
			scope.loser  = undefined;
			scope.result = undefined;
		})
	}
	
	
	scope.getMatches();
	scope.getPlayers();
}]);	