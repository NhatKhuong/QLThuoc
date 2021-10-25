package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import dao.MySessionFactory;
import dao.ThuocDao;
import entity.CT_HoaDon;
import entity.CongDung;
import entity.DiaChi;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
		
		ThuocDao dao = new ThuocDao(sessionFactory);
		System.out.println(dao.getThuocById("DPAA000001"));
		
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//				.configure()
//				.build();
//		
//		Metadata metadata = new MetadataSources(serviceRegistry)
//				.addAnnotatedClass(CongDung.class)
//				.addAnnotatedClass(CT_HoaDon.class)
//				.addAnnotatedClass(DiaChi.class)
//				.addAnnotatedClass(HoaDon.class)
//				.addAnnotatedClass(KhachHang.class)
//				.addAnnotatedClass(NhanVien.class)
//				.addAnnotatedClass(Thuoc.class)
//				.getMetadataBuilder()
//				.build();
//		
//		SessionFactory sessionFactory = metadata
//				.getSessionFactoryBuilder()
//				.build();
//		
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tr = session.getTransaction();
//		
//		try {
//			
//			tr.begin();
//			
//			tr.commit();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			tr.rollback();
//		}
	}

}
