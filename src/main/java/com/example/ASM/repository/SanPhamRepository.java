package com.example.ASM.repository;

import com.example.ASM.entity.SanPham;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {

    public List<SanPham> getAll() {
        List<SanPham> sanPhamList = new ArrayList<>();
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham ", SanPham.class);
            sanPhamList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public SanPham getOne(UUID id) {
        SanPham sanPham = null;
        try (Session session =HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM SanPham WHERE id =: id", SanPham.class);
            query.setParameter("id", id);
            sanPham = (SanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;

    }

    public void delete(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(SanPham sanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
