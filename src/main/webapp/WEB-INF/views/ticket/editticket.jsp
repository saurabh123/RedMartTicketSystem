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
<link href="${baseurl}css/select2.css" rel="stylesheet">
<script src="${baseurl}js/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-resource.min.js"></script>
<script src="${baseurl}js/app.js"></script>      
	<script src="http://cdnjs.cloudflare.com/ajax/libs/select2/3.4.8/select2.min.js"></script>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/select2/3.4.8/select2-bootstrap.css" rel="stylesheet">
	
	
	

</head>
<body ng-app="myApp">
<ul class="form-style-1" ng-controller="TicketController" ng-init="viewTicket()">
<li>
        <label class="field-divided">Ticket Id: <span >{{ticket.id}}</span></label>
         <label class="field-divided">Ticket Area:<span class="field-divided">{{ticket.area}}</span></label>
         </li>
         <li>
         <label>Ticket Description :</label>
         <label><span>{{ticket.description}}</span></label>
         </li>
        <li>
         <div class="field-divided">
             
		<select id="assignTo" >
          <option ng-repeat="item in employee"   itemValue="id" itemLabel="name" >{{item.name}}</option>
        </select>
        	
        </div>
        </br>
        <input type="button" ng-click="updateTicket('assign')" class="field-divided" value="Assign Ticket"/>
        
        </li>
        <li>
        <label>Add Comment :</label>
        <textarea id="comment" name="field5" id="field5" class="field-long field-textarea"></textarea>
    	</li>
    	<li>
        <input type="button" ng-click="postComment()" value="Add Comment"/>
      </li>
       <li>
        <input type="button" style="background:red" ng-click="updateTicket('status')" class="field-divided" value="Close Ticket"/>
        
        </li>
       
         </ul>
    <input id="ticketid" name="ticketid" type="hidden" value="${ticketid}"> 
       <input id="baseurl" name="baseurl" type="hidden" value="${baseurl}">
 
<script>

$(document).ready(function(){

$("#assignTo").select2({
	
});
});
</script>         
</body>
</html>