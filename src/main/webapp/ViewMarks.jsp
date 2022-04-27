
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>OES | View Exam</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>	
        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">

    <style>
        body {
    padding-top: 3.5rem;
}

nav {
    font-family: sans-serif;
}

.navbar-brand {
    font-size: 20px;
    font-family: Georgia, 'Times New Roman', Times, serif;
}
.center {
  margin-left: auto;
  margin-right: auto;
}
table {
  width: 95%;
}
    </style>

    </head>
    <body>
        <jsp:include page="TeacherNavbar.jsp" /><br/>
        <h1 style="text-align: center;">${requestScope.subject} Marks</h1><br/>

        <table border="1" class="center">
            <tr>
                <th>Serial No.</th>
                <th>Username</th>
                <th>Marks</th>
            </tr>
            <c:set var="serialno" value="0" />
            <c:forEach items="${requestScope.marks}" var="rec">
            	<c:set var="serialno" value="${serialno+1}" scope="page" />
                <tr>
                    <td><c:out value="${serialno}"/></td>
                    <td><c:out value="${rec.uname}"/></td>
                    <td><c:out value="${rec.marks}"/></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
