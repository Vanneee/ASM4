package com.example.ASM.controller;

import com.example.ASM.entity.ChiTietSP;
import com.example.ASM.service.*;
import com.example.ASM.service.impl.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/view-update",
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/detail",
})
public class ChiTietSPServlet extends HttpServlet {

    List<ChiTietSP> list = new ArrayList<>();
    ChiTietSPService services = new ChiTietSPServiceImpl();
    SanPhamService sanPhamServices = new SanPhamServiceImpl();
    NSXService nhaSanXuatServices = new NSXServiceImpl();
    MauSacService mauSacServices = new MauSacServiceImpl();
    DongSanPhamService dongSanPhamServices = new DongSanPhamServiceImpl();
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.viewDetail(request, response);
        } else if (uri.contains("remove")) {
            this.viewRemove(request, response);
        } else if (uri.contains("view-add"))    {
            this.viewAdd(request, response);
        } else {
            this.viewUpdate(request, response);
        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("dongSanPham", dongSanPhamServices.getAll());
        request.setAttribute("nhaSanXuat", nhaSanXuatServices.getAll());
        request.setAttribute("mauSac", mauSacServices.getAll());
        request.setAttribute("sanPham", sanPhamServices.getAll());
        request.getRequestDispatcher("/views/chi-tiet-san-pham/view-add.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSP chiTietSanPham = services.getOne(UUID.fromString(id));
        request.setAttribute("update", chiTietSanPham);
        request.getRequestDispatcher("/views/chi-tiet-san-pham/update.jsp").forward(request, response);
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSP ctsp = services.getOne(UUID.fromString(id));
        services.delete(ctsp);
        this.hienThi(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSP ctsp = services.getOne(UUID.fromString(id));
        request.setAttribute("detail", ctsp);
        this.hienThi(request, response);

    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = services.getAll();
        request.setAttribute("lists", list);
        request.getRequestDispatcher("/views/chi-tiet-san-pham/hien-thi.jsp").forward(request, response);
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
        String idSanPham = request.getParameter("idSanPham");
        String idNhaSanXuat = request.getParameter("idNhaSanXuat");
        String idMauSac = request.getParameter("idMauSac");
        String idDongSanPham = request.getParameter("idDongSanPham");
        String namBaoHanh = request.getParameter("namBaoHanh");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");

        ChiTietSP chiTietSanPham = new ChiTietSP(UUID.fromString(id), UUID.fromString(idSanPham), UUID.fromString(idNhaSanXuat), UUID.fromString(idMauSac), UUID.fromString(idDongSanPham), Integer.valueOf(namBaoHanh), moTa, Integer.valueOf(soLuongTon), BigDecimal.valueOf(Long.parseLong(giaNhap)), BigDecimal.valueOf(Long.parseLong(giaBan)));
        services.update(chiTietSanPham);
        this.hienThi(request, response);
    }

    private void htAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idSanPham = request.getParameter("idSanPham");
        String idNhaSanXuat = request.getParameter("idNhaSanXuat");
        String idMauSac = request.getParameter("idMauSac");
        String idDongSanPham = request.getParameter("idDongSanPham");
        String namBaoHanh = request.getParameter("namBaoHanh");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");

        ChiTietSP chiTietSanPham = new ChiTietSP(null, UUID.fromString(idSanPham), UUID.fromString(idNhaSanXuat), UUID.fromString(idMauSac), UUID.fromString(idDongSanPham), Integer.valueOf(namBaoHanh), moTa, Integer.valueOf(soLuongTon), BigDecimal.valueOf(Long.parseLong(giaNhap)), BigDecimal.valueOf(Long.parseLong(giaBan)));
        services.add(chiTietSanPham);
        this.hienThi(request, response);
    }
}
