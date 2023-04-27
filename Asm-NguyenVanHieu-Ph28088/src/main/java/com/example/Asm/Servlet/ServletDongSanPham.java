package com.example.Asm.Servlet;


import com.example.Asm.Entity.DongSanPham;
import com.example.Asm.Repository.DongSanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDongSanPham", value = {"/DongSanPham/hien-thi",
        "/DongSanPham/detail",
        "/DongSanPham/update",
        "/DongSanPham/add",
        "/DongSanPham/delete",
})
public class ServletDongSanPham extends HttpServlet {
    private DongSanPhamRepository dongSanPhamRepository= new DongSanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<DongSanPham> listDongSanPham = dongSanPhamRepository.getAll();
            request.setAttribute("listDongSanPham",listDongSanPham);
            request.getRequestDispatcher("/dongSanPham/dongSanPham.jsp").forward(request,response);
        }else if(uri.contains("detail")){
            String id = request.getParameter("id");
            DongSanPham dongSanPham = dongSanPhamRepository.getById(id);
            request.setAttribute("dongSanPham",dongSanPham);
            request.getRequestDispatcher("/dongSanPham/dongSanPhamdetail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            DongSanPham dongSanPham;
            dongSanPham = dongSanPhamRepository.getById(id);
            dongSanPhamRepository.delete(dongSanPham);
            response.sendRedirect("/DongSanPham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("maDSP");
            String ten = request.getParameter("tenDSP");
            DongSanPham dongSanPham = new DongSanPham(ma,ten);
            dongSanPhamRepository.add(dongSanPham);
            response.sendRedirect("/DongSanPham/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("maDSP");
            String ten = request.getParameter("tenDSP");
            DongSanPham dongSanPham = new DongSanPham();
            dongSanPham = dongSanPhamRepository.getById(id);
            dongSanPham.setMaDSP(ma);
            dongSanPham.setTenDSP(ten);
            dongSanPhamRepository.update(dongSanPham);
            response.sendRedirect("/DongSanPham/hien-thi");
        }
    }
}
