package com.example.ASM.repository;

import com.example.ASM.entity.ChucVu;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        List<ChucVu> chucVuList = new ArrayList<>();
        try(Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu ",ChucVu.class);
            chucVuList= query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return chucVuList;
    }

    public ChucVu getOne(UUID id) {
        ChucVu chucVu = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM ChucVu WHERE id =: id", ChucVu.class);
            query.setParameter("id", id);
            chucVu = (ChucVu) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }

    public void delete(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(chucVu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(ChucVu chucVu) {
        Transaction transaction = null;
        try (Session session = HebernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
