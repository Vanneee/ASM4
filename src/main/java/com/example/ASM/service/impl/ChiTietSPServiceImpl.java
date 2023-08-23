package com.example.ASM.service.impl;


import com.example.ASM.entity.ChiTietSP;
import com.example.ASM.repository.ChiTietSPRepository;
import com.example.ASM.service.ChiTietSPService;

import java.util.List;
import java.util.UUID;

public class ChiTietSPServiceImpl  implements ChiTietSPService {

    private final ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSP> getAll() {
        return chiTietSPRepository.getAll();
    }

    @Override
    public ChiTietSP getOne(UUID id) {
        return chiTietSPRepository.getOne(id);
    }

    @Override
    public void delete(ChiTietSP chiTietSP) {
        this.chiTietSPRepository.delete(chiTietSP);
    }

    @Override
    public void update(ChiTietSP chiTietSP) {
        this.chiTietSPRepository.update(chiTietSP);
    }

    @Override
    public void add(ChiTietSP chiTietSP) {
        this.chiTietSPRepository.add(chiTietSP);
    }
}
