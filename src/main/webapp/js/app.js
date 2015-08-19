var myApp = angular.module('myApp', []);

myApp.controller('TicketController', function($scope,$http) {

	var baseurl = $('#baseurl').val();
    
	      
	
	$scope.getTickets = function()
	{
	$http({method: 'GET', url: baseurl+'tickets.json'}).
          success(function(data, status, headers, config) {
              $scope.tickets = data;
          }).
          error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
	} 
	      $scope.isEditable = function(index)
	      {
	    	  var ticket = $scope.tickets[index];
	    	  
	    	  if(ticket.ticket_status.status_code==3)
	    		  alert("You can't edit closed ticket.")
	          else
	        	  {
	    	 		$('#ticketid').val(ticket.id);
					$('#edit-ticket').submit();
	        	  }
	      }
	      
	      
	
	$scope.viewTicket = function ()
	{
		var ticketid = $('#ticketid').val();
		$http({method: 'GET', url: baseurl+'ticket/'+ticketid}).
        success(function(data, status, headers, config) {
            $scope.ticket = data;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        });
		
		var employeeData =[];
		$http({method: 'GET', url: baseurl+'getemployee'}).
        success(function(data, status, headers, config) {
            for (var i = 0; i < data.length; i++) {
   		        employeeData.push(data[i]);
   		      }
                 $scope.employee = employeeData;
        }).
        error(function(data, status, headers, config) {
          // called asynchronously if an error occurs
          // or server returns response with an error status.
        });
		
		
	}
	
	$scope.updateTicket = function(action)
	{
		var ticketid = $('#ticketid').val();
		
		if(action=='assign')
			{
			$http({
			    method: 'POST',
			    url: baseurl+'ticket/update/'+ticketid,
			    data: $.param({ 'status': 2 ,'assignto' :$("#assignTo").select2("val")}),
			    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function(result) {
			      window.location.replace(baseurl+'listticket');
			  }).error(function() {
			      console.log("error");
			  });
					
			}
		else if(action=='status')
		{
			$http({
			    method: 'POST',
			    url: baseurl+'ticket/update/'+ticketid,
			    data: $.param({'status': 3}),
			    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function(result) {
			      window.location.replace(baseurl+'listticket');
			  }).error(function() {
			      console.log("error");
			  });
		
		}
	}
	
	$scope.postComment = function ()
	{
			var ticketid = $('#ticketid').val();
		
			$http({
			    method: 'POST',
			    url: baseurl+'ticket/comment/'+ticketid,
			    data: $.param({'comment' :$("#comment").val()}),
			    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
			}).success(function(result) {
				  alert("comment Successfully posted");
			      //window.location.replace(baseurl+'listticket');
			  }).error(function() {
			      console.log("error");
			  });
					
			
		
	}
});