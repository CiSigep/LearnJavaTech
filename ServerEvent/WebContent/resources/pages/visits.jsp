<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ServerEvent</title>
<script type="text/javascript">
	var source = new EventSource("/ServerEvent/main/event");
	
	source.onmessage = function(e){
		console.log(e.data);
		document.getElementById("times").innerHTML = e.data;
	};
	
	source.addEventListener("open", function(e){
		if(console != null){
			console.log("open");
			}
			
	});
</script>
</head>
<body>
	This page has been visited <p id="times">${visits}</p> times.
</body>
</html>