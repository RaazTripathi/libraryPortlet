<%@ include file="/html/library/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>

<portlet:renderURL var="updateBookURL">
<portlet:param name="jspPage" value="/html/library/update.jsp"/>
</portlet:renderURL>

<br/><a href="<%= updateBookURL %>">Add new Book &raquo;</a>
<a href="<portlet:renderURL/>">&laquo; Go Back</a>
<%
PortletURL listBooksURL = renderResponse.createRenderURL();
listBooksURL.setParameter("jspPage", "/html/library/list.jsp");
%>
<a href="<%= listBooksURL.toString() %>">Show all books &raquo;</a>