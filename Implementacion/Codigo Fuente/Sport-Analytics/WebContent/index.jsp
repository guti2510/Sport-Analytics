<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular-animate.js"></script>
        <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-1.1.2.js"></script>
<style>
body {
    background-image: url("imagenes/background.jpg");
    background-repeat: no-repeat;
}
#banner{
    margin-right: 200px;
    margin-left: 200px;
	
}

</style>
<body>

<div id="banner" >
	<img alt="" src="imagenes/banner_soccer.jpg">
	<div ng-app="myApp" ng-controller="myCtrl"> 
		<div id="videoM">
			<video  width="1300" height = "500" ng-src={{videoSrc}} controls></video>
		</div>
	</div>
</div>



<script>

//Conexión simple a servlet, response= URL video
var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$scope.myWelcome = 'Esperando'
    $http.get("MyServlet")
    .then(function(response) {
        $scope.videoSrc = response.data;
    });
});
</script>


</body>
</html>