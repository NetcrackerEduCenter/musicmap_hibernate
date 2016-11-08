<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://vk.com/js/api/openapi.js?136" type="text/javascript"></script>
	<script src="//api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<style>
		html, body, #main {
			height: 100%;
			margin: 0;
			padding: 0;
		}

		#main {
			position:relative;
		}

		#header, #map{
			position:absolute;
		}

		#header {
			height:100px;
			width:100%;
			background: #111;
			padding-top: 20px;
			padding-left: 20px;
		}
		#map {
			top:100px;
			bottom:0px;
			width:100%;
		}

		.btn-default{
			height:50px;
			width:200px;
			font-size: 25px !important;
		}

	</style>

</head>
<body>

<div id="main">
	<div id="header">
		<div class="btn-group" role="group" aria-label="...">
			<c:url var="saveUrl" value="/musicmap/main/start" />
			<form:form modelAttribute="userDataAttribute" method="POST" action="${saveUrl}">
				<form:input type="hidden" path="vkIdLine" id="vkIdLine"/>
				<form:input type="hidden" path="x" id="x"/>
				<form:input type="hidden" path="y" id="y"/>
				<form:input type="hidden" path="songs" id="songs"/>
				<button type="button" class="btn btn-default" id="findMe">Find me</button>
				<button type="button" class="btn btn-default" id="getAudio">Get audio</button>
				<input type="submit" value="Send" class="btn btn-default" />
			</form:form>
		</div>

	</div>

	<div id="map"></div>
</div>

<script type="text/javascript">
	ymaps.ready(init);

	function init() {
		var geolocation = ymaps.geolocation,
				myMap = new ymaps.Map('map',
						{
							center: [59.939095, 30.315868],
							zoom: 11,
							controls: []
						});
		var button = document.getElementById("findMe");
		button.addEventListener("mousedown", function (event) {
			if (event.which == 1) {
				geolocation.get({
					provider: 'auto',
					mapStateAutoApply: false,
					autoReverseGeocode: true
				}).then(function (result) {
					result.geoObjects.options.set('preset', 'islands#blueCircleIcon');
					if (result.geoObjects.accuracy < 2000) {
						myMap.geoObjects.add(result.geoObjects);
						document.getElementById('x').value = result.geoObjects.get(0).geometry.getCoordinates()[0];
						document.getElementById('y').value = result.geoObjects.get(0).geometry.getCoordinates()[1];
					} else {
						document.getElementById('x').value = 'low accuracy';
					}
				});


			}
		});
	}
</script>
<script type="text/javascript">
	VK.init({
		apiId: 5697583
	});

	var button = document.getElementById("getAudio");
	button.addEventListener("mousedown", function (event) {
		if (event.which == 1) {
			VK.Auth.login(function (response) {
				if (response.session) {
					/* Пользователь успешно авторизовался */
					document.getElementById('vkIdLine').value = response.session.mid;
					VK.Api.call('audio.get',
							{owner_id: response.session.mid},
							function (result) {
								result.response.shift();
								var str = JSON.stringify(result.response, ["aid", "artist", "genre"]);
								document.getElementById('songs').value = str;
							});
					VK.Auth.revokeGrants();
				}
				else {
					/* Пользователь нажал кнопку Отмена в окне авторизации */
				}
			}, 8);

		}
	});
</script>

</body>
</html>