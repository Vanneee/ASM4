package com.example.ASM.service;

import com.example.ASM.entity.DongSanPham;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {
    List<DongSanPham> getAll();

    DongSanPham getOne(UUID id);

    void delete(DongSanPham dongSanPham);

    void add(DongSanPham dongSanPham);

    void update(DongSanPham dongSanPham);

}
