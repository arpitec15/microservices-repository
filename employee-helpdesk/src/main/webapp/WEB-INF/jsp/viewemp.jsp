    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Tickets</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>User_Id</th><th>Name</th><th>Ticket ID</th><th>Ticket Description</th><th>Update</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.user_id}</td>
    <td>${emp.user_name}</td>
    <td>${emp.ticket_id}</td>
    <td>${emp.ticket_desc}</td>
    <td><a href="editemp/${emp.ticket_id}">Edit</a></td>
    <td><a href="deleteemp/${emp.ticket_id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="empform">Raise New Ticket Request</a>