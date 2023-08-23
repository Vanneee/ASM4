package com.example.ASM.repository;

import com.example.ASM.entity.ChiTietSP;
import com.example.ASM.utl.HebernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public static void main(String[] args) {
        new ChiTietSPRepository().getAll().forEach(s -> System.out.println(s));
    }

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> chiTietSanPhamList = new ArrayList<>();
        try ( Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSP ", ChiTietSP.class);
            chiTietSanPhamList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPhamList;
    }

    public ChiTietSP getOne(UUID id) {
        ChiTietSP chiTietSanPham = null;
        try (Session session =HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChiTietSanPham WHERE id =: id", ChiTietSP.class);
            query.setParameter("id", id);
            chiTietSanPham = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSanPham;
    }

    public void add(ChiTietSP chiTietSanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chiTietSanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(ChiTietSP chiTietSanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ChiTietSP chiTietSanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chiTietSanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
