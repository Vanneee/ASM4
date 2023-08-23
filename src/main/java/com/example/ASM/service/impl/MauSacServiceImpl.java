package com.example.ASM.service.impl;

import com.example.ASM.entity.MauSac;
import com.example.ASM.repository.MauSacRepository;
import com.example.ASM.service.MauSacService;

import java.util.List;
import java.util.UUID;

public class MauSacServiceImpl implements MauSacService {

    private final MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public MauSac getOne(UUID id) {
        return mauSacRepository.getOne(id);
    }

    @Override
    public void update(MauSac mauSac) {
        this.mauSacRepository.update(mauSac);
    }

    @Override
    public void delete(MauSac mauSac) {
        this.mauSacRepository.delete(mauSac);
    }

    @Override
    public void add(MauSac mauSac) {
        this.mauSacRepository.add(mauSac);
    }
}
