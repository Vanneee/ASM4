package com.example.ASM.service;

import com.example.ASM.entity.CuaHang;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {

    List<CuaHang> getAll();

    CuaHang getOne(UUID id);

    void delete (CuaHang cuaHang);

    void update(CuaHang cuaHang);

    void add(CuaHang cuaHang);

}
