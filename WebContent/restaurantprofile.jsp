<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<fmt:setLocale value="en_us" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Restaurant Profile</title>
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body>
	<div>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Rating</th>
					<th>ZipCode</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${currrestaurant.restaurantname}" /></td>
					<td><c:out value="${currrestaurant.restaurantdescription}" /></td>
					<td><c:out value="${currrestaurant.averagerating}" /></td>
					<td><c:out value="${currrestaurant.restaurantzipcode }"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="container" style="background-color: aliciablue"
		align="center">
		<form action="ReviewServlet" method="post">
			<fieldset>
				<textarea name="userreview" id="userreview"
					placeholder="Write review here" rows=6 cols=30 maxlength=140></textarea>
			</fieldset>
			<fieldset>
				<input type="number" name="rating" id="rating"></input>
			</fieldset>
			<fieldset>
				<input type="submit" name="submit" id="submit" value="submit"></input>
			</fieldset>
		</form>
	</div>

	<div>
		<%-- 	Posts ${posts} --%>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>user</th>
					<th>review</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="reviews" items="${reviews}">
					<tr>
						<td><table>
						<tr><td><c:out value="${reviews.gulpuser.firstname}" /></td></tr>
						<tr><td><fmt:formatDate value="${reviews.reviewdate}" pattern="yy-MMM-dd" /></td></tr>
						</table></td>
						<td><c:out value="${reviews.reviewtext}" /></td>
						<td><c:out value="${reviews.reviewrating}" /> <c:choose>
								<c:when test="${reviews.reviewrating ==1}">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
								</c:when>
								<c:when test="${reviews.reviewrating ==2}">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
								</c:when>
								<c:when test="${reviews.reviewrating ==3}">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
								</c:when>
								<c:when test="${reviews.reviewrating ==4}">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
								</c:when>
								<c:when test="${reviews.reviewrating ==5}">
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
									<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
								</c:when>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</body>
</html>