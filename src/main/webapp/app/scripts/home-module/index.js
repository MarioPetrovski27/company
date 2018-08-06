(function () {
    'use strict';

    angular.module('demo.home-module',
        [
            'demo.home-module.filters',
            'demo.home-module.controllers',
            'demo.home-module.services'
        ]).config(
			[ '$stateProvider', configFunc ]);

	function configFunc($stateProvider) {
		
		$stateProvider
		.state('home', {
			parent : 'site',
			url : "/home",
		     views: {

                 "main@": {
				templateUrl : 'app/scripts/home-module/view/home.html',
				controller : 'home.ctrl'
			}
		     }
		})
	}
})();