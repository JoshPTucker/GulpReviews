<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create account</title>
</head>
<body>
	<div align="center">
		<form  action="CreateAccount" method="post">
			
			<fieldset>
				<input type="text" name="firstname" id="firstname" value=""
					placeholder="firstname"></input>
			</fieldset>
			<fieldset>
				<input type="text" name="lastname" id="lastname" value=""
					placeholder="lastname"></input>
			</fieldset>
			<fieldset>
				<input type="text" name="zipcode" id="zipcode" value=""
					placeholder="zipcode"></input>
			</fieldset>
			<fieldset>
				<input type="text" name="email" id="email" value=""
					placeholder="email"></input>
			</fieldset>
			
			<fieldset>
				<input type="password" name="password" id="password" value=""
					placeholder="password"></input>
			</fieldset>
		 <input type="submit" name="submit"
				id="submit" value="create"></input>
		</form>
	</div>
</body>
</html>