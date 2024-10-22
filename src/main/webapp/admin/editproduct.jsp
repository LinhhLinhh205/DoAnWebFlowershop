<%-- 
    Document   : editproduct
    Created on : Oct 22, 2024, 3:00:16 PM
    Author     : ADMIN
--%>

<%@page import="model.Loai"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.LoaiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../shared/header.jsp" />
<jsp:include page="../shared/nav.jsp" />
<%
    LoaiDAO loaiDao = new LoaiDAO();
    ArrayList<Loai> dsLoai = loaiDao.getAll();
%>
<div class="container">  
    <h2>Cập nhật sản phẩm (Hoa)</h2>    
    <form method="post">
        <div class="mb-2">
            <label>Tên hoa</label>
            <input type="text" name="tenhoa" value="" class="form-control" />
        </div>
        <div class="mb-2">
            <label>Giá</label>
            <input type="number" name="gia" value="" class="form-control" />
        </div>
        <div class="mb-2">
            <label>Hình ảnh</label>
            <input type="file" name="hinh" value="" class="form-control" />
        </div>
         <div class="mb-2">
            <label>Thể loại</label>
            <select name="maloai" class="form-control">      
                <%
                    for (Loai x : dsLoai) {
                %>
                <option value="<%=x.getMaloai()%>"><%=x.getTenloai()%></option>
                <%
                    }
                %>
            </select>
        </div>        
        <button type="submit" class="btn btn-primary">Save</button>
    </form>       
</div>
<jsp:include page="../shared/footer.jsp" />
