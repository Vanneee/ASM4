package com.example.ASM.service;

import com.example.ASM.entity.NSX;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getAll();

    NSX getOne(UUID id);

    void delete(NSX nhaSanXuat);

    void add(NSX nhaSanXuat);

    void update(NSX nhaSanXuat);}
