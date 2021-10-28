package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.KhachHang;
import entity.Thuoc;

public class KhachHangDao {
	private SessionFactory sessionFactory;
	final private int limit = 2;
	public KhachHangDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public List<KhachHang> danhSachKhachHang(int page, String txtSearch, String gioiTinh){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
//		if (txtSearch == null)
//			txtSearch = "";
//		if (gioiTinh == null)
//			gioiTinh = "";
		int offset = page * limit;// lay du lieu bat dau tu vi tri page*20

		try {
			tr.begin();
			
//			Thuoc thuoc = session.find(Thuoc.class,id);
			String sql = "select * from KhachHang inner join DiaChi on  KhachHang.maDC = DiaChi.maDC where tenKhachHang like N'%"
					+ txtSearch + "%' and gioiTinh like '%" + gioiTinh + "%'" + " order by maKhachHang desc "
					+ " OFFSET " + offset + " ROWS FETCH NEXT "+limit+" ROWS ONLY";
			System.out.println(sql);
			
			List<KhachHang> dsKhachHang =session.createNativeQuery(sql, KhachHang.class).getResultList();
			
//			KhachHang khachHang = session.
			tr.commit();
			
			return dsKhachHang ;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			
		}finally {
			session.close();
		}
		return null;
	}
	public static void main(String[] args) {
		SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
		KhachHangDao khachHangDao = new KhachHangDao(sessionFactory);
			khachHangDao.danhSachKhachHang(0, "", "").forEach(e->{
				System.out.println(e);
			});
	}
}
