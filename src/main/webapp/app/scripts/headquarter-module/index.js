(function () {
    'use strict';

    angular.module('demo.headquarter-module',
        [
            'demo.headquarter-module.filters',
            'demo.headquarter-module.controllers',
            'demo.headquarter-module.services'
        ]).config(
			[ '$stateProvider', configFunc ]);

	function configFunc($stateProvider) {
		
		$stateProvider
		.state('headquarter', {
			parent : 'site',
			url : "/headquarter",
		     views: {

                 "main@": {
				templateUrl : 'app/scripts/headquarter-module/view/headquarter.html',
				controller : 'headquarter.ctrl'
			}
		     }
		})
	}
})();