
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>

<my:layout>
	<jsp:attribute name="body">
    <link rel="stylesheet" href="/css/bootstrap.css" /> 

<style>
body{
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
