package com.example.ASM.service;

import com.example.ASM.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    MauSac getOne(UUID id);

    void update(MauSac mauSac);

    void delete(MauSac mauSac);

    void add(MauSac mauSac);
}
