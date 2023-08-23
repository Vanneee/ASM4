package com.example.ASM.service.impl;

import com.example.ASM.entity.CuaHang;
import com.example.ASM.repository.CuaHangRepository;
import com.example.ASM.service.CuaHangService;

import java.util.List;
import java.util.UUID;

public class CuaHangServiceImpl implements CuaHangService {

    private final CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.getAll();
    }

    @Override
    public CuaHang getOne(UUID id) {
        return cuaHangRepository.getOne(id);
    }

    @Override
    public void delete(CuaHang cuaHang) {
        this.cuaHangRepository.delete(cuaHang);
    }

    @Override
    public void update(CuaHang cuaHang) {
        this.cuaHangRepository.update(cuaHang);
    }

    @Override
    public void add(CuaHang cuaHang) {
        this.cuaHangRepository.add(cuaHang);
    }
}
