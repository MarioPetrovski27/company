<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.css" />
<link rel="stylesheet" href="styles/main.css">

</head>
<body data-ng-app="demo">

	<div ui-view="navbar" ng-cloak=""></div>
	<div class="container">
		<div class="well" ui-view="main"></div>
	</div>

	<!-- build:js(.) scripts/vendor.js -->
	<!-- bower:js -->
	<script src="bower_components/jquery/dist/jquery.js"></script>
	<script src="bower_components/angular/angular.js"></script>
	<script src="bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script src="bower_components/angular-animate/angular-animate.js"></script>
	<script src="bower_components/angular-cookies/angular-cookies.js"></script>
	<script src="bower_components/angular-resource/angular-resource.js"></script>
	<script src="bower_components/angular-route/angular-route.js"></script>
	<script src="bower_components/angular-sanitize/angular-sanitize.js"></script>
	<script src="bower_components/angular-touch/angular-touch.js"></script>
	<script
		src="bower_components/angular-filter/dist/angular-filter.min.js"></script>
	<script
		src="bower_components/angular-ui-router/release/angular-ui-router.js"></script>
	<script src="bower_components/angular-translate/angular-translate.js"></script>
	<script
		src="bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.js"></script>
	<!-- endbower -->
	<!-- endbuild -->

	<!--HOME - MODULE-->

	<script src="app/scripts/home-module/index.js"></script>
	<script src="app/scripts/home-module/controller/index.js"></script>
	<script src="app/scripts/home-module/filter/index.js"></script>
	<script src="app/scripts/home-module/service/index.js"></script>
	<script src="app/scripts/home-module/controller/home.ctrl.js"></script>

	<!--COMPANY - MODULE-->

	<script src="app/scripts/company-module/index.js"></script>
	<script src="app/scripts/company-module/controller/index.js"></script>
	<script src="app/scripts/company-module/filter/index.js"></script>
	<script src="app/scripts/company-module/service/index.js"></script>
	<script src="app/scripts/company-module/controller/company.ctrl.js"></script>
	
	<!--EMPLOYEE - MODULE-->

	<script src="app/scripts/employee-module/index.js"></script>
	<script src="app/scripts/employee-module/controller/index.js"></script>
	<script src="app/scripts/employee-module/filter/index.js"></script>
	<script src="app/scripts/employee-module/service/index.js"></script>
	<script src="app/scripts/employee-module/controller/employee.ctrl.js"></script>

	<!--HEADQUARTER - MODULE-->

	<script src="app/scripts/headquarter-module/index.js"></script>
	<script src="app/scripts/headquarter-module/controller/index.js"></script>
	<script src="app/scripts/headquarter-module/filter/index.js"></script>
	<script src="app/scripts/headquarter-module/service/index.js"></script>
	<script src="app/scripts/headquarter-module/controller/headquarter.ctrl.js"></script>
	
	<!--CITY - MODULE-->

	<script src="app/scripts/city-module/index.js"></script>
	<script src="app/scripts/city-module/controller/index.js"></script>
	<script src="app/scripts/city-module/filter/index.js"></script>
	<script src="app/scripts/city-module/service/index.js"></script>
	<script src="app/scripts/city-module/controller/city.ctrl.js"></script>
	
	<!--EQUIPMENT - MODULE-->

	<script src="app/scripts/equipment-module/index.js"></script>
	<script src="app/scripts/equipment-module/controller/index.js"></script>
	<script src="app/scripts/equipment-module/filter/index.js"></script>
	<script src="app/scripts/equipment-module/service/index.js"></script>
	<script src="app/scripts/equipment-module/controller/equipment.ctrl.js"></script>


	<script src="app/scripts/app.js"></script>

</body>
</html>