package com.example.ASM.controller;

import com.example.ASM.entity.KhachHang;
import com.example.ASM.repository.KhachHangRepository;
import com.example.ASM.service.KhachHangService;
import com.example.ASM.service.impl.KhachHangServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/remove",
        "/khach-hang/detail",
        "/khach-hang/view-update",
        "/khach-hang/update"
})
public class KhachHangServlet extends HttpServlet {

    private final KhachHangService service = new KhachHangServiceImpl();
    private List<KhachHang> list = new ArrayList<>();

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
        KhachHang kh = service.getOne(UUID.fromString(id));
        request.setAttribute("update", kh);
        request.getRequestDispatcher("views/khach-hang/update.jsp").forward(request, response);
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = service.getOne(UUID.fromString(id));
        service.delete(kh);
        this.hienThi(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        KhachHang kh = service.getOne(UUID.fromString(id));
        request.setAttribute("detail", kh);
        this.hienThi(request, response);

    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("lists", list);
        request.getRequestDispatcher("/views/khach-hang/hien-thi.jsp").forward(request, response);
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
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");

        KhachHang kh = new KhachHang(UUID.fromString(id), ma, ten, tenDem, ho, ngaySinh, soDienThoai, diaChi, thanhPho, quocGia, matKhau);
        service.update(kh);
        this.hienThi(request, response);
    }

    private void htAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String ngaySinh = request.getParameter("ngaySinh");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");

        KhachHang kh = new KhachHang(ma, ten, tenDem, ho, ngaySinh, soDienThoai, diaChi, thanhPho, quocGia, matKhau);
        service.add(kh);
        this.hienThi(request, response);
    }
}
