var accountApp = angular.module('accountApp', [ 'ui.router' ]);


accountApp.controller('AccountController', [ '$scope','$http','$state','SystemService', function($scope,$http,$state,SystemService) {
 $scope.init = function() {
  var data = {loginId : $scope.appData.loginForm.loginId};
  var callback = function(response){
        $scope.appData.account = response.data.account;
  };
  var req = {url:'/restWeb/account/getAccount', data:data,http:$http,state:$state, callback:callback};
  SystemService.httpPost(req);
 }
} ]);
accountApp.controller('HoldingController', [ '$scope','$http','$state','$stateParams','SystemService',
                                           function($scope,$http,$state,$stateParams,SystemService) {
 $scope.init = function() {
  var holding = $scope.selectHoldingById($stateParams.name);
  $scope.selectedHolding =  holding;
 }
 $scope.selectHoldingById = function(holdingId) {
  var holdings = $scope.appData.account.holdings;
  for (i in holdings) {
   var holding = holdings[i];
   if (holding.name == holdingId) {
    return holding;
   }
  }
 };
} ]);

accountApp.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {
    $stateProvider
        // Holding =================================
        .state('secured.account.holding', {
          url: '/holding/:name',
             views: {
                 'holding': { templateUrl: 'secured/account/holding.html' ,
                  controller:'HoldingController'
                 }
             }
        });
        
}]);
