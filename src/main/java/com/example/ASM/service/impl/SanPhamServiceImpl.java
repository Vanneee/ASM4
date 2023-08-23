package com.example.ASM.service.impl;

import com.example.ASM.entity.SanPham;
import com.example.ASM.repository.SanPhamRepository;
import com.example.ASM.service.SanPhamService;

import java.util.List;
import java.util.UUID;

public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public SanPham getOne(UUID id) {
        return sanPhamRepository.getOne(id);
    }

    @Override
    public void delete(SanPham sanPham) {
       this.sanPhamRepository.delete(sanPham);

    }

    @Override
    public void add(SanPham sanPham) {
        this.sanPhamRepository.add(sanPham);
    }

    @Override
    public void update(SanPham sanPham) {
        this.sanPhamRepository.update(sanPham);

    }
}
