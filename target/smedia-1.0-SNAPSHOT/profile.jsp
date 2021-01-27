<%@ page import="models.User" %>
<%@ page import="models.Post" %>
<%@ page import="models.Profile" %><%--
  Created by IntelliJ IDEA.
  User: adilb
  Date: 27.01.2021
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Profile p = (Profile) request.getAttribute("profile");
    if (p != null) {%>
<div>
    <h3>Username: <%=p.getUsername()%></h3>
    <form action="${pageContext.request.contextPath}/SendReqServlet" method="get">
        <input type="submit" value="send request">
    </form>

    <h4>Posts:</h4>

    <% if (p.getVisible() == 0 || ((User)session.getAttribute("user")).getUsername().equals(p.getUsername()) || (p.getVisibility() == 1 && request.getSession().getAttribute("user") != null)
            || ((Boolean)request.getAttribute("friendship"))) for (Post post:
            p.getPosts()) {
    %>
    <div>
        <a class="h4" href="post?id=<%=post.getId()%>"><%=post.getTitle()%></a>

        <p><%=post.getContent()%></p>
    </div>
    <%
            } else out.print("<div>Not Found or Inaccessible</div>");
    %>
</div>
<%} else out.print("<h2>Not Found</h2");
%>
