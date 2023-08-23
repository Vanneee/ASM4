package com.example.ASM.service.impl;

import com.example.ASM.entity.NSX;
import com.example.ASM.repository.NSXRepository;
import com.example.ASM.service.NSXService;

import java.util.List;
import java.util.UUID;

public class NSXServiceImpl implements NSXService {
    private final NSXRepository nsxRepository = new NSXRepository();

    @Override
    public List<NSX> getAll() {
        return nsxRepository.getAll();
    }

    @Override
    public NSX getOne(UUID id) {
        return nsxRepository.getOne(id);
    }

    @Override
    public void delete(NSX nhaSanXuat) {
        this.nsxRepository.delete(nhaSanXuat);
    }

    @Override
    public void add(NSX nhaSanXuat) {
        this.nsxRepository.add(nhaSanXuat);
    }

    @Override
    public void update(NSX nhaSanXuat) {
        this.nsxRepository.update(nhaSanXuat);
    }
}
