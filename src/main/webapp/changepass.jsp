<%-- 
    Document   : changepass
    Created on : Nov 6, 2024, 10:59:35 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--nhung noi dung header.jsp-->
<jsp:include page="shared/header.jsp" />
<!--nhung noi dung nav.jsp-->
<jsp:include page="shared/nav.jsp" />
<div class="container">
    <form action="ChangePassServlet" method="POST" onsubmit="">
        <h2>Change Password</h2>
        <div>
            <label>Old Passsword:</label>
            <input type="password" name="oldpassword" required="" class="form-control"/>
        </div>
        <div>
            <label>New Passsword:</label>
            <input type="password" name="newpassword" required="" class="form-control"/>
        </div>
        <div>
            <label>Confirm New Passsword:</label>
            <input type="password" name="confirmpassword" required="" class="form-control"/>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
        <%
            if (request.getAttribute("error") != null) {
        %>
        <div class="text-danger mb-3">
            <%=request.getAttribute("error") %>
        </div>
        <%
            }
        %>
    </form>
</div>



<jsp:include page="shared/footer.jsp" />  