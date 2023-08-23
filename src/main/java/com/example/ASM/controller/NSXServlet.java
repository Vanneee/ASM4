package com.example.ASM.controller;

import com.example.ASM.entity.NSX;
import com.example.ASM.service.NSXService;
import com.example.ASM.service.impl.NSXServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        
        "/nha-san-xuat/hien-thi",
        "/nha-san-xuat/add",
        "/nha-san-xuat/remove",
        "/nha-san-xuat/detail",
        "/nha-san-xuat/view-update",
        "/nha-san-xuat/update"
})
public class NSXServlet extends HttpServlet {

    private List<NSX> list = new ArrayList<>();
    private final NSXService services = new NSXServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.viewDetail(request, response);
        } else if (uri.contains("remove")) {
            this.viewRemove(request, response);
        } else {
            this.viewUpdate(request, response);
        } 
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NSX nsx = services.getOne(UUID.fromString(id));
        request.setAttribute("update", nsx);
        request.getRequestDispatcher("/views/nha-san-xuat/view-update.jsp").forward(request, response);
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NSX nhaSanXuat = services.getOne(UUID.fromString(id));
        services.delete(nhaSanXuat);
        this.hienThi(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NSX nhaSanXuat = services.getOne(UUID.fromString(id));
        request.setAttribute("detail", nhaSanXuat);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = services.getAll();
        request.setAttribute("lists", list);
        request.getRequestDispatcher("/views/nha-san-xuat/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.htAdd(request, response);
       
        } else {
            this.htUpdate(request, response);
        }
    }

    private void htUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NSX nsx = new NSX(UUID.fromString(id), ma, ten);
        services.update(nsx);
        this.hienThi(request, response);
    }

    private void htAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        NSX nsx = new NSX(ma, ten);
        services.update(nsx);
        this.hienThi(request, response);
    }
}
