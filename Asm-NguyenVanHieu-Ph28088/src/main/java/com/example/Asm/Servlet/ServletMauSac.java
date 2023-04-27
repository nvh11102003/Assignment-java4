package com.example.Asm.Servlet;

import com.example.Asm.Entity.MauSac;
import com.example.Asm.Repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletMauSac", value ={ "/mau-sac/hien-thi",
        "/mau-sac/detail",
        "/mau-sac/add",
        "/mau-sac/update",
        "/mau-sac/delete"
})
public class ServletMauSac extends HttpServlet {
    MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            List<MauSac> list = mauSacRepository.getAll();
            request.setAttribute("listMS", list);
            request.getRequestDispatcher("/MauSac/mauSac.jsp").forward(request, response);
        }else if(uri.contains("detail")){
            String id = request.getParameter("id");
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("mauSac",mauSac);
            request.getRequestDispatcher("/MauSac/mauSacdetail.jsp").forward(request,response);
        }else if(uri.contains("delete")){
            String id = request.getParameter("id");
            MauSac mauSac = new MauSac();
            mauSac= mauSacRepository.getById(id);
            mauSacRepository.delete(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("maMauSac");
            String ten = request.getParameter("tenMauSac");
            MauSac mauSac = new MauSac(ma,ten);
            mauSacRepository.add(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }else if(uri.contains("update")){
            String id = request.getParameter("id");
            String ma = request.getParameter("maMauSac");
            String ten = request.getParameter("tenMauSac");
            MauSac mauSac = new MauSac();
            mauSac = mauSacRepository.getById(id);
            mauSac.setMaMauSac(ma);
            mauSac.setTenMauSac(ten);
            mauSacRepository.update(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
