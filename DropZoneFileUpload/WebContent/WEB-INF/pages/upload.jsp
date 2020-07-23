<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value="/resources/css/dropzone.css"/>">
<script src="<c:url value="/resources/js/jquery-3.1.1.js"></c:url>"></script>
<script src="<c:url value="/resources/js/dropzone.js"></c:url>"></script>
</head>
<body>
	<div class="container">
		<h2>
			File upload using <a href="http://www.dropzonejs.com">Dropzone.js</a>
			and spring MVC
		</h2>
		<div class="alert alert-success" id="alert-success" role="alert">
		</div>
		<div class="row">
			<div class="col-lg-6">
				<div class="dropzone" id="my-awesome-dropzone">
					<!-- 									<input type="file" name="file" /> -->
					<div class="dz-progress">
						<span class="dz-upload" data-dz-uploadprogress></span>
					</div>
				</div>
				<span id="resText"></span>
			</div>
		</div>
	</div>
</body>
<style>
.alert {
	display: none;
}
</style>
<script>
	Dropzone.autoDiscover = false;

	$(document).ready(function() {

		dropzone = new Dropzone(".dropzone", {
			url : "upload",
			uploadMultiple : false,
			acceptedFiles : "image/*,video/*",
			addRemoveLinks : true,
			forceFallback : false,
			maxFilesize : 1000,
			parallelUploads : 100,

		});

		dropzone.on("uploadprogress", function(file, progress, bytesSent) {
			console.log('progress  ' + progress);
			console.log('bytesSent  ' + bytesSent);
		});

		dropzone.on("success", function(file, response) {

			console.log(response);

			$("#alert-success").show();
			$("#alert-success").text('file uploaded successfully');
		});

	});
</script>
</html>