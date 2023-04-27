package com.example.Asm.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author HP
 */
@Entity
@Table(name = "NSX")
public class NSX implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private String id;

    @Column(name = "ma", unique = true)
    private String maNSX;

    @Column(name = "ten", columnDefinition = "Nvarchar(100)")
    private String tenNSX;

    @OneToMany(mappedBy = "nSX", fetch = FetchType.EAGER)
    private List<chiTietSanPham> lstSP;

    public NSX() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public NSX(String id, String maNSX, String tenNSX) {
        this.id = id;
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }

    public NSX(String maNSX, String tenNSX) {
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
    }
}
