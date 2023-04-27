package com.example.Asm.Repository;

import com.example.Asm.Entity.CuaHang;
import com.example.Asm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();
    public ArrayList<CuaHang> getAll() {
        Query query = session.createQuery("from CuaHang ");
        ArrayList<CuaHang> listCH = (ArrayList<CuaHang>) query.getResultList();
        return listCH;
    }
    public CuaHang getById(String id){
        CuaHang cuaHang = new CuaHang();
        try {
            cuaHang = session.get(CuaHang.class,id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return cuaHang;
    }

    public Boolean add(CuaHang cuaHang){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(CuaHang cuaHang){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Boolean delete(CuaHang cuaHang){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(cuaHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public CuaHang getByTen(String ten) {
        CuaHang cuaHang = new CuaHang();
        try{
            Query query = session.createQuery("from CuaHang WHERE tenCH = :tenCH1");
            query.setParameter("tenCH1", ten);
            cuaHang = (CuaHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }
}
