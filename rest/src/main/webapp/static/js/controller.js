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



ngApp.controller("userController",function($scope,userService){
	$scope.user=userService.get("ljinshuan");
});

ngApp.controller("PersonListController",function($scope,Person){
	$scope.persons=Person.query();
	$scope.show=function(pid){
		$scope.person=Person.get({pid:pid});
	}
	$scope.edit=function(pid){
		Person.save({pid:pid},$scope.person);
	}
	$scope.remove=function(pid){
		$scope.person.$remove();
	}
	$scope.insert=function(){
		$scope.person=new Person();
		$scope.person.name="ljinshuan";
		$scope.person.age=11;
		$scope.person.$save();
	}
});

