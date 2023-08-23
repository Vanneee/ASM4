package com.example.ASM.service.impl;

import com.example.ASM.entity.ChucVu;
import com.example.ASM.repository.ChucVuRepository;
import com.example.ASM.service.ChucVuService;

import java.util.List;
import java.util.UUID;

public class ChucVuServiceImpl implements ChucVuService {

    private final ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu getOne(UUID id) {
        return chucVuRepository.getOne(id);
    }

    @Override
    public void delete(ChucVu chucVu) {
        this.chucVuRepository.delete(chucVu);
    }

    @Override
    public void add(ChucVu chucVu) {
        this.chucVuRepository.add(chucVu);
    }

    @Override
    public void update(ChucVu chucVu) {
        this.update(chucVu);

    }
}
