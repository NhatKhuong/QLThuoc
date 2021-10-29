package dao;

import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.dialect.MySQLStorageEngine;

import entity.Thuoc;

public class ThuocDao{
	private SessionFactory sessionFactory;

	public ThuocDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			session.delete(session.find(Thuoc.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
		
	}
	
	public Thuoc getThuocById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			
			Thuoc thuoc = session.find(Thuoc.class,id);
			tr.commit();
			
			return thuoc;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return null;
	}
	
	public boolean update(Thuoc newThuoc) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			session.update(newThuoc);
			tr.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return false;
	}
	
	public List<Thuoc> danhSachThuoc(int page,
			String tenThuoc, String thanhPhan, String dvt, String congDung, String nhomCongDung, String dangBaoChe, String nuoc){
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			int offset = page * 20;
			String sql = "select * from Thuoc join CongDung on Thuoc.maCongDung  = CongDung.maCongDung "
			+ "where tenThuoc like N'%"+tenThuoc+"%' "
			+ "and congDung like N'%"+congDung+"%' "
			+ "and donViTinh like N'%"+dvt+"%' "
			+ "and nhomCongDung like N'%"+nhomCongDung+"%'"
			+ "and dangBaoChe like N'%"+dangBaoChe+"%'"
			+ "and nuocSanXuat like N'%"+nuoc+"%'"
			+ "and thanhPhan like N'%"+thanhPhan+"%' order by Thuoc.tenThuoc offset "
			+ offset + " rows fetch next 20 rows only";
			System.out.println(sql);
			List<Thuoc> thuoList = session.createNativeQuery(sql, Thuoc.class)
					.getResultList();
			
			tr.commit();
			return thuoList;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
		
	}
	
	public boolean setTrangThaiKinhDoanh(String id, boolean tt) {
		Thuoc thuoc = getThuocById(id);
		System.out.println("in"+thuoc);
		if(thuoc == null) {
			return false;
		}
		else {		
			try {
				thuoc.setTrangThaiKinhDoanh(tt);
				return update(thuoc);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	
}
