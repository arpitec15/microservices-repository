<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Raise New Ticket</h1>
       <form:form method="post" action="save">  
      	<table >  
      	 <tr>  
          <td>User ID : </td> 
          <td><form:input path="user_id"  /></td>
         </tr>
         <tr>  
          <td>User Name : </td> 
          <td><form:input path="user_name"  /></td>
         </tr>  
         <%-- <tr>  
          <td>Ticket ID :</td>  
          <td><form:input path="ticket_id" /></td>
         </tr>  --%>
         <tr>  
          <td>Ticket Description :</td>  
          <td><form:input path="ticket_desc" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
