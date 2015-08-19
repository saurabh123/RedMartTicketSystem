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
   
<script src="${baseurl}js/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-resource.min.js"></script>
<script src="${baseurl}js/app.js"></script>      


</head>
<body ng-app="myApp">

 <div id="wrapper" ng-controller="TicketController" ng-init="getTickets()">
  
<table cellspacing='0' ng-cloak>

	<!-- Table Header -->
	<thead>
	<tr>
	<h1>Ticket List</h1>
  
	</tr>
		<tr>
			<th>Task ID</th>
			<th>Task Area</th>
			<th>Task Description</th>
			<th>Status</th>
			<th>edit</th> 
		</tr>
	</thead>
	<!-- Table Header -->

	<!-- Table Body -->
	<tbody>

			
		<tr class="even" ng-repeat='ticket in tickets' ng-cloak>
			<td>{{ticket.id}}</td>
			<td>{{ticket.area}}</td>
			<td>{{ticket.description}}</td>
			<td>{{ticket.ticket_status.status_value}}</td>
			<td><a ng-href="" ng-click="isEditable($index)" >Edit</a></td>
		</tr>

	</tbody>
	<!-- Table Body -->

</table>
</div>
   <input id="baseurl" name="baseurl" type="hidden" value="${baseurl}">
   
  <form id="edit-ticket" action="${baseurl}editticket" method="post" target="_blank">
  <input id="ticketid" name="ticketid" type="hidden" value="default"> 
</form>
    
    	
</body>
</html>