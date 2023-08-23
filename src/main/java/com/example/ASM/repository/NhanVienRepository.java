package com.example.ASM.repository;

import com.example.ASM.entity.NhanVien;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien>  nhanVienList = new ArrayList<>();

        try(Session session = HebernateUtil.getFACTORY().openSession()) {
           Query query =session.createQuery("FROM NhanVien ",NhanVien.class);
            nhanVienList=query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVienList;
    }

    public NhanVien getOne(UUID id) {
        NhanVien nhanVien = null;

        try(Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac  WHERE id=: id");
            query.setParameter("id",id);
           nhanVien =(NhanVien) query.getSingleResult();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public void delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
