package com.example.ASM.controller;

import com.example.ASM.entity.MauSac;
import com.example.ASM.service.MauSacService;
import com.example.ASM.service.impl.MauSacServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/update",
        "/mau-sac/add",
        "/mau-sac/view-update",
        "/mau-sac/detail",
        "/mau-sac/remove",
})
public class MauSacServlet extends HttpServlet {

;    private MauSacService service = new MauSacServiceImpl();
    private List<MauSac> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiMauSac(request,response);
        }else if (uri.contains("remove")) {
            this.removeMauSac(request,response);
        }else if (uri.contains("detail")) {
            this.detailMauSac(request,response);
        }else {
            this.viewUpdateMauSac(request,response);
        }
    }

    private void viewUpdateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        MauSac mauSac = service.getOne(UUID.fromString(id));
        request.setAttribute("update",mauSac);
        request.getRequestDispatcher("/views/mau-sac/update.jsp").forward(request,response);
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        MauSac mauSac = service.getOne(UUID.fromString(id));
        request.setAttribute("detail",mauSac);
        this.hienThiMauSac(request,response);
    }

    private void removeMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        MauSac mauSac = service.getOne(UUID.fromString(id));
        service.delete(mauSac);
        this.hienThiMauSac(request,response);
    }

    private void hienThiMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("lists",list);
        request.getRequestDispatcher("/views/mau-sac/hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addMauSac(request,response);
        }else {
            this.updateMauSac(request,response);
        }
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        MauSac mauSac = new  MauSac(UUID.fromString(id),ma,ten);
        service.update(mauSac);
        this.hienThiMauSac(request,response);
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        MauSac mauSac = new  MauSac(ma,ten);
        service.add(mauSac);
        this.hienThiMauSac(request,response);
    }
}
