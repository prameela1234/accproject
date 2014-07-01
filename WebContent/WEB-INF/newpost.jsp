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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Post</title>
</head>
<body>
<jsp:include page="/WEB-INF/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="well">

			<h2>Add a Post</h2>
			<form method="POST" action="/new">

				<div class="form-group">
					<label for="title">Title</label> <input type="text"
						class="form-control" name="title" placeholder="Title" />

				</div>
				
				<div class="form-group">
					<label for="text">Text</label>  
					  <textarea rows="10" class="form-control" 
					  name="text" placeholder="content"></textarea> 
				</div>

				<div class="form-group">
					<label for="link">Link</label> <input type="text" 
					class="form-control" name="link" placeholder="Link" />
				</div>

				<div class="form-group">
					<label for="img">Image URL</label> <input type="text"
						class="form-control" name="img" placeholder="Image URL" />

				</div>

				<button class="btn btn-primary">Add</button>
			</form>
		</div>
	</div>

</body>
</html>