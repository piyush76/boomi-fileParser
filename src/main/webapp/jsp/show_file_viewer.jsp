<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
    <head>
    </head>
     <body>
	   File uploaded to : <%= request.getAttribute("uploadedFilePath") %>
	<br/><br/>
    </body>

	<table BORDER="1">
	<th>Date</th>
	<th>Value</th>
	<th>Description</th>
		<c:forEach items="${datalist}" var="valueObj">
			<tr>
				<td> <c:out value="${valueObj.parsedDateWithTimeZone}"/> </td>
				<td> <c:out value="${valueObj.amountInDollers}"/></td>
				<td> <c:out value="${valueObj.description}"/> </td>		
			</tr>
		</c:forEach>
	</table>	
</html>
