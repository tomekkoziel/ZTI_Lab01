<%--
  Created by IntelliJ IDEA.
  User: 0jedrychowski
  Date: 3/5/24
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP and JavaBean</title>
</head>
<body>

<jsp:useBean id="dateBean" scope="request" class="zti_lab.beans.DateBean" />
<h1>Odczyt danych z JavaBean</h1>
<br />
<p>Dzisiaj jest: ${dateBean.currentDate} !</p>

</body>
</html>
