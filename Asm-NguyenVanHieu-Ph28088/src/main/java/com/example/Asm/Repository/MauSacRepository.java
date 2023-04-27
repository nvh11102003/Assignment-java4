package com.example.Asm.Repository;

import com.example.Asm.Entity.ChucVu;
import com.example.Asm.Entity.MauSac;
import com.example.Asm.Entity.SanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class MauSacRepository {
    Session session = HibernateUtil.getFACTORY().openSession();
    public ArrayList<MauSac> getAll() {
        Query query = session.createQuery("from MauSac ");
        ArrayList<MauSac> listMS = (ArrayList<MauSac>) query.getResultList();
        return listMS;
    }

    public MauSac getById(String id){
        MauSac mauSac = new MauSac();
        try {
           mauSac = session.get(MauSac.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }
    public Boolean delete(MauSac mauSac){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(MauSac mauSac){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public MauSac getByTen(String ten) {
        MauSac mauSac = new MauSac();
        try{
            Query query = session.createQuery("from MauSac WHERE tenMauSac = :tenMS1");
            query.setParameter("tenMS1", ten);
            mauSac = (MauSac) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }
    public Boolean add(MauSac mauSac){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
