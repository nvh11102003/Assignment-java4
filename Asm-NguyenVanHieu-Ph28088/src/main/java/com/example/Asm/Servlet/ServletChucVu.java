package com.example.Asm.Servlet;

import com.example.Asm.Entity.ChucVu;
import com.example.Asm.Entity.chiTietSanPham;
import com.example.Asm.Repository.ChiTietSanPhamRepository;
import com.example.Asm.Repository.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletChucVu", value = {"/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/detail",
        "/chuc-vu/delete",
        "/chuc-vu/update",
})
public class ServletChucVu extends HttpServlet {
    ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<ChucVu> list = chucVuRepository.getAll();
            request.setAttribute("listCV", list);
            request.getRequestDispatcher("/ChucVu/chucVu.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            String id = request.getParameter("id");
            ChucVu chucVu = chucVuRepository.getById(id);
            request.setAttribute("chucVu",chucVu);
            request.getRequestDispatcher("/ChucVu/chucVudetail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            ChucVu chucVu = new ChucVu();
            chucVu = chucVuRepository.getById(id);
            chucVuRepository.delete(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("maCV");
            String ten = request.getParameter("tenCV");
            ChucVu chucVu = new ChucVu(ma, ten);
            chucVuRepository.add(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("maCV");
            String ten = request.getParameter("tenCV");
            ChucVu chucVu = new ChucVu();
            chucVu = chucVuRepository.getById(id);
            chucVu.setMaCV(ma);
            chucVu.setTenCV(ten);
            chucVuRepository.update(chucVu);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
