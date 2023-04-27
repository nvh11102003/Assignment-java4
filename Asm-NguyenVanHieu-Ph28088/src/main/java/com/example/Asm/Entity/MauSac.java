package com.example.Asm.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "MauSac")
public class MauSac implements Serializable{

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma")
    private String maMauSac;
    @Column(name = "ten", columnDefinition = "Nvarchar(100)")
    private String tenMauSac;
    @OneToMany(mappedBy = "mauSac", fetch = FetchType.EAGER)
    private List<chiTietSanPham> lstSP;

    public MauSac() {
    }

    public String getId() {
        return id;
    }

    public MauSac(String id, String maMauSac, String tenMauSac) {
        this.id = id;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
    }

    public MauSac(String maMauSac, String tenMauSac) {
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
    }

    public MauSac(String id, String maMauSac, String tenMauSac, List<chiTietSanPham> lstSP) {
        this.id = id;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.lstSP = lstSP;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public List<chiTietSanPham> getLstSP() {
        return lstSP;
    }

    public void setLstSP(List<chiTietSanPham> lstSP) {
        this.lstSP = lstSP;
    }
}
