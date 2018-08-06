(function () {
    'use strict';

    angular.module('demo.company-module',
        [
            'demo.company-module.filters',
            'demo.company-module.controllers',
            'demo.company-module.services'
        ]).config(
			[ '$stateProvider', configFunc ]);

	function configFunc($stateProvider) {
		
		$stateProvider
		.state('company', {
			parent : 'site',
			url : "/company",
		     views: {

                 "main@": {
				templateUrl : 'app/scripts/company-module/view/company.html',
				controller : 'company.ctrl'
			}
		     }
		})
	}
})();