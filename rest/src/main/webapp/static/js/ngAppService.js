/**
 * 
 */
var ngApp=angular.module('ngApp', []);

//注册服务

ngApp.factory("userService",function(){
	var userService={};
	userService.get=function(username){
		return {"username":username,"pwd":"ljsljsljs"};
	},
	userService.id=110;
	return userService;
});
