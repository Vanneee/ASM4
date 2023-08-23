package com.example.ASM.controller;

import com.example.ASM.entity.DongSanPham;
import com.example.ASM.service.DongSanPhamService;
import com.example.ASM.service.impl.DongSanPhamServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-san-pham/hien-thi",
        "/dong-san-pham/add",
        "/dong-san-pham/remove",
        "/dong-san-pham/detail",
        "/dong-san-pham/view-update",
        "/dong-san-pham/update"
})
public class DongSPServlet extends HttpServlet {

    private final DongSanPhamService service = new DongSanPhamServiceImpl();
    private List<DongSanPham> list = new ArrayList<>();

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
        DongSanPham dsp = service.getOne(UUID.fromString(id));
        request.setAttribute("update", dsp);
        request.getRequestDispatcher("/views/dong-san-pham/update.jsp").forward(request, response);    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = service.getOne(UUID.fromString(id));
        service.delete(dsp);
        this.hienThi(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham dsp = service.getOne(UUID.fromString(id));
        request.setAttribute("detail", dsp);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("lists", list);
        request.getRequestDispatcher("/views/dong-san-pham/hien-thi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.htAdd(request, response);
        } else if (uri.contains("update")) {
            this.htUpdate(request, response);
        }
    }

    private void htUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        DongSanPham dongSanPham = new DongSanPham(UUID.fromString(id), ma, ten);
        service.update(dongSanPham);
        this.hienThi(request, response);
    }

    private void htAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        DongSanPham dongSanPham = new DongSanPham(ma, ten);
        service.add(dongSanPham);
        this.hienThi(request, response);
    }
}
