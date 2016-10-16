<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html id="ng-app" ng-app="myApp">
<!-- id="ng-app" IE<8 -->

<head>
<title>Simple example</title>
	
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Didact+Gothic" rel="stylesheet" />
<link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!-- Fix for old browsers -->
<script src="http://nervgh.github.io/js/es5-shim.min.js"></script>
<script src="http://nervgh.github.io/js/es5-sham.min.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="node_modules/angular-file-upload/examples/console-sham.js"></script>


<!--<script src="../bower_components/angular/angular.js"></script>-->
<script src="http://code.angularjs.org/1.1.5/angular.min.js"></script>
<script
	src="node_modules/angular-file-upload/dist/angular-file-upload.min.js"></script>
<script src="scripts/controllers.js"></script>
<script src="scripts/funciones.js"></script>


</head>

<!-- 1. nv-file-drop="" uploader="{Object}" options="{Object}" filters="{String}" -->
<body ng-app="myApp" >

<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">Boca Juniors</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li class="active"><a href="generar" accesskey="1" title="">Inicio</a></li>
				<li><a href="comparar" accesskey="2" title="">GroundTruth</a></li>
				<li><a href="#" accesskey="3" title="">Acerca de</a></li>
			</ul>
		</div>
		
		
</div>
<div ng-controller = "myCtrl" id="header-wrapper"  >
	<div id="welcome" class="container">
		<div class="title">
			<h2>Segmentador de videos</h2>
		</div>
		<div >
		<div class="browse-wrap">
		    <div class="titulo">Selecciona el video</div>
		    <input type="file" file-model = "myFile" name="upload" class="upload" title="Choose a file to upload">
		</div>
		<span class="upload-path"></span>
		<button ng-click = "uploadFile()" class="button">Analizar</button>
      </div>
	</div>
	<div id=visualizador class="container">
		<div class="title">
			<h2>Video Segmentado</h2>
		</div>
		<div>
			<video  width="1000" height = "500" ng-src={{videoSrc="video/Video.mp4"}} controls></video>
		</div>
	</div>
	<div id="welcome">
	<div class="container">
		<div class="title">
			<h2>Resultado</h2>
		</div>
		<div>
			<table class="heavyTable">
			<tbody>
				<thead>
					<tr>
					    <th>Initial Frame</th>
					    <th>Last Frame </th>
					    <th>Event Type</th>
					    <th>Scene Type</th>
					</tr>
				</thead>
				  <tr ng-repeat="x in resultado">
				    <td>{{ x.initialFrame }}</td>
				    <td>{{ x.lastFrame }}</td>
				    <td>{{ x.eventType }}</td>
				    <td>{{ x.sceneType}}</td>
				  </tr> 
			
			</tbody>
				
			</table>
			
		</div>
		
		<ul class="actions">
			
		</ul>
		<div>
			<a href="cortesGenerados/CortesDetectados.json" download="cortesDetectados.json">
			 	<img border="0" src="css/images/descarga.png" alt="descargaImagen" width="104" height="142">
			</a>
		</div>
	</div>
</div>
	
</div>

<div ng-controller = "compCtrl" id="visualizador" class="container">

	<div class="browse-wrap">
		    <div class="titulo">Selecciona el archivo GroundTruth</div>
		    <input type="file" file-model = "myFileGround" name="uploadGround" class="upload" title="Choose a file to upload">
	</div>
	
	<span class="upload-path"></span>
	<button ng-click = "uploadFileGround()" class="button">Comparar</button>
	
	<div id="welcome">
		<div class="container">
			<div class="title">
				<h2>Resultado Comparación</h2>
			</div>
			
			<br><br>
			<div>
				<h2>Cantidad de Falsos Positivos: </h2>
				<h3>{{positivos}}</h3>
			</div>
			<div>
				<h2>Cantidad de Falsos Negativos: </h2>
				<h3>{{negativos}}</h3>
			</div>
			<div>
				<h2>Cantidad de Frames: </h2>
				<h3>{{frames}}</h3>
			</div>
		
		</div>
		
	</div>
	<ul class="actions">
			
	</ul>
	
		
		
		
		
	</div>
</div>


<div id="copyright" class="container">
	<p>&copy; SportsAnalytics. All rights reserved. | Photos by <a href="http://bocaJuniors.com/">Fotogrph</a> | Design by <a href="Kate" rel="nofollow">2016</a>.</p>
</div>



</body>
</html>
