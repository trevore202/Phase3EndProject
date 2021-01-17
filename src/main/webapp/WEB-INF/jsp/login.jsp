<html>

<head>
<title>First Web Application</title>
</head>

<body>
	<font color="red">${errorMessage}</font>
	<form method="post" action="login">
		Name : <input type="text" name="name" /><br/>
		Password : <input type="password" name="password" /><br/> 
		<input type="submit" />
	</form>
	
	<br/>
	
	<a href="register">Register New User</a>
	
</body>

</html>