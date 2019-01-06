<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet"
href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.cs
s">
 <script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
    <title>Edit account</title>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
    <link type="text/css" href="/resources/css/styles.css" rel="stylesheet" /> 
</head>
<body>
<h2>Create new Person</h2>
<form> <!--action="/person/save" method="post" -->
    <table class="table table-bordered">
        <tbody>
            <!--  <tr><th>id</th><td><input type="text" name="id" required="required"></td></tr> -->
            <tr><th>name</th><td><input type="text" name="name" required="required" id="name"></td></tr>
            <tr><th>DOB</th><td><input placeholder="dd/mm/yyyy" type="text" name="dob" required="required" id="dob"></td></tr>
            <tr><th>gender</th><td><input placeholder="type male or female" type="text" name="gender" required="required" id="gender"></td></tr>
            <tr><td colspan="2"><a href="./Person/listAll" class="btn btn-primary">Back</a> 
            <input type="submit" value="Add" id="submitButton" class="btn btn-success"></tr>
            <p id="nameError">Name not valid</p>
            <p id="nameError">Date of Birth not valid</p>
            <p id="nameError">gender not valid</p>
                        
        </tbody>
    </table>
    
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

	$(document).ready(function() {
		
		
		$("#submitButton").on("click",function(e) {
			
			e.preventDefault();
			
			console.log("inside submit function");
			
			isValid = false;
			
			// Get the values from the form
			var nameValue = $("#name").val();
			
			var dobValue = $("#dob").val();
				
			var genderValue = $("#gender").val();
						
			if (nameValue == "" || dobValue == "" || genderValue == "") {
				
				if (nameValue == "") {
					isValid = false;
				} else {
					isValid = true;
				}
				
				if (dobValue == "") {
					isValid = false;	
				} else {
					isValid = true;
				}
				
				if (genderValue == "") {
					
					isValid = false;
				} else {
					
					isValid = true;
				}
				
			}
			
			var saveUrl = window.origin + "/GE/person/submit";
			
			console.log(saveUrl);
			
			alert(saveUrl);
			
			// If form is value then Ajax
			if (isValid == true) {
			
				alert("form is valid");
				
				$("p").css({"background-color": "yellow", "font-size": "200%"});
				$("#error").css({"visibility": "visible"})
				
							
				$.ajax({
					type: POST,
					url: saveUrl,
					data: { name: nameValue, 
						    dob : dobValue, 
						    gender: genderValue },
					
				})
			
			}
						
			alert("ready");
			
		});
		
	});
		
	
	function checkErrors() {
		
		var nameValue = $("#name").val();
		console.log(nameValue);
		
		var dobValue = $("#dob").val();
		console.log(dobValue);
		
		var genderValue = $("#gender").val();
		console.log(genderValue);
		
		if ( (nameValue == "" || nameValue == null) || 
	       (dobValue == ""  || dobValue == null) ||
	       (genderValue == "" || genderValue == null) ) {
			
			return false
			
		}
		
		return true;
	}		

</script>

</body>
</html>