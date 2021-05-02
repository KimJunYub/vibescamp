<!-- <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
---- Include the above in your HEAD tag --------
 -->
<!DOCTYPE html>
<html>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<jsp:include page="${ctx }/WEB-INF/views/include/setDefault.jsp"/>
<head>
	<title>Login Page</title>
	
	<meta charset="utf-8" />
	<meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="625947913719-v1a7p7919j06h6q99i3kbinee05pkofc.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
	
    <!--Made with love by Mutiullah Samim -->
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="${ctx }/resources/custom/css/styles.css">
	<!-- CSS here -->
	<link rel="stylesheet" href="${ctx }/resources/assets/css/style.css">
	
	<script src="${ctx }/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
</head>
<body>
<div class="container">
	<jsp:include page="${ctx }/WEB-INF/views/include/header.jsp"/>
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Sign In</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square" onclick="onSignIn();"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div>
			</div>
			<div class="card-body">
				<form id="target">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" id="userId" name="userId" class="form-control" placeholder="username">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" id="password" name="password" class="form-control" placeholder="password">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Remember Me
					</div>
					<div class="form-group">
						<input id="submitBtn" type="button" value="Login" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="#">Sign Up</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
				</div>
			</div>
			
			<div class="g-signin2" data-theme="dark" onclick="onSignIn();"></div>
		</div>
	</div>
</div>
<jsp:include page="${ctx }/WEB-INF/views/include/publicJs.jsp"/>
</body>
<script type="text/javascript">

$(document).ready(function(){
	
	var result = '${result}';
	
	if(result == "FAIL"){
		alert("login 실패");
	}

});

$('#submitBtn').click(function(){
	var target = document.getElementById("target");
	target.method = "post";
	target.action = "loginProcess.do";
	
	target.submit();
});

function onSignIn() {
	var auth2 = gapi.auth2.getAuthInstance();
	
	alert(auth2);
	alert(auth2.isSignedIn.get());
	
	if (auth2.isSignedIn.get()) {
		var profile = auth2.currentUser.get().getBasicProfile();
		console.log('ID: ' + profile.getId());
		console.log('Full Name: ' + profile.getName());
		console.log('Given Name: ' + profile.getGivenName());
		console.log('Family Name: ' + profile.getFamilyName());
		console.log('Image URL: ' + profile.getImageUrl());
		console.log('Email: ' + profile.getEmail());
	}
}

</script>

<!-- <a href="#" onclick="signOut();">Sign out</a>
<script>
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }
</script> -->


</html>