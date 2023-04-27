package com.example.Asm.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CuaHang")
public class CuaHang {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String idCH;

    @Column(name = "Ma")
    private String maCH;

    @Column(name = "Ten")
    private String tenCH;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @OneToMany(mappedBy = "cuaHang")
    private List<NhanVien> listnv;

    public List<NhanVien> getListnv() {
        return listnv;
    }

    public CuaHang(String idCH, String maCH, String tenCH, String diaChi, String thanhPho, String quocGia, List<NhanVien> listnv) {
        this.idCH = idCH;
        this.maCH = maCH;
        this.tenCH = tenCH;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.listnv = listnv;
    }

    public void setListnv(List<NhanVien> listnv) {
        this.listnv = listnv;
    }

    public String getIdCH() {
        return idCH;
    }

    public void setIdCH(String idCH) {
        this.idCH = idCH;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenCH() {
        return tenCH;
    }

    public void setTenCH(String tenCH) {
        this.tenCH = tenCH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String thanhPho) {
        this.thanhPho = thanhPho;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public CuaHang(String idCH, String maCH, String tenCH, String diaChi, String thanhPho, String quocGia) {
        this.idCH = idCH;
        this.maCH = maCH;
        this.tenCH = tenCH;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }
    public CuaHang( String maCH, String tenCH, String diaChi, String thanhPho, String quocGia) {
        this.maCH = maCH;
        this.tenCH = tenCH;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }
    public CuaHang() {
    }
}
