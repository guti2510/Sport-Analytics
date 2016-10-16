var myApp = angular.module('myApp', []);


         
		myApp.factory('videoName', function() 
				{
		 			var obj = this;
					var video = "Video.mp4";
					obj.getVideo = 
					function()
					{
						return video;
					}
					
					obj.setVideo = function(pVideo)
					{
						video = pVideo;
					}
					return obj;
		});
      
         myApp.controller('myCtrl', ['$scope', '$http','videoName', function($scope,$http,videoName){
            $scope.uploadFile = function(){
            	
               var file = $scope.myFile;
               alert("Inicio de Analisis");
               
               var uploadUrl = "UploadServlet";
               
               var fd = new FormData();
               fd.append('file', file);
            
               $http.post(uploadUrl, fd, {
                  transformRequest: angular.identity,
                  headers: {'Content-Type': undefined}
               })
            
               .success(function(response){
            	   //resultado = JSON.parse(response);
            	   
            	   //Muestra el video que fue segmentado
            	   alert(response.video);
            	   $scope.videoSrc = "video/"+response.video;
            	   videoName.setVideo(response.video);
            	   alert(response.data);
            	   $scope.resultado = response.data;
            	   alert("Analisis finalizado");
               })
            
               .error(function(response){
            	   alert("Error!")
            	   alert(response);
               });
               
               //fileUpload.uploadFileToUrl(file, uploadUrl,$scope.videoSrc);
               
            };
         }]);
         
         
         myApp.controller('compCtrl', ['$scope', '$http','videoName', function($scope,$http,videoName){
             $scope.uploadFileGround = function(){
             	
                var file = $scope.myFileGround;
                alert("Estado  del Proceso: Iniciado");
                
                var uploadUrl = "UploadServletGround";
                
                var fd = new FormData();
                fd.append('file', file);
                var videoSrc = videoName.getVideo();
                //alert("Comparando el video :"+videoSrc);
                fd.append('video',videoSrc);
             
                $http.post(uploadUrl, fd, {
                   transformRequest: angular.identity,
                   headers: {'Content-Type': undefined}
                })
             
                .success(function(response){
                	alert("Obteniendo Resultado")
                	alert(response.data.CantFalsoNegativo)
             	   
             	   $scope.negativos = response.data.CantFalsoNegativo;
                	$scope.positivos = response.data.CantFrames;
                	$scope.frames = response.data.CantFalsoPositivo;
             	   alert("Estado del proceso: Finalizado");
                })
             
                .error(function(response){
             	   alert("Error!")
             	   alert(response);
                });
                
                //fileUpload.uploadFileToUrl(file, uploadUrl,$scope.videoSrc);
                
             };
          }]);
         myApp.directive('fileModel', ['$parse', function ($parse) {
             return {
                restrict: 'A',
                link: function(scope, element, attrs) {
                   var model = $parse(attrs.fileModel);
                   var modelSetter = model.assign;
                   
                   element.bind('change', function(){
                      scope.$apply(function(){
                         modelSetter(scope, element[0].files[0]);
                      });
                   });
                }
             };
          }]);
       