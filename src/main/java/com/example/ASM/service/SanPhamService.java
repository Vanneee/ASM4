package com.example.ASM.service;

import com.example.ASM.entity.SanPham;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    SanPham getOne(UUID id);

    void delete(SanPham sanPham);

    void add(SanPham sanPham);

    void update(SanPham sanPham);
}
