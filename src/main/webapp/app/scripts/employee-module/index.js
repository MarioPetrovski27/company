(function () {
    'use strict';

    angular.module('demo.employee-module',
        [
            'demo.employee-module.filters',
            'demo.employee-module.controllers',
            'demo.employee-module.services'
        ]).config(
			[ '$stateProvider', configFunc ]);

	function configFunc($stateProvider) {
		
		$stateProvider
		.state('employee', {
			parent : 'site',
			url : "/employee",
		     views: {

                 "main@": {
				templateUrl : 'app/scripts/employee-module/view/employee.html',
				controller : 'employee.ctrl'
			}
		     }
		})
	}
})();