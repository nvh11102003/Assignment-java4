package com.example.Asm.Repository;

import com.example.Asm.Entity.KhachHang;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class KhachHangRepository {
    //    public List<KhachHang> getAll() {
//        List<KhachHang> khs = new ArrayList<>();
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang ", KhachHang.class);
//            khs = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return khs;
//    }
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<KhachHang> getAll() {
        Query query = session.createQuery("from KhachHang ");
        ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) query.getResultList();
        return listKhachHang;
    }

    public KhachHang getById(UUID id) {
        KhachHang khachHang = new KhachHang();
        try {
            khachHang = session.get(KhachHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public Boolean add(KhachHang khachHang) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
    public Boolean delete(KhachHang khachHang){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
