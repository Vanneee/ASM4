package com.example.ASM.repository;

import com.example.ASM.entity.KhachHang;
import com.example.ASM.utl.HebernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {

        public List<KhachHang> getAll() {
            List<KhachHang> khachHangList = new ArrayList<>();
            try (Session session = HebernateUtil.getFACTORY().openSession()) {
                Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
                khachHangList = query.getResultList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return khachHangList;
        }

        public KhachHang getOne(UUID id) {
            KhachHang khachHang = null;
            try (Session session = HebernateUtil.getFACTORY().openSession()) {
                Query query = session.createQuery("FROM KhachHang Where id =: id", KhachHang.class);
                query.setParameter("id", id);
                khachHang = (KhachHang) query.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return khachHang;
        }

        public void delete(KhachHang khachHang) {
            Transaction transaction = null;
            try (Session session = HebernateUtil.getFACTORY().openSession()) {
                transaction = session.beginTransaction();
                session.delete(khachHang);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void add(KhachHang khachHang) {
            Transaction transaction = null;
            try (Session session = HebernateUtil.getFACTORY().openSession()) {
                transaction = session.beginTransaction();
                session.persist(khachHang);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void update(KhachHang khachHang) {
            Transaction transaction = null;
            try (Session session = HebernateUtil.getFACTORY().openSession()) {
                transaction = session.beginTransaction();
                session.merge(khachHang);
                transaction.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


