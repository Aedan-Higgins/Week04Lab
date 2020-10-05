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
        <form action="note" method="post">
            <h1>Awful Notekeeper</h1><br>
            <b><p>Edit Mode</p></b>
            <p><b>Title:</b> <input name="title" type="text" value="${sessionScope.note.title}"/> </p>
            <p><b>Note:</b> <textarea name="val">${sessionScope.note.msg}</textarea>
            </p>
            <input value="submit" type="submit">
        </form>
    </body>
</html>
