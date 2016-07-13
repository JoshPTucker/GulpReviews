<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurant Profile</title>
</head>
<body>
<div class="container" style="background-color:blue" align="center">
<form action="ReviewServlet" method="post">
<fieldset>
<textarea name="userreview" id="userreview" placeholder="Write review here" rows=6 cols= 30 maxlength= 140></textarea>
</fieldset>
<fieldset>
<input type="number" name="rating" id="rating" ></input>
</fieldset>
<fieldset>
<input type="submit" name ="submit" id="submit" value="submit"></input>
</fieldset>
</form>

</div>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${currrestaurant.restaurantname}" /></td>
					<td><c:out value="${currrestaurant.restaurantdescription}" /></td>
					<td><c:out value="${currrestaurant.averagerating}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div>
		<%-- 	Posts ${posts} --%>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>user</th>
					<th>review</th>
					<th>Rating</th>
					<th>date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="reviews" items="${reviews}">
					<tr>
						<td><c:out value="${reviews.gulpuser.firstname}" /></td>
						<td><c:out value="${reviews.reviewtext}" /></td>
						<td><c:out value="${reviews.reviewrating}" /></td>
						<td><c:out value="${reviews.reviewdate}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</body>
</html>