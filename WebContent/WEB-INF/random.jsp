<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.css" />
<title>A Simple Blog</title>
</head>
<style>
body{
		<c:forEach var="blogpost" items="${posts}">
     background-image:url('<c:out value="${blogpost.img}"/>');
		</c:forEach>
}
</style>

<body>
	<div class="jumbotron">
		<h3>A post from archive</h3>
	</div>

	<div class="container">
		<c:forEach var="blogpost" items="${posts}">
		<blockquote>
				<p>${blogpost.title}     <a href="/edit?rowid=<c:out value="${blogpost.id}"/>">Edit</a></p>
				<p>${blogpost.text}</p>
				<p><a href="<c:url value="${blogpost.link}"/>">More on ${blogpost.title}!</a></p>
				<p><a href="/new">Add a post</a></p>
				
		</blockquote>
		</c:forEach>
	</div>
 
	<script src="/js/bootstrap.js"></script>
</body>
</html>
 --%>

 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<my:layout>
	<jsp:attribute name="body">
    <link rel="stylesheet" href="/css/bootstrap.css" /> 

<style>
body { 
      	<c:forEach var="blogpost" items="${posts}">
     background-image:url('<c:out value="${blogpost.img}"/>');
		</c:forEach>
}
</style>

<div class="jumbotron">
		<h3>A post from archive</h3>
</div>

<div class="container">
		<c:forEach var="blogpost" items="${posts}">
		<blockquote>
				<p>${blogpost.title}</p>
				<p>${blogpost.text}</p>
				<p>
						<a href="<c:url value="${blogpost.link}"/>">More on ${blogpost.title}!</a>
					</p>
		</blockquote>
		</c:forEach>
</div>

</jsp:attribute>
</my:layout>
