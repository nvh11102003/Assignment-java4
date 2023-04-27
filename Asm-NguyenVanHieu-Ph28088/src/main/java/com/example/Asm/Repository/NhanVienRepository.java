package com.example.Asm.Repository;

import com.example.Asm.Entity.NhanVien;
import com.example.Asm.Entity.chiTietSanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NhanVienRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<NhanVien> getAll() {
        Query query = session.createQuery("from NhanVien ");
        ArrayList<NhanVien> listNV = (ArrayList<NhanVien>) query.getResultList();
        return listNV;
    }

    public NhanVien getById(String id) {
        NhanVien nhanVien = new NhanVien();
        try {
           nhanVien= session.get(NhanVien.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public Boolean add(NhanVien nhanVien){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(NhanVien nhanVien){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean delete(NhanVien nhanVien){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
