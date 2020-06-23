<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Ticket</h1>
       <%-- <form:form method="POST" action="/SpringMVCCRUDSimple/editsave"> --%>
       <form:form method="POST" action="/editsave">    
		<table >  
      	 <tr>  
          <td>User ID : </td> 
          <td><form:input path="user_id" readonly="true"  /></td>
         </tr>
         <tr>  
          <td>User Name : </td> 
          <td><form:input path="user_name" readonly="true"  /></td>
         </tr>  
         <tr>  
          <td>Ticket ID :</td>  
          <td><form:input path="ticket_id" readonly="true" /></td>
         </tr> 
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
