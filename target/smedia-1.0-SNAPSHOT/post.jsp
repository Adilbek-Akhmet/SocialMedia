<%@ page import="models.Post" %>
<%@ page import="models.Post" %><%--
  Created by IntelliJ IDEA.
  User: adilb
  Date: 27.01.2021
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Post p;
   %>
<div>
    <h3>Title: <%=p.getTitle()%></h3>
    <p><%=p.getContent()%></p>
    <% if (p.getIsComment() == 1) {%>
    <form action="${pageContext.request.contextPath}/CommentServlet" method="post">
        Add comment: <input type="text" name="comment"><br/>
        <input type="text" name="id" value="<%=p.getId()%>" style="display: none">
        <input type="submit" value="send">
    </form>
    <h4>Comments:</h4>
    <ul>
        <% for (String s:
                p.getComments()) {
        %>
        <li><%=s%></li>
        <%
            } %>
    </ul>
    <%}%>
</div>
<%} else out.print("<h2>Not Found</h2");
%>

