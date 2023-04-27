package com.example.Asm.Servlet;


import com.example.Asm.Entity.DongSanPham;
import com.example.Asm.Entity.SanPham;
import com.example.Asm.Repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletSanPham", value = {"/Sanpham/hien-thi",
        "/Sanpham/detail",
        "/Sanpham/update",
        "/Sanpham/add",
        "/Sanpham/delete"
})
public class ServletSanPham extends HttpServlet {
    private SanPhamRepository sanPhamRepository= new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<SanPham> listSP = sanPhamRepository.getAll();
//            System.out.println(listSP.toString());
            request.setAttribute("listSP",listSP);
            request.getRequestDispatcher("/SanPham/sanPham.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            String id = request.getParameter("id");
            SanPham sanPham = sanPhamRepository.getById(id);
            request.setAttribute("sanPham",sanPham);
            request.getRequestDispatcher("/SanPham/sanPhamdetail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            SanPham sanPham;
            sanPham = sanPhamRepository.getById(id);
            sanPhamRepository.delete(sanPham);
            response.sendRedirect("/Sanpham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("maSP");
            String ten = request.getParameter("tenSP");
            SanPham sanPham = new SanPham(ma,ten);
            sanPhamRepository.add(sanPham);
            response.sendRedirect("/Sanpham/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("maSP");
            String ten = request.getParameter("tenSP");
            SanPham sanPham = new SanPham();
            sanPham = sanPhamRepository.getById(id);
            sanPham.setMaSP(ma);
            sanPham.setTenSP(ten);
            sanPhamRepository.update(sanPham);
            response.sendRedirect("/Sanpham/hien-thi");
        }
    }
}
