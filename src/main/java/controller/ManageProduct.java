/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDAO;
import dao.LoaiDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Hoa;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ManageProduct", urlPatterns = {"/ManageProduct"})
public class ManageProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HoaDAO hoaDoa = new HoaDAO();
        LoaiDAO loaiDao = new LoaiDAO();
        String action = "list";
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        }
        switch (action) {
            case "list":
                ArrayList<Hoa> dsHoa = hoaDoa.getAll();
                request.setAttribute("dsHoa", dsHoa);
                request.getRequestDispatcher("admin/listproduct.jsp").forward(request, response);
                break;
            case "add":
                request.setAttribute("dsLoai", loaiDao.getAll());
                request.getRequestDispatcher("admin/addproduct.jsp").forward(request, response);
                break;
            case "edit":
                int maHoa = Integer.parseInt(request.getParameter("mahoa"));
                Hoa hoa = hoaDoa.getById(maHoa);
                request.setAttribute("hoa", hoa);
                request.setAttribute("dsLoai", loaiDao.getAll());
                request.getRequestDispatcher("admin/editproduct.jsp").forward(request, response);
                break;
            case "update":
                int maHoaUpdate = Integer.parseInt(request.getParameter("mahoa"));
                String tenHoa = request.getParameter("tenhoa");
                double gia = Double.parseDouble(request.getParameter("gia"));
                String hinh = request.getParameter("hinh");
                int maLoai = Integer.parseInt(request.getParameter("maloai"));
                Hoa hoaUpdate = new Hoa(maHoaUpdate, tenHoa, gia, hinh, maLoai);
                hoaDoa.Update(hoaUpdate);
                response.sendRedirect("ManageProduct?action=list");
                break;
            case "delete":
                int maHoaDelete = Integer.parseInt(request.getParameter("mahoa"));
                hoaDoa.Delete(maHoaDelete);
                response.sendRedirect("ManageProduct?action=list");
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
