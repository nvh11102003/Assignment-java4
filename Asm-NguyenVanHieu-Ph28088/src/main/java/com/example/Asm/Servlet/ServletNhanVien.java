package com.example.Asm.Servlet;

import com.example.Asm.Entity.ChucVu;
import com.example.Asm.Entity.CuaHang;
import com.example.Asm.Entity.NhanVien;
import com.example.Asm.Repository.ChucVuRepository;
import com.example.Asm.Repository.CuaHangRepository;
import com.example.Asm.Repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ServletNhanVien", value = {"/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/add",
        "/nhan-vien/delete"

})
public class ServletNhanVien extends HttpServlet {
    CuaHangRepository cuaHangRepository = new CuaHangRepository();
    ChucVuRepository chucVuRepository = new ChucVuRepository();
    NhanVienRepository nhanVienRepository = new NhanVienRepository();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<CuaHang> listCH = cuaHangRepository.getAll();
            request.setAttribute("listCH",listCH);
            List<ChucVu> listCV = chucVuRepository.getAll();
            request.setAttribute("listCV",listCV);
            ArrayList<NhanVien> list = nhanVienRepository.getAll();
            request.setAttribute("listNV", list);
            request.getRequestDispatcher("/NhanVien/nhanVien.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            String id = request.getParameter("id");
            NhanVien nhanVien = nhanVienRepository.getById(id);
            request.setAttribute("nhanVien",nhanVien);
            List<CuaHang> listCH = cuaHangRepository.getAll();
            request.setAttribute("listCH",listCH);
            List<ChucVu> listCV = chucVuRepository.getAll();
            request.setAttribute("listCV",listCV);
            System.out.println(nhanVien.getNgaySinh());
            String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.getRequestDispatcher("/NhanVien/nhanViendetail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            NhanVien nhanVien;
            nhanVien = nhanVienRepository.getById(id);
            nhanVienRepository.delete(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String tenCH = request.getParameter("tenCH");
            String tenCV = request.getParameter("tenCV");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            String matKhau = request.getParameter("matkhau");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            NhanVien nhanVien = new NhanVien();
            CuaHang cuaHang =cuaHangRepository.getByTen(tenCH);
            ChucVu chucVu =chucVuRepository.getByTen(tenCV);

            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setHo(ho);
            nhanVien.setTenDem(tenDem);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setSdt(sdt);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setTrangThai(trangThai);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setMatkhau(matKhau);
            nhanVienRepository.add(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String tenCH = request.getParameter("tenCH");
            String tenCV = request.getParameter("tenCV");
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            String matKhau = request.getParameter("matkhau");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            Integer trangThai = Integer.parseInt(request.getParameter("trangThai"));
            NhanVien nhanVien = new NhanVien();
            CuaHang cuaHang =cuaHangRepository.getByTen(tenCH);
            ChucVu chucVu =chucVuRepository.getByTen(tenCV);

            nhanVien = nhanVienRepository.getById(id);
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setHo(ho);
            nhanVien.setTenDem(tenDem);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setSdt(sdt);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setTrangThai(trangThai);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setMatkhau(matKhau);
            nhanVienRepository.update(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
