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
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>	
	<script src="${ctx }/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta name="google-signin-client_id" content="625947913719-v1a7p7919j06h6q99i3kbinee05pkofc.apps.googleusercontent.com">
	
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
<a href="#" onclick="signOut();">Sign out</a>
<!-- '네이버 아이디로 로그인하기' 버튼 -->
<div id="naver_id_login"></div>
</body>

	
	

<script type="text/javascript">
	/* 구글 */
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
	
	function signOut() {
	   var auth2 = gapi.auth2.getAuthInstance();
	   auth2.signOut().then(function () {
	     console.log('User signed out.');
	   });
	 }

	/* 네이버아이디로로그인 */
	var naver_id_login = new naver_id_login("baYBZ_bPa2kXck0YG69v", "http://localhost:8080/");	// Client ID, CallBack URL 삽입
									// 단 'localhost'가 포함된 CallBack URL
	var state = naver_id_login.getUniqState();

	naver_id_login.setButton("white", 2, 40);
	naver_id_login.setDomain("서비스 URL");	//  URL
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
	
	// 접근 토큰 값 출력
	alert(naver_id_login.oauthParams.access_token);
	
	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
	
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
		alert(naver_id_login.getProfileData('email'));
		alert(naver_id_login.getProfileData('nickname'));
	}
</script>

</html>