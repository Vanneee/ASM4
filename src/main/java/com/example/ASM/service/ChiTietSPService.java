package com.example.ASM.service;

import com.example.ASM.entity.ChiTietSP;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> getAll();
    ChiTietSP getOne(UUID id);
    void delete(ChiTietSP chiTietSP);
    void update(ChiTietSP chiTietSP);
    void add(ChiTietSP chiTietSP);
}
