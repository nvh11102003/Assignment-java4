package com.example.Asm.Entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "Ma")
    private String maCV;

    @Column(name = "Ten")
    private String tenCV;

    @OneToMany(mappedBy = "chucVu")
    private List<NhanVien> listnv;

    public ChucVu(String id, String maCV, String tenCV, List<NhanVien> listnv) {
        this.id = id;
        this.maCV = maCV;
        this.tenCV = tenCV;
        this.listnv = listnv;
    }

    public ChucVu(String maCV, String tenCV) {
        this.maCV = maCV;
        this.tenCV = tenCV;
    }

    public ChucVu() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String ten) {
        this.tenCV = ten;
    }

    public List<NhanVien> getListnv() {
        return listnv;
    }

    public void setListnv(List<NhanVien> listnv) {
        this.listnv = listnv;
    }
}
