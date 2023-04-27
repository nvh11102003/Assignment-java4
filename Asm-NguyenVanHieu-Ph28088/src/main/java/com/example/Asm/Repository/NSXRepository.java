package com.example.Asm.Repository;


import com.example.Asm.Entity.NSX;
import com.example.Asm.Entity.SanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NSXRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<NSX> getAll() {
        Query query = session.createQuery("from NSX ");
        ArrayList<NSX> listNSX = (ArrayList<NSX>) query.getResultList();
        return listNSX;
    }

    public NSX getById(String id) {
        NSX nsx = new NSX();
        try {
            nsx = session.get(NSX.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public NSX getByTen(String ten) {
        NSX nsx = new NSX();
        try {
            Query query = session.createQuery("from NSX WHERE tenNSX = :tenNSX1");
            query.setParameter("tenNSX1", ten);
            nsx = (NSX) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean add(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(NSX nsx) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
