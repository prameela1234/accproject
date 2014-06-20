<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Blog posts</title>
</head>
<style>
body

 /* {background-image:url("profnkata.com/images/psychic2.jpg") */
 {background-color: #b0c4de ;} 

</style>
<body>

	<div class="container">
		<blockquote>
			<h2>Food For Mind/Body</h2>
		</blockquote>
	</div>
	<div class="container">
		<c:forEach var="blogpost" items="${posts}">
			<blockquote>
			 	<p>${blogpost.title}</p>
				<p>${blogpost.date}</p>
				<p>${blogpost.text}</p>
				<p><a href="<c:url value="${blogpost.link}"/>">${blogpost.link}</a></p>
				<p><a href="/edit?rowid=<c:out value="${blogpost.id}"/>">Edit</a></p>
			</blockquote>
		</c:forEach>
	</div>

	<footer>
		<p>
			The blog database contains ${fn:length(posts)} posts as of
			<fmt:formatDate value="${now}" pattern="E h:m a" />
		</p>
	</footer>

</body>
</html>