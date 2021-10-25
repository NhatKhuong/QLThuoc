package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.CT_HoaDon;
import entity.CongDung;
import entity.DiaChi;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;


public class MySessionFactory {
	private SessionFactory sessionFactory;
	
	public MySessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure() //hibernate.cfg.xml
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Thuoc.class)
				.addAnnotatedClass(CongDung.class)
				.addAnnotatedClass(CT_HoaDon.class)
				.addAnnotatedClass(DiaChi.class)
				.addAnnotatedClass(HoaDon.class)
				.addAnnotatedClass(KhachHang.class)
				.addAnnotatedClass(NhanVien.class)
				.getMetadataBuilder()
				.build();
		
		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() {
		sessionFactory.close();
	}



}
