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
src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"><
/script>
 <script
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
    <title>Create an account</title>
</head>
<body>
<h2>Create new Person</h2>
<!-- action="/account/save" -->
<form method="post">
    <table class="table table-bordered">
        <tbody>
            <!--  <tr><th>id</th><td><input type="text" name="id" required="required"></td></tr>-->
            <tr><th>dateOfBirth</th><td><input id="dob" type="text" name="dateOfBirth" required="required"></td></tr>
            <tr><th>fathersKey</th><td><input id="fathersKey" type="text" name="fathersKey" required="required"></td></tr>
            <tr><th>gender</th><td><input id="gender" type="text" name="gender" required="required"></td></tr>
            <tr><th>mothersKey</th><td><input id="mothersKey" type="text" name="mothersKey" required="required"></td></tr>
            <tr><th>name</th><td><input id="name" type="text" name="name" required="required"></td></tr>
            <tr><th>key</th><td><input id="specialKey" type="text" name="specialKey" required="required"></td></tr>
            
            
           <tr><td colspan="2"><a href="./listAll" class="btn btn-primary">Back</a> <input id="submit" type="submit" value="Add" class="btn btn-success"></tr>
        </tbody>
    </table>
    
</form>

<script>

$(document).ready(function() {

	/*
	{ name: name, 
    dob : dob, 
    gender: gender,
    mothersKey: mothersKey,
    fathersKey: fathersKey,
    specialKey: specialKey}
	*/
	
	var saveUrl = window.origin + "/GE/person/savePerson";
	
	$("#submit").click(function(e) {
		e.preventDefault(); 
		
		// Gets the form values
		var pdob = $('#dob').val();
		var pfathersKey = $('#fathersKey').val();
		var pgender = $('#gender').val();
		var pmothersKey = $('#mothersKey').val();
		var pname = $('#name').val();
		var pspecialKey = $('#specialKey').val();
		
		var isValid = false;
		
		// Checks that inputs in right form
		if ( (pdob != "" || pdob !=null) &&
		   (pfathersKey != "" || 	pfathersKey != null) &&
		   (pgender != "" || pfathersKey != null) &&
		   (pmothersKey != "" || pmothersKey != null) &&
		   (pname != "" || pname != null) &&
		   (pspecialKey != "" || pspecialKey != null)
		   ) {
			
			isValid = true
		} else {
			isValid = false;
		}
			
		var formData = {
			name:pname,
			dob:pdob,
			gender:pgender,
			mothersKey:	pmothersKey,
			fathersKey: pfathersKey,
			specialKey:	pspecialKey,
		};
		
		if (isValid){
			
			
			$.ajax({
				type: "POST",
				contentType : "application/json",
				url: "saveUrl",
				data: formData,
// 				dataType:'json',
				success : function(result){
					
					alert("Back from server");
					alert(data);
					console.log(result); 
				}, error: function(e){ 
					alert("something went wrong");
					console.log("ERROR: " + e); 
			}
			
			});
			
		}
		
		
	});
	
	
    
});

</script>

</body>
</html>