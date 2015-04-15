/**
 * 
 */
ngApp.controller('PhoneListCtrl', function($scope) {

	$scope.phones = [ {
		"name" : "Nexus S",
		"snippet" : "Fast just got faster with Nexus S."
	}, {
		"name" : "Motorola XOOM™ with Wi-Fi",
		"snippet" : "The Next, Next Generation tablet."
	}, {
		"name" : "MOTOROLA XOOM™",
		"snippet" : "The Next, Next Generation tablet."
	} ];
	$scope.username="ljinshuan-user";
});

ngApp.controller("personInfo",function($scope,$http){
	$http.get("/person/23").success(function(data) {
		$scope.person=data;
	});
	$scope.doSomething=function(){
		console.log("do something");
	};
});

ngApp.controller("userController",function($scope,userService){
	$scope.user=userService.get("ljinshuan");
});
