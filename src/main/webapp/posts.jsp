<%@ page import="models.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.PostDAO" %><%--
  Created by IntelliJ IDEA.
  User: adilb
  Date: 27.01.2021
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Post> posts = PostDAO.getInstance().getAllPosts();
    for (Post p:
            posts) {
%>
<div>
    <a class="h4" href="post?id=<%=p.getId()%>"><%=p.getTitle()%></a>

    <p><%=p.getContent()%></p>
</div>
<% if (p.getIsComment() == 1) {%>
<form action="${pageContext.request.contextPath}/CommentServlet" method="post">
    Add comment: <input type="text" name="comment" size="10"><br/>
    <input type="text" name="id" value="<%=p.getId()%>" style="display: none">
    <input type="submit" value="send">
</form>
<h4>Comments:</h4>
<ul>
    <% for (String s:
            PostDAO.getInstance().getComment(p.getId())) {
    %>
    <li><%=s%></li>
    <%
        } %>
</ul>
<%}%>
<%
    }
%>

