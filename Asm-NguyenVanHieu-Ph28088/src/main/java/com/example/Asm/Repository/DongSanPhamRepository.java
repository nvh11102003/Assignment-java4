package com.example.Asm.Repository;


import com.example.Asm.Entity.DongSanPham;
import com.example.Asm.Entity.SanPham;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class DongSanPhamRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<DongSanPham> getAll() {
        Query query = session.createQuery("from DongSanPham ");
        ArrayList<DongSanPham> listDongSanPham = (ArrayList<DongSanPham>) query.getResultList();
        return listDongSanPham;
    }
    public DongSanPham getById(String id){
        DongSanPham dongSanPham = new DongSanPham();
        try {
           dongSanPham = session.get(DongSanPham.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dongSanPham;
    }
    public Boolean add(DongSanPham dongSanPham){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(dongSanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public DongSanPham getByTen(String ten) {
        DongSanPham dongSanPham = new DongSanPham();
        try{
            Query query = session.createQuery("from DongSanPham WHERE tenDSP = :tenDSP1");
            query.setParameter("tenDSP1", ten);
            dongSanPham = (DongSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSanPham;
    }
    public Boolean delete(DongSanPham dongSanPham){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(dongSanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(DongSanPham dongSanPham){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(dongSanPham);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
