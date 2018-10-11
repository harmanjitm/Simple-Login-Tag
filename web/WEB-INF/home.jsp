<%-- 
    Document   : home
    Created on : Sep 27, 2018, 12:59:24 PM
    Author     : 758243
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld"%>
        <title>Home Page</title>
    </head>
    <body>
        <sait:debug>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait:debug>
        <h1>Home Page</h1>
        <h3>Hello ${userName}</h3>
        <a href="home?logout">Log out</a>
    </body>
</html>
