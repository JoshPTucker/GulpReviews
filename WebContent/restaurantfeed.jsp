<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>restaurant feed</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<div>
		<form action="RestaurantFeed" method="post">
			<input type="submit" name="submit" id="submit"
				value="Refresh restaurant"></input>
		</form>
	</div>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Rating</th>
					<th>      </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="restaurants" items="${restaurants}">
					<tr>
						<td><c:out value="${restaurants.restaurantname}" /></td>
						<td><c:out value="${restaurants.restaurantdescription}" /></td>
						<td><c:out value="${restaurants.averagerating}" /></td>
						<td><form action="RestaurantProfile" method="post">
								<input type="hidden" name="restaurantview" id="restaurantview" 
								value="${restaurants.restaurantid}"></input>
								<input type="submit" name="submit" id="submit" value="visitPage"></input>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>