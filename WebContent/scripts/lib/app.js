(function(){
	'use strict';
	angular.module('data',['ngMessages']);
	angular.module('data').controller("mainCtrl",mainController);
	mainController.$inject=['$http'];
	function mainController($http){
		
		alert("main controller");
		
		var mc=this;
		mc.tryLogin=function(){
			$http({
				method:'POST',
				url:'api/Reservation/login', 	
				data:mc.auth
			})
		}
		mc.addReservation=function(){
			
		 alert(" In add Reservation "+mc.newR.ReservationDate);
			
			$http({
				
				method:'POST',
				url:'api/Reservation/add',
				data:mc.newR
			}).success(function(data){
				console.log(data);
			}).error(function(error){
				console.log(error);
			});
		}
	}
})();