package com.example.ASM.repository;

import com.example.ASM.entity.NSX;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NSXRepository {
    public List<NSX> getAll() {
        List<NSX> nhaSanXuatList = new ArrayList<>();
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX ", NSX.class);
            nhaSanXuatList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhaSanXuatList;
    }

    public NSX getOne(UUID id) {
        NSX nhaSanXuat = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhaSanXuat WHERE id =: id", NSX.class);
            query.setParameter("id", id);
            nhaSanXuat = (NSX) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhaSanXuat;
    }

    public void delete(NSX nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhaSanXuat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(NSX nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhaSanXuat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(NSX nhaSanXuat) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhaSanXuat);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
