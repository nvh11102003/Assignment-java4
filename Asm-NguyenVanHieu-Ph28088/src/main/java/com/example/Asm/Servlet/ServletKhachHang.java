package com.example.Asm.Servlet;

import com.example.Asm.Entity.KhachHang;
import com.example.Asm.Repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.UUID;


@WebServlet(name = "ServletKhachHang", value = {"/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/update",
        "/khach-hang/delete",
})
public class ServletKhachHang extends HttpServlet {
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            ArrayList<KhachHang> list = khachHangRepository.getAll();
            request.setAttribute("listKH", list);
            request.getRequestDispatcher("/KhachHang/khachHang.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = khachHangRepository.getById(id);
            request.setAttribute("khachHang", khachHang);
            System.out.println(khachHang.getNgaySinh());
            String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/KhachHang/khachHangdetail.jsp").forward(request, response);
        }else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang khachHang = new KhachHang();
            khachHang = khachHangRepository.getById(id);
            khachHangRepository.delete(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
               ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.add(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }else if(uri.contains("/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("quocGia");
            String matKhau = request.getParameter("matKhau");
            String ho = request.getParameter("ho");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            KhachHang khachHang = new KhachHang();
            khachHang = khachHangRepository.getById(id);
            khachHang.setMa(ma);
            khachHang.setTen(ten);
            khachHang.setHo(ho);
            khachHang.setTenDem(tenDem);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setSdt(sdt);
            khachHang.setDiaChi(diaChi);
            khachHang.setThanhPho(thanhPho);
            khachHang.setQuocGia(quocGia);
            khachHang.setMatKhau(matKhau);
            khachHangRepository.update(khachHang);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
