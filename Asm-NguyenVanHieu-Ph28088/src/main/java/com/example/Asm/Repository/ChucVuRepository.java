package com.example.Asm.Repository;

import com.example.Asm.Entity.ChucVu;
import com.example.Asm.Entity.DongSanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuRepository {
    Session session = HibernateUtil.getFACTORY().openSession();
    public ArrayList<ChucVu> getAll() {
        Query query = session.createQuery("from ChucVu ");
        ArrayList<ChucVu> listCV = (ArrayList<ChucVu>) query.getResultList();
        return listCV;
    }
    public Boolean add(ChucVu chucVu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return false;
        }

    }
   public ChucVu getById(String id){
        ChucVu chucVu = new ChucVu();
        try{
            chucVu = session.get(ChucVu.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return chucVu;
   }
   public Boolean delete(ChucVu chucVu){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
   }
    public Boolean update(ChucVu chucVu){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public ChucVu getByTen(String ten) {
        ChucVu chucVu = new ChucVu();
        try{
            Query query = session.createQuery("from ChucVu WHERE tenCV = :tenCV1");
            query.setParameter("tenCV1", ten);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }
}
