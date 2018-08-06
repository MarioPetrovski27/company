(function () {
    'use strict';

    angular.module('demo', [
    	'angular.filter',
        'ui.router',
        'pascalprecht.translate',
        'demo.home-module',
        'demo.company-module',
        'demo.employee-module',
        'demo.headquarter-module',
        'demo.city-module',
        'demo.equipment-module'
    ])
        .config(['$urlRouterProvider', '$translateProvider', '$httpProvider', '$stateProvider', configFunc])

        .run(['$state', '$rootScope', '$window', runFunc]);

    function configFunc($urlRouterProvider, $translateProvider, $httpProvider, $stateProvider) {

        $urlRouterProvider
            .otherwise('/home');
        
        $stateProvider.state('site', {
            'abstract': true,

                    templateUrl: 'app/scripts/home-module/view/home.html',
                    controller: 'home.ctrl'

        });

    }

    function runFunc($state, $rootScope, $window) {


        $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {

            $state.go('home', toParams, {notify: false}).then(function () {
                $window.sessionStorage.requestedState = fromState.name;
                $rootScope.$broadcast('$stateChangeSuccess', toState, toParams, fromState, fromParams);
            });

        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
            $rootScope.previousState = fromState;
            $rootScope.previousParams = fromParams;
        });
    }

})();