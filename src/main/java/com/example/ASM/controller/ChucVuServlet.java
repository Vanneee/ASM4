package com.example.ASM.controller;

import com.example.ASM.entity.ChucVu;
import com.example.ASM.service.ChucVuService;
import com.example.ASM.service.impl.ChucVuServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/remove",
        "/chuc-vu/detail",
        "/chuc-vu/view-update",
        "/chuc-vu/update"
})
public class ChucVuServlet extends HttpServlet {

    private List<ChucVu> list = new ArrayList<>();
    private final ChucVuService service = new ChucVuServiceImpl();

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
        ChucVu cv = service.getOne(UUID.fromString(id));
        request.setAttribute("update", cv);
        request.getRequestDispatcher("/views/chuc-vu/update.jsp").forward(request, response);
    }

    private void viewRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = service.getOne(UUID.fromString(id));
        service.delete(cv);
        this.hienThi(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu cv = service.getOne(UUID.fromString(id));
        request.setAttribute("detail", cv);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("lists", list);
        request.getRequestDispatcher("/views/chuc-vu/hien-thi.jsp").forward(request, response);
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
        ChucVu cv = new ChucVu(UUID.fromString(id), ma, ten);
        service.update(cv);
        this.hienThi(request, response);
    }

    private void htAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ChucVu cv = new ChucVu(ma, ten);
        service.add(cv);
        this.hienThi(request, response);
    }
}
