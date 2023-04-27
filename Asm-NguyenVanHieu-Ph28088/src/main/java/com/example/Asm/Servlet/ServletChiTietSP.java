package com.example.Asm.Servlet;


import com.example.Asm.Entity.DongSanPham;
import com.example.Asm.Entity.MauSac;
import com.example.Asm.Entity.NSX;
import com.example.Asm.Entity.SanPham;
import com.example.Asm.Entity.chiTietSanPham;
import com.example.Asm.Repository.ChiTietSanPhamRepository;
import com.example.Asm.Repository.DongSanPhamRepository;
import com.example.Asm.Repository.MauSacRepository;
import com.example.Asm.Repository.NSXRepository;
import com.example.Asm.Repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletChiTietSP", value = {"/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/detail"
})
public class ServletChiTietSP extends HttpServlet {
    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    NSXRepository nsxRepository = new NSXRepository();
    DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();
    MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<SanPham> listSP = sanPhamRepository.getAll();
            request.setAttribute("listSP", listSP);
            List<NSX> listNSX = nsxRepository.getAll();
            request.setAttribute("listNSX", listNSX);
            List<DongSanPham> listDSP = dongSanPhamRepository.getAll();
            request.setAttribute("listDSP", listDSP);
            List<MauSac> listMS = mauSacRepository.getAll();
            request.setAttribute("listMS", listMS);
            List<chiTietSanPham> list = chiTietSanPhamRepository.getAll();
            request.setAttribute("listCTSP", list);
            request.getRequestDispatcher("/chiTietSP/chiTietSanPham.jsp").forward(request, response);
        } else if (uri.contains("detail")) {
            String id = request.getParameter("id");
            chiTietSanPham ctsp = chiTietSanPhamRepository.getById(id);
//            List<SanPham> listSP = sanPhamRepository.getAll();
//            request.setAttribute("listSP", listSP);
//            List<NSX> listNSX = nsxRepository.getAll();
//            request.setAttribute("listNSX", listNSX);
//            List<DongSanPham> listDSP = dongSanPhamRepository.getAll();
//            request.setAttribute("listDSP", listDSP);
//            List<MauSac> listMS = mauSacRepository.getAll();
//            request.setAttribute("listMS", listMS);
            request.setAttribute("ctsp", ctsp);
            request.getRequestDispatcher("/chiTietSP/detail.jsp").forward(request, response);
        } else if (uri.contains("delete")) {
            String id = request.getParameter("id");
            chiTietSanPham ctsp = new chiTietSanPham();
            ctsp = chiTietSanPhamRepository.getById(id);
            chiTietSanPhamRepository.delete(ctsp);
            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/add")) {
            String tenSP = request.getParameter("tenSP");
            String tenMS = request.getParameter("tenMauSac");
            String tenNSX = request.getParameter("tenNSX");
            String tenDSP = request.getParameter("tenDSP");
            SanPham sp = sanPhamRepository.getByTen(tenSP);
            MauSac ms = mauSacRepository.getByTen(tenMS);
            DongSanPham dSP = dongSanPhamRepository.getByTen(tenDSP);
            NSX nsx = nsxRepository.getByTen(tenNSX);
            String namBH = request.getParameter("namBH");
            String moTa = request.getParameter("moTa");
            String soLuongTon = request.getParameter("soLuongTon");
            String giaNhap = (request.getParameter("giaNhap"));
            String giaBan = (request.getParameter("giaBan"));

            chiTietSanPham ctsp = new chiTietSanPham();
            List<SanPham> listSP = sanPhamRepository.getAll();
            request.setAttribute("listSP", listSP);
            ctsp.setSanPham(sp);
            ctsp.setDongSP(dSP);
            ctsp.setMauSac(ms);
            ctsp.setnSX(nsx);
            ctsp.setNamBH(Integer.parseInt(namBH));
            ctsp.setMoTa(moTa);
            ctsp.setSoLuongTon(Integer.parseInt(soLuongTon));
            ctsp.setGiaNhap(Float.parseFloat(giaNhap));
            ctsp.setGiaBan(Float.parseFloat(giaBan));
            chiTietSanPhamRepository.add(ctsp);
            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        } else if (uri.contains("/update")) {
            String id = request.getParameter("id");
            String tenSP = request.getParameter("tenSP");
            String tenMS = request.getParameter("tenMauSac");
            String tenNSX = request.getParameter("tenNSX");
            String tenDSP = request.getParameter("tenDSP");

            Integer namBH = Integer.parseInt(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
            Float giaNhap = Float.parseFloat(request.getParameter("giaNhap"));
            Float giaBan = Float.parseFloat(request.getParameter("giaBan"));

            chiTietSanPham ctsp = new chiTietSanPham();
            ctsp = chiTietSanPhamRepository.getById(id);
            SanPham sp = sanPhamRepository.getByTen(tenSP);
            MauSac ms = mauSacRepository.getByTen(tenMS);
            DongSanPham dSP = dongSanPhamRepository.getByTen(tenDSP);
            NSX nsx = nsxRepository.getByTen(tenNSX);
            ctsp.setSanPham(sp);
            ctsp.setDongSP(dSP);
            ctsp.setMauSac(ms);
            ctsp.setnSX(nsx);
            ctsp.setNamBH(namBH);
            ctsp.setMoTa(moTa);
            ctsp.setSoLuongTon(soLuongTon);
            ctsp.setGiaNhap(giaNhap);
            ctsp.setGiaBan(giaBan);
            chiTietSanPhamRepository.update(ctsp);
            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
        }
    }
}
