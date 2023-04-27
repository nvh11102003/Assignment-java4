package com.example.Asm.Repository;

import com.example.Asm.Entity.chiTietSanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChiTietSanPhamRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<chiTietSanPham> getAll() {
        Query query = session.createQuery("from chiTietSanPham ");
        ArrayList<chiTietSanPham> listCTSP = (ArrayList<chiTietSanPham>) query.getResultList();
        return listCTSP;
    }

    public chiTietSanPham getById(String id) {
        chiTietSanPham chiTietSanPham = new chiTietSanPham();
        try {
            chiTietSanPham = session.get(com.example.Asm.Entity.chiTietSanPham.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPham;
    }

    public Boolean add(chiTietSanPham ctsp) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(chiTietSanPham ctsp) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(chiTietSanPham ctsp) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.remove(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
