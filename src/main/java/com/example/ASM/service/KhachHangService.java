package com.example.ASM.service;

import com.example.ASM.entity.KhachHang;

;import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    KhachHang getOne(UUID id);

    void delete(KhachHang khachHang);

    void add(KhachHang khachHang);

    void update(KhachHang khachHang);

}
