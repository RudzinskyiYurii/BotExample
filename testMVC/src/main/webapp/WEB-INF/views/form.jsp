<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>Image-less CSS3 Glowing Form Implementation</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<script>
		$(function(){
		  var $form_inputs =   $('form input');
		  var $rainbow_and_border = $('.rain, .border');
		  /* Used to provide loping animations in fallback mode */
		  $form_inputs.bind('focus', function(){
		  	$rainbow_and_border.addClass('end').removeClass('unfocus start');
		  });
		  $form_inputs.bind('blur', function(){
		  	$rainbow_and_border.addClass('unfocus start').removeClass('end');
		  });
		  $form_inputs.first().delay(800).queue(function() {
			$(this).focus();
		  });
		});
	</script>
	<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">
	</head>
	<body id="home">
		<div class="rain">
			<div class="border start">
<%-- 				<form:form  method="GET" commandName="user" action="check-user" > --%>
				<form:form  method="GET" commandName="user" >
					<form:label path="email">Email</form:label>
					<form:input path="email" type="text" placeholder="Email"/>
					<form:label path="password" >Password</form:label>
					<form:input path="password" type="password" placeholder="Password"/>
                                        <input type="submit" value="LOG IN"/>
				</form:form>
			</div>
		</div>
	</body>
</html>