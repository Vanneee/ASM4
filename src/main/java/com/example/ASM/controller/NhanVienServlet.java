package com.example.ASM.controller;

import com.example.ASM.entity.NhanVien;
import com.example.ASM.service.NhanVienSevice;
import com.example.ASM.service.impl.NhanVienSeviceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/update",
        "/nhan-vien/view-update",
        "/nhan-vien/remove",
        "/nhan-vien/detail",
})
public class NhanVienServlet extends HttpServlet {

    private NhanVienSevice sevice = new NhanVienSeviceImpl();
    private List<NhanVien> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiNhanVien(request,response);
        }else if (uri.contains("remove")) {
            this.removeNhanVien(request,response);
        }else  if (uri.contains("detail")) {
            this.detailNhanVien(request,response);
        }else {
            this.viewUpdateNhanVien(request,response);
        }
    }

    private void viewUpdateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nhanVien = sevice.getOne(UUID.fromString(id));
        request.setAttribute("update",nhanVien);
        request.getRequestDispatcher("/view/nhan-vien/update.jsp").forward(request,response);

    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nhanVien = sevice.getOne(UUID.fromString(id));
        request.setAttribute("detail",nhanVien);
        this.hienThiNhanVien(request,response);
    }

    private void removeNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        NhanVien nhanVien = sevice.getOne(UUID.fromString(id));
        sevice.delete(nhanVien);
        this.hienThiNhanVien(request,response);
    }

    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = sevice.getAll();
        request.setAttribute("lists",list);
        request.getRequestDispatcher("/views/nhan-vien/hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addNhanVien(request,response);
        }else {
            this.updateNhanVien(request,response);
        }
    }

    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");

        NhanVien nhanVien = new NhanVien(UUID.fromString(id),ma,ten,gioiTinh, Date.valueOf(ngaySinh));
        sevice.update(nhanVien);
        this.hienThiNhanVien(request, response);
    }

    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String gioiTinh = request.getParameter("gioiTinh");
        String ngaySinh = request.getParameter("ngaySinh");

        NhanVien nhanVien = new NhanVien(ma,ten,gioiTinh, Date.valueOf(ngaySinh));
        sevice.add(nhanVien);
        this.hienThiNhanVien(request, response);
    }
}
