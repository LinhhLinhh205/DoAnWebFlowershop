<%-- 
    Document   : login
    Created on : Oct 31, 2024, 3:02:21 PM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--nhung noi dung header.jsp-->
<jsp:include page="shared/header.jsp" />
<!--nhung noi dung nav.jsp-->
<jsp:include page="shared/nav.jsp" />
<div class="container">
    <form action="LoginServlet" method="post">
        <h1>Login System</h1>
        <div>
            <label>User name</label>
            <input type="text" name="username" required="" class="form-control"/>
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password" required="" class="form-control"/>
        </div>
        <div class="mt-2">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
        <%
            if (request.getAttribute("error") != null) {
        %>
        <div class="text-danger">
            <%=request.getAttribute("error")%>
        </div>
        <% }%>


    </form>
</div>





<jsp:include page="shared/footer.jsp" />   