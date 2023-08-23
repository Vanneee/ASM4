package com.example.ASM.controller;

import com.example.ASM.entity.SanPham;
import com.example.ASM.service.SanPhamService;
import com.example.ASM.service.impl.SanPhamServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/remove",
        "/san-pham/detail",
        "/san-pham/view-update",
        "/san-pham/update"
})
public class SanPhamServlet extends HttpServlet {
    private final SanPhamService service = new SanPhamServiceImpl();
    private List<SanPham> list = new ArrayList<>();

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
        SanPham sanPham = service.getOne(UUID.fromString(id));
        request.setAttribute("update", sanPham);
        request.getRequestDispatcher("/view/san-pham/update.jsp").forward(request, response);
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = service.getOne(UUID.fromString(id));
        service.delete(sp);
        this.hienThi(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham sp = service.getOne(UUID.fromString(id));
        request.setAttribute("detail", sp);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("lists", list);
        request.getRequestDispatcher("/views/san-pham/hien-thi.jsp").forward(request, response);
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
        SanPham sanPham = new SanPham(UUID.fromString(id), ma, ten);
        service.update(sanPham);
        this.hienThi(request, response);
    }

    private void htAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPham sanPham = new SanPham(ma, ten);
        service.add(sanPham);
        this.hienThi(request, response);
    }
}
