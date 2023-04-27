package com.example.Asm.Entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "chiTietSanPham")
public class chiTietSanPham {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @ManyToOne
    @JoinColumn(name = "idSp")
    private SanPham sanPham;


    @Column(name = "NamBH")
    private Integer namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    private float giaNhap;

    @Column(name = "GiaBan")
    private float giaBan;


    @ManyToOne
    @JoinColumn(name = "idNSX")
    private NSX nSX;

    @ManyToOne
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idDongSP")
    private DongSanPham dongSP;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public chiTietSanPham() {
    }

    public chiTietSanPham(String id, SanPham sanPham, Integer namBH, String moTa, Integer soLuongTon, float giaNhap, float giaBan, NSX nSX, MauSac mauSac, DongSanPham dongSP) {
        this.id = id;
        this.sanPham = sanPham;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.nSX = nSX;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
    }

    public Integer getNamBH() {
        return namBH;
    }

    public void setNamBH(Integer namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public NSX getnSX() {
        return nSX;
    }

    public void setnSX(NSX nSX) {
        this.nSX = nSX;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSanPham getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSanPham dongSP) {
        this.dongSP = dongSP;
    }
}
