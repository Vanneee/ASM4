package com.example.ASM.repository;

import com.example.ASM.entity.MauSac;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {

    public List<MauSac> getAll() {
        List<MauSac>  mauSacList = new ArrayList<>();

        try(Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query =session.createQuery("FROM MauSac ",MauSac.class);
            mauSacList =query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mauSacList;
    }

    public MauSac getOne(UUID id) {
        MauSac mauSac = null;

        try(Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM MauSac  WHERE id=: id");
            query.setParameter("id",id);
            mauSac = (MauSac) query.getSingleResult();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    public void delete(MauSac mauSac) {
        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(MauSac mauSac) {
        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(MauSac mauSac) {
        Transaction transaction = null;
        try(Session session =HebernateUtil.getFACTORY().openSession()) {
            transaction =session.beginTransaction();
            session.persist(mauSac);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
