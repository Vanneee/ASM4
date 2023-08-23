package com.example.ASM.controller;

import com.example.ASM.entity.CuaHang;
import com.example.ASM.service.CuaHangService;
import com.example.ASM.service.impl.CuaHangServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/remove",
        "/cua-hang/delete",
        "/cua-hang/detail",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/view-update",

})
public class CuaHangServlet extends HttpServlet {

    private CuaHangService service = new CuaHangServiceImpl();
    private List<CuaHang> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCuaHang(request,response);
        }else if (uri.equals("remove")) {
            this.removeCuaHang(request,response);
        }else if (uri.equals("detail")) {
            this.detailCuaHang(request,response);

        }else {
            this.viewUpdateCuaHang(request,response);
        }
    }

    private void viewUpdateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang cuaHang =service.getOne(UUID.fromString(id));
        request.setAttribute("update",cuaHang);
        request.getRequestDispatcher("/view/update.jsp").forward(request,response);
    }

    private void deleteCuaHang(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        CuaHang cuaHang =service.getOne(UUID.fromString(id));
        request.setAttribute("detail",cuaHang);

    }

    private void removeCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang cuaHang = service.getOne(UUID.fromString(id));
        service.delete(cuaHang);
        this.hienThiCuaHang(request,response);

    }

    private void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("lists",list);
        request.getRequestDispatcher("/views/cua-hang/hien-thi.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addCuaHang(request,response);
        }else {
            this.updateCuaHang(request,response);
        }
    }

    private void updateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang cuaHang = new CuaHang(UUID.fromString(id),ma,ten,diaChi,thanhPho,quocGia);
        service.update(cuaHang);
        this.hienThiCuaHang(request,response);


    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");

        CuaHang cuaHang = new CuaHang(ma,ten,diaChi,thanhPho,quocGia);
        service.update(cuaHang);
        this.hienThiCuaHang(request,response);
    }
}
