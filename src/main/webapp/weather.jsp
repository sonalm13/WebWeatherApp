<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Weather</title>
</head>
<!-- load jquery -->
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.12.3.min.js"></script>

<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/flat-ui.min.css" rel="stylesheet">

<script type="text/javascript">
	$(function() {
		
		$('#weatherSelectInput').change(function() {
			$.ajax({
				type : "GET",
				url : "WeatherInfo?cityName=" +  $('#weatherSelectInput option:selected').val(), //controller URL
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(data) {
					console.log(data)					
					if (data) {
						if(data.errorMessage != "SUCSSES"){
							$("#error").append('<div><label for="name">'+ data.errorMessage + '</label></div>');
							$("#weatherTable").html("<tbody></tbody>");
						} else{
							var finaldata = "<tbody><tr><td>City</td><td>"	+ data.city + "</td></tr>" + 
											"<tr><td>Updated Time</td><td>" + data.updatedTime + "</td></tr>" +
											"<tr><td>Weather </td><td>"	+ data.weather + "</td></tr>" +
											"<tr><td>Temperature (Cel)</td><td>"	+ data.temperature	+ "</td></tr>" +
											"<tr><td>Wind (mps)</td><td>" + data.wind + "</td></tr>";
							finaldata = finaldata + "</tbody>";
							$("#weatherTable").html(finaldata);
							$("#error").empty();
						}
					}
				},
				error : function(data) {
					$("#error").append('<div><label for="name">Data is not availble. Please retry later.</label></div>');
					$("#weatherTable").html("<tbody></tbody>");
				}
			});
		});

		$(document).ready(function() {
			$.ajax({
				type : "GET",
				url : "getCities", //controller URL
				contentType : "application/json; charset=utf-8",
				dataType : "json",
				success : function(result) {
					var arrayJson = result.cities;
					var finaldata = "";
					if (arrayJson) {
						for (var i = 0; i < arrayJson.length; i++) {
							finaldata = finaldata + "<option value=" + arrayJson[i] + ">" + arrayJson[i] + "</option>";
							$("#weatherSelectInput").html(finaldata);
						}
						$('#weatherSelectInput option[value=' + arrayJson[0] + ']' ).attr("selected", "selected");
						$("#weatherSelectInput").change();    
					}
				},
				error : function(data) {
					$("#error").append('<div><label for="name">Data is not availble. Please retry later.</label></div>');
					$("#weatherTable").html("<tbody></tbody>");
				}
			});
		});
		
	});
		
</script>
<body>
<div class="container">
	<div class="row demo-row">
		<div class="col-xs-12">
		  <nav class="navbar navbar-inverse navbar-embossed" role="navigation">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
				<span class="sr-only">Toggle navigation</span>
			  </button>
			  <a class="navbar-brand" href="#">All Weather</a>
			</div>
		  </nav><!-- /navbar -->
		</div>
	</div>
	<div style="margin:auto"> 
		<div style="float:left">
			<h6>City of London, GB</h6>
		</div>
		<div style="float:right">
		 	<select class="select select-primary" data-toggle="select" tabindex="-1" title="" id="weatherSelectInput">
		    	
		    </select>
	    </div>
	</div>
	<div>
		<table class="table table-striped table-bordered table-condensed" id="weatherTable">
			<tbody>
			</tbody>
		</table>
	</div>
	<div id="error">
	</div>
</div>
</body>
</html>