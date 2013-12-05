<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>


<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.RenderResponse"%>
<%

RenderResponse renderResponse = (RenderResponse) request.getAttribute("javax.portlet.response");
PortletURL updateBookURL = renderResponse.createActionURL();
updateBookURL.setParameter(
ActionRequest.ACTION_NAME, "updateBook");
%>




<aui:form name="fm" method="POST" action="<%= updateBookURL.toString() %>">
<aui:input name="bookTitle" label="Book Title"/>
<aui:input name="author"/>
<aui:button type="submit" value="Save"/>
</aui:form>



