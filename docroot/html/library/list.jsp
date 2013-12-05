<%@ include file="/html/library/init.jsp" %>
<h1>List of books in our Library</h1>
<%@page import="java.util.*"%>
<%@page import="com.service.service.LMSBookLocalServiceUtil"%>
<%@page import="com.service.model.LMSBook"%>


<%
int count = LMSBookLocalServiceUtil.getLMSBooksCount();
List<LMSBook> books =
LMSBookLocalServiceUtil.getLMSBooks(0, count);
%>
<table border="1" width="80%">
<tr>
<th>Book Title</th>
<th>Author</th>

<th>Date Added</th>
</tr>
<%
for (LMSBook book : books) {
%>
<tr>
<td><%= book.getBookTitle() %></td>
<td><%= book.getAuthor() %></td>
<td><%= book.getDateAdded() %></td>
</tr>
<%
}
%>
</table>
<br/><a href="<portlet:renderURL/>">&laquo; Go Back</a>