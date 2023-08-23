package com.example.ASM.service.impl;

import com.example.ASM.entity.KhachHang;
import com.example.ASM.repository.KhachHangRepository;
import com.example.ASM.service.KhachHangService;

import java.util.List;
import java.util.UUID;

public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository = new KhachHangRepository();
    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.getAll();
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.getOne(id);
    }

    @Override
    public void delete(KhachHang khachHang) {
        this.khachHangRepository.delete(khachHang);
    }

    @Override
    public void add(KhachHang khachHang) {
        this.khachHangRepository.add(khachHang);
    }

    @Override
    public void update(KhachHang khachHang) {
        this.khachHangRepository.update(khachHang);
    }
}
