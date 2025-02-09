<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Login Page</title>
	</head>
	<body>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<h2>Login</h2>
			<pre>${errorMessage}</pre>
			<form method=post>
				Name:<input type="name" name="name"></input>
				Password:<input type="password" name="password"></input>
				<button>Submit</button>
			</form>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>