package com.example.Asm.Servlet;

import com.example.Asm.Entity.CuaHang;
import com.example.Asm.Repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCuaHang", value = {"/cua-hang/hien-thi",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/detail",
        "/cua-hang/delete"
})
public class ServletCuaHang extends HttpServlet {
    CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<CuaHang> list = cuaHangRepository.getAll();
            request.setAttribute("listCH", list);
            request.getRequestDispatcher("/CuaHang/cuaHang.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("cuaHang", cuaHang);
            request.getRequestDispatcher("/CuaHang/cuaHangdetail.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            CuaHang cuaHang = new CuaHang();
            cuaHang = cuaHangRepository.getById(id);
            cuaHangRepository.delete(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            String ma = request.getParameter("maCH");
            String tenCH = request.getParameter("tenCH");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang(ma, tenCH, diaChi, thanhPho, quocGia);
            cuaHangRepository.add(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        } else if (uri.contains("update")) {
            String id = request.getParameter("id");
            String ma = request.getParameter("maCH");
            String tenCH = request.getParameter("tenCH");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            CuaHang cuaHang = new CuaHang();
            cuaHang = cuaHangRepository.getById(id);
            cuaHang.setMaCH(ma);
            cuaHang.setTenCH(tenCH);
            cuaHang.setDiaChi(diaChi);
            cuaHang.setThanhPho(thanhPho);
            cuaHang.setQuocGia(quocGia);
            cuaHangRepository.update(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        }
    }
}
