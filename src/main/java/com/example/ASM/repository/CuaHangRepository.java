package com.example.ASM.repository;

import com.example.ASM.entity.CuaHang;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CuaHangRepository {

    public List<CuaHang> getAll() {
        List<CuaHang> cuaHangList = new ArrayList<>() ;
            try(Session session = HebernateUtil.getFACTORY().openSession()) {
                Query query = session.createQuery("FROM CuaHang ",CuaHang.class);
                cuaHangList =query.getResultList();
            }catch (Exception e) {
                e.printStackTrace();
            }
            return cuaHangList;
    }

    public CuaHang getOne(UUID id) {
        CuaHang cuaHang = null;

        try(Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM CuaHang WHERE id=:id");
            query.setParameter("id",id);
            cuaHang=(CuaHang) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  cuaHang;
    }

    public  void delete(CuaHang cuaHang) {

        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void update(CuaHang cuaHang) {

        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.merge(cuaHang);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void add(CuaHang cuaHang) {

        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.persist(cuaHang);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
