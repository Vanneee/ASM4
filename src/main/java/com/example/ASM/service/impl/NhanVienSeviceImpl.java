package com.example.ASM.service.impl;

import com.example.ASM.entity.NhanVien;
import com.example.ASM.repository.NhanVienRepository;
import com.example.ASM.service.NhanVienSevice;

import java.util.List;
import java.util.UUID;

public class NhanVienSeviceImpl implements NhanVienSevice {

    private final NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.getAll();
    }

    @Override
    public NhanVien getOne(UUID id) {
        return nhanVienRepository.getOne(id);
    }

    @Override
    public void delete(NhanVien nhanVien) {
        nhanVienRepository.delete(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.update(nhanVien);
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.add(nhanVien);
    }
}
