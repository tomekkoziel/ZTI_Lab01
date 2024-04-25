<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE HTML >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP JSTL XML</title>
</head>
<body>
<h1>JSP - Read xml file with JSTL</h1>
<!-- Wpisać poprawny URL do pliku data.xml -->
<c:import var="file" url="http://localhost:8085/ZTI_Lab01_war_exploded/Data/data.xml" charEncoding="UTF-8" />
<!--c:out value="${file}" /-->
<x:parse var="doc" doc="${file}"  />

<table >
    <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Grade</th>
        <th>Type</th>
    </tr>
    <x:forEach select="$doc/students/student">
        <tr>
            <td><x:out select="data/fname" /></td>
            <td><x:out select="data/lname" /></td>
            <td><x:out select="results/grade" /></td>
            <td><x:out select="results/type" /></td>
        </tr>
    </x:forEach>
</table>

</body>
</html>