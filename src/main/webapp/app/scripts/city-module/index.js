(function () {
    'use strict';

    angular.module('demo.city-module',
        [
            'demo.city-module.filters',
            'demo.city-module.controllers',
            'demo.city-module.services'
        ]).config(
			[ '$stateProvider', configFunc ]);

	function configFunc($stateProvider) {
		
		$stateProvider
		.state('city', {
			parent : 'site',
			url : "/city",
		     views: {

                 "main@": {
				templateUrl : 'app/scripts/city-module/view/city.html',
				controller : 'city.ctrl'
			}
		     }
		})
	}
})();