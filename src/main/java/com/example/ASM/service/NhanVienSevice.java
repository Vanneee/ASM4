package com.example.ASM.service;

import com.example.ASM.entity.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienSevice {
    List<NhanVien> getAll();
    NhanVien getOne(UUID id);
    void delete (NhanVien nhanVien);
    void update(NhanVien nhanVien);
    void add(NhanVien nhanVien);
}
