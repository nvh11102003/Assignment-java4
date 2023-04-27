package com.example.Asm.Repository;

import com.example.Asm.Entity.ChucVu;
import com.example.Asm.Entity.SanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class SanPhamRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<SanPham> getAll() {
        Query query = session.createQuery("from SanPham ");
        ArrayList<SanPham> listSP = (ArrayList<SanPham>) query.getResultList();
        return listSP;
    }

    public SanPham getById(String id) {
        SanPham sanPham = new SanPham();
        try {
          sanPham=  session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }
    public SanPham getByTen(String ten) {
        SanPham sanPham = new SanPham();
        try{
            Query query = session.createQuery("from SanPham WHERE tenSP = :tenSP1");
            query.setParameter("tenSP1", ten);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public Boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(SanPham sanPham) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
