<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<spring:url value="/" var="baseurl" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>RedMart-TicketLog</title>
<link href="${baseurl}css/css.css" rel="stylesheet">

</head>
<body>

<form>
<ul class="form-style-1">
	<li id="message" style="display:none" class="required">
	  Ticket Successfully Logged.
	</li>
   <li>
        <label>Ticket Area:<span class="required">*</span></label>
         <select name="field9" class="field-select" id="area">
        <option value="General Query">General Query</option>
        <option value="Delivery Status">Delivery Status </option>
        <option value="Product Information">Product Information</option>
         <option value="Return Related Query">Return Related Query</option>
        <option value="Defective Product">Defective Product</option>        
        </select>
    </li>  
    <li><label>Customer Information:<span class="required">*</span></label>
    <input type="text" name="field1" id="firstname" class="field-divided" placeholder="First name" />&nbsp;
    <input type="text" name="field2" id="lastname" class="field-divided" placeholder="Last name" />
    </li>
    <li>
        <input type="email" name="field3" id="emailid" class="field-divided" placeholder="Email" />&nbsp;
        
    </li>   
    <li>
        <label>Problem Description<span class="required">*</span></label>
        <textarea id="description" name="field5" id="field5" class="field-long field-textarea"></textarea>
    </li>
    <li>
        <input type="button" onclick="logTicket()" value="Log Ticket"/>
    </li>
</ul>
</form>
   <input id="showmessage" name="showmessage" type="hidden" value="${showMessage}">

    <script src="${baseurl}js/jquery.min.js"></script>
<script>

var showmessage = 	$('#showmessage').val();
var message = $(document.getElementById("message"));

if(showmessage=='true')
	message.css("display","");

	
function logTicket()
{
	var data = {};
    
	data.area = $('#area').val();
	data.description = $('#description').val();
	data.customer={};
	data.customer.firstName = $('#firstname').val();
	data.customer.lastName = $('#lastname').val();
	data.customer.emailid = $('#emailid').val();

	$.ajax({
		   url: '${baseurl}createticket',
		   data: JSON.stringify(data),
		   contentType: 'application/json',
		   error: function() {
		     alert("An error occured");
		   },
		   success: function(data) {
			   if(data=='success')
				   {
				  
				  window.location.href = '${baseurl}newticket?showMessage=true';

	    		   }
			   else
				   {
					alert("Server Error occured");
				   }
		   },
		   type: 'POST'
		});
	
	
	}

</script>

</body>
</html>