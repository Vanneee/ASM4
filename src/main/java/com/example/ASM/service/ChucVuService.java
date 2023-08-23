package com.example.ASM.service;

import com.example.ASM.entity.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    ChucVu getOne(UUID id);

    void delete(ChucVu chucVu);

    void add(ChucVu chucVu);

    void update(ChucVu chucVu);
}
