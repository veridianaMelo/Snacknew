

function login(){
	
	$("#login").click(function(event) {
		location.href = "login.html";
	});

	$("#login").parent().show();
	
	
}


function logoutOk() {
	App.auth.clearAuthentication();
	location.href = "";
}