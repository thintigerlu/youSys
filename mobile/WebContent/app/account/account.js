
var accountApp = angular.module('accountApp', [ 'ui.router' ]);


loginApp.controller('AccountController', [ '$scope','$http','$state','SystemService', function($scope,$http,$state,SystemService) {
$scope.init = function() {
var data = {loginId : $scope.appData.loginForm.loginId};
var callback = function(response){
$scope.appData.account = response.data.account;
};
var req = {url:'/restWeb/account/getAccount', data:data,http:$http,state:$state, callback:callback};
SystemService.httpPost(req);
}
$scope.selectHolding = function() {

};
} ]);
