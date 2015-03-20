var loginApp = angular.module('loginApp', [ 'ui.router' ]);


loginApp.controller('LoginController', [ '$scope','$http','$state','SystemService', function($scope,$http,$state,SystemService) {
$scope.init = function() {
$scope.appData.loginForm = {};
}
$scope.login = function() {
var data = {loginId : $scope.appData.loginForm.loginId, password : $scope.appData.loginForm.password};
var callback = function(response){
$scope.appData.res = response;
if (!response.redirected) {
$scope.appData.loginForm.password='';
$state.go('account');
}else {
alert('invalid td/pass');//TODO update to better code
$scope.init();
}
};
var req = {url:'/restWeb/login/login', data:data,http:$http,state:$state, callback:callback};
SystemService.httpPost(req);
} 
} ]);
