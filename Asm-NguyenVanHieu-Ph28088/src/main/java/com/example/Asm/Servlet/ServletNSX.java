package com.example.Asm.Servlet;

import com.example.Asm.Entity.DongSanPham;
import com.example.Asm.Entity.NSX;
import com.example.Asm.Entity.chiTietSanPham;
import com.example.Asm.Repository.ChiTietSanPhamRepository;
import com.example.Asm.Repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletNSX", value = {"/nsx/hien-thi",
        "/nsx/detail",
        "/nsx/add",
        "/nsx/delete",
        "/nsx/update"
})
public class ServletNSX extends HttpServlet {
    NSXRepository nsxRepository = new NSXRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<NSX> list = nsxRepository.getAll();
            request.setAttribute("listNSX", list);
            request.getRequestDispatcher("/NSX/nSx.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            String id = request.getParameter("id");
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("nsx",nsx);
            request.getRequestDispatcher("/NSX/nSXdetail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            NSX nsx;
            nsx = nsxRepository.getById(id);
            nsxRepository.delete(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("maNSX");
            String ten = request.getParameter("tenNSX");
            NSX nsx = new NSX(ma,ten);
            nsxRepository.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("maNSX");
            String ten = request.getParameter("tenNSX");
            NSX nsx = new NSX();
            nsx = nsxRepository.getById(id);
            nsx.setMaNSX(ma);
            nsx.setTenNSX(ten);
            nsxRepository.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
