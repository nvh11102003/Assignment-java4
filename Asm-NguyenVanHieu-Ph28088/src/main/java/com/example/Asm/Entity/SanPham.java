package com.example.Asm.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma", unique = true)
    private String maSP;

    @Column(name = "ten", columnDefinition = "Nvarchar(100)")
    private String tenSP;

    @OneToMany(mappedBy = "sanPham", fetch = FetchType.EAGER)
    private List<chiTietSanPham> lstSP;

    public SanPham() {
    }

    public SanPham(String id, String maSP, String tenSP) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public List<chiTietSanPham> getLstSP() {
        return lstSP;
    }

    public void setLstSP(List<chiTietSanPham> lstSP) {
        this.lstSP = lstSP;
    }

    public SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }
}