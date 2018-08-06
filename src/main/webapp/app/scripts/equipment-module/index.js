(function () {
    'use strict';

    angular.module('demo.equipment-module',
        [
            'demo.equipment-module.filters',
            'demo.equipment-module.controllers',
            'demo.equipment-module.services'
        ]).config(
			[ '$stateProvider', configFunc ]);

	function configFunc($stateProvider) {
		
		$stateProvider
		.state('equipment', {
			parent : 'site',
			url : "/equipment",
		     views: {

                 "main@": {
				templateUrl : 'app/scripts/equipment-module/view/equipment.html',
				controller : 'equipment.ctrl'
			}
		     }
		})
	}
})();