package com.example.ASM.utl;

import com.example.ASM.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HebernateUtil {

    private static final SessionFactory FACTORY;
    private Session hSession;
    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO,"update");

        conf.setProperties(properties);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(NSX.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(DongSanPham.class);

        conf.addAnnotatedClass(ChiTietSP.class);




        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {

        return FACTORY;
    }

    public static void main(String[] args) {



        System.out.println(getFACTORY());
    }

}
