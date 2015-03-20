var testWeb = angular.module('testWeb', ['ui.router','loginApp','accountApp']);

testWeb.service('SystemService', function(){
this.handlerHttpError=function($scope, error, status){
//TODO
}
this.httpPost=function(req){
var url = req.url;
var data = req.data;
var http = req.http;
var state = req.state;
var callback = req.callback;

http.post(url, data).
success(function(data, status, headers, config) {
var response = {data:data, status:status,headers:headers,config:config, redirected:false}; 
if(data.errors){
for (i in data.errors) {
var error = data.errors[i];
if (error.code == 'notLogin') {
response.redirected=true;
state.go('login');
}
}
}
callback(response);
}).
error(function(data, status, headers, config) {
var response = {data:data, status:status,headers:headers,config:config, redirected:false}; 
if (status == 401) {
response.redirected=true;
state.go('login');
}
callback(response);
});
}
});

testWeb.run(['$rootScope', function($rootScope) {
$rootScope.appData={};
}]);
testWeb.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {
$urlRouterProvider.otherwise('/login');
$stateProvider
// Login ========================================
.state('login', {
url: '/login',
views : {
'main': { templateUrl: 'login/login.html',
controller:'LoginController'}
}

})
// Account =================================
.state('account', {
url: '/account',
views: {
'main': { templateUrl: 'account/account.html' ,
controller:'AccountController'
}
}
});

}]);
