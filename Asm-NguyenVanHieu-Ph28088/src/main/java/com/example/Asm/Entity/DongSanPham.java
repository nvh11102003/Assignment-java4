package com.example.Asm.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "DongSanPham")
public class DongSanPham implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma", unique = true)
    private String maDSP;

    @Column(name = "ten", columnDefinition = "Nvarchar(100)")
    private String tenDSP;

    @OneToMany(mappedBy = "dongSP", fetch = FetchType.EAGER)
    private List<chiTietSanPham> lstSP;

    public DongSanPham() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaDSP() {
        return maDSP;
    }

    public void setMaDSP(String maDSP) {
        this.maDSP = maDSP;
    }

    public String getTenDSP() {
        return tenDSP;
    }

    public void setTenDSP(String tenDSP) {
        this.tenDSP = tenDSP;
    }

    public List<chiTietSanPham> getLstSP() {
        return lstSP;
    }

    public void setLstSP(List<chiTietSanPham> lstSP) {
        this.lstSP = lstSP;
    }

    public DongSanPham(String id, String maDSP, String tenDSP) {
        this.id = id;
        this.maDSP = maDSP;
        this.tenDSP = tenDSP;
    }

    public DongSanPham(String maDSP, String tenDSP) {
        this.maDSP = maDSP;
        this.tenDSP = tenDSP;
    }
}
