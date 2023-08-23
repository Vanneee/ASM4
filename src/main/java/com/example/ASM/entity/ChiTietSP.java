package com.example.ASM.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "IdSP")
    private UUID idSanPham;

    @Column(name = "IdNsx")
    private UUID idNhaSanXuat;

    @Column(name = "IdMauSac")
    private UUID idMauSac;

    @Column(name = "IdDongSP")
    private UUID idDongSanPham;

    @Column(name = "NamBH")
    private Integer namBaoHanh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

}
