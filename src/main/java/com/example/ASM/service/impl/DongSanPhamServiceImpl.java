package com.example.ASM.service.impl;

import com.example.ASM.entity.DongSanPham;
import com.example.ASM.repository.DongSanPhamRepository;
import com.example.ASM.service.DongSanPhamService;

import javax.swing.*;
import java.util.List;
import java.util.UUID;

public class DongSanPhamServiceImpl implements DongSanPhamService {

    private final DongSanPhamRepository dongSanPhamRepository = new DongSanPhamRepository();

    @Override
    public List<DongSanPham> getAll() {
        return dongSanPhamRepository.getAll();
    }

    @Override
    public DongSanPham getOne(UUID id) {
        return dongSanPhamRepository.getOne(id);
    }

    @Override
    public void delete(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.delete(dongSanPham);
    }

    @Override
    public void add(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.add(dongSanPham);
    }

    @Override
    public void update(DongSanPham dongSanPham) {
        this.dongSanPhamRepository.update(dongSanPham);
    }
}
