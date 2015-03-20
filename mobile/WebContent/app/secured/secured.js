var secured = angular.module('secured', ['ui.router','accountApp']);


secured.config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {
    $stateProvider
        // Account =================================
        .state('secured.account', {
         url: '/account',
            views: {
                 'main': { templateUrl: 'secured/account/account.html' ,
                  controller:'AccountController'
                 }
            }
        });
        
}]);
