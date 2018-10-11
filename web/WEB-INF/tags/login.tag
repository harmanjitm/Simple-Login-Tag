<%-- 
    Document   : login
    Created on : Oct 11, 2018, 12:27:08 PM
    Author     : 758243
--%>

<%@tag description="Display a simple login page" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="method" required="true"%>
<%@attribute name="action" required="true"%>

<%-- any content can be specified here e.g.: --%>
<h1>Remember Me Login Page</h1>
<form action="login" method="post">
    Username: <input type="text" name="userName" value="${userName}"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login"><br>
    <input type="checkbox" name="rememberMe" value="${rememberMe}" ${rememberMe}>Remember me<br>
</form>
<div>
    ${invalidLogin}
</div>