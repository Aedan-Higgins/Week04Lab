<%-- 
    Document   : shownote
    Created on : Oct 4, 2020, 5:39:55 PM
    Author     : 789648
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week04Lab</title>
    </head>
    <body>
        <h1>Awful Notekeeper</h1><br>
        <b><p>View Mode</p></b>
        <p><b>Title:</b> ${sessionScope.note.title} </p>
        <p><b>Note:</b> 
        ${sessionScope.note.msg}
        </p>
        <a href="./note?edit">Edit</a>
    </body>
</html>
