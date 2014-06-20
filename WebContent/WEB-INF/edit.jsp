<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/bootstrap.css" />

<title>Edit Post</title>
</head>
<body>

	<div class="container">
		<h2>Edit Post:${blogpost.id}</h2>
		
		<form action="/edit" method="post">
			<input name="id" type="hidden" value="${blogpost.id}" />
			
			<div class="form-group">
				<label for="text">Title</label> <input name="title" type="text"
					class="form-control" value="${blogpost.title}">
			</div>

			<!-- <div class="form-group">
				<label for="text">Content</label> 
     			  <textarea rows="10" class="form-control" 
					  id="text" placeholder="content"></textarea> 
			</div>
			 -->
			
			<div class="form-group">
				<label for="text">Text</label> <input name="text" type="text"
					class="form-control" value="${blogpost.text}">
			</div>
			
			
			<div class="form-group">
				<label for="text">Link</label> <input name="link" type="text"
					class="form-control" value="${blogpost.link}">
			</div>
			
			<div class="form-group">
				<label for="text">Image URL</label> <input name="img" type="text"
					class="form-control" value="${blogpost.img}">
			</div>

			<button type="submit" class="btn btn-default">Save</button>

		</form>

	</div>

</body>
</html>