<%-- 
    Document   : login
    Created on : Sep 27, 2018, 12:25:56 PM
    Author     : 758243
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="loginTag" tagdir="/WEB-INF/tags/"%>
        <%@taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld"%>
        
        <title>Login</title>
    </head>
    <body>
        <sait:debug>
	Remote Host: ${pageContext.request.remoteHost}<br />
	Session ID: ${pageContext.session.id}
        </sait:debug>
        <loginTag:login action="login" method="post"></loginTag:login>
    </body>
</html>
