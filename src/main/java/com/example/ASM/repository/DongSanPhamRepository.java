package com.example.ASM.repository;

import com.example.ASM.entity.DongSanPham;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DongSanPhamRepository {

    public List<DongSanPham> getAll() {
        List<DongSanPham> dongSanPhamList = new ArrayList<>();
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSanPham ", DongSanPham.class);
            dongSanPhamList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSanPhamList;
    }

    public DongSanPham getOne(UUID id) {
        DongSanPham dongSanPham = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from DongSanPham where id =: id ", DongSanPham.class);
            query.setParameter("id", id);
            dongSanPham = (DongSanPham) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSanPham;
    }

    public void delete(DongSanPham dongSanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dongSanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(DongSanPham dongSanPham) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dongSanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(DongSanPham dongSanPham) {
        Transaction transaction = null;
        try (Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dongSanPham);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
