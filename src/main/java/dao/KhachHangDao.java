package dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.DiaChi;
import entity.KhachHang;

public class KhachHangDao {
	private SessionFactory sessionFactory;
	final private int limit = 2;

	public KhachHangDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public List<KhachHang> danhSachKhachHang(int page, String txtSearch, String gioiTinh) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if (txtSearch == null)
			txtSearch = "";
		if (gioiTinh == null)
			gioiTinh = "";
		int offset = page * limit;// lay du lieu bat dau tu vi tri page*20

		try {
			tr.begin();

			String sql = "select * from KhachHang inner join DiaChi on  KhachHang.maDC = DiaChi.maDC where tenKhachHang like N'%"
					+ txtSearch + "%' and gioiTinh like '%" + gioiTinh + "%'" + " order by maKhachHang desc "
					+ " OFFSET " + offset + " ROWS FETCH NEXT " + limit + " ROWS ONLY";
//			System.out.println(sql);

			List<KhachHang> dsKhachHang = session.createNativeQuery(sql, KhachHang.class).getResultList();

//			KhachHang khachHang = session.
			tr.commit();

			return dsKhachHang;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();

		} finally {
			session.close();
		}
		return null;
	}

	public KhachHang layThongTinKhachHangQuaSDT(String sdt) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select * from KhachHang where soDienThoai = '"+sdt+"'";

			KhachHang khachHang = session.createNativeQuery(sql , KhachHang.class).getSingleResult();

			tr.commit();

			return khachHang;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			tr.rollback();

		} finally {
			session.close();
		}
		return null;
	}
	public boolean themKhachHang (KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
//			KhachHang khachHang =session.createQuery("select * from KhachHang where soDienThoai = :sdt",KhachHang.class).setParameter("sdt", sdt).getSingleResult();
			tr.begin();
			session.save(khachHang);
			tr.commit();

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			tr.rollback();

		} finally {
			session.close();
		}
		return false;
	}
	public boolean suaKhachHang (KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update("KhachHang", khachHang);
			tr.commit();

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();

		} finally {
			session.close();
		}
		return false;
	}
	public boolean kiemTraSoDienThoai(String sdt) {
		return layThongTinKhachHangQuaSDT(sdt) == null ? true : false;
	}
	public static void main(String[] args) {
		SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
		KhachHangDao khachHangDao = new KhachHangDao(sessionFactory);
//		khachHangDao.danhSachKhachHang(0, "", "").forEach(e -> {
//			System.out.println(e);
//		});
//		System.out.println(khachHangDao.suaKhachHang(new KhachHang("KHAA000001", "Son test", false, "0000",new DiaChi("DC-0000012",null,null,null))));
		System.out.println(khachHangDao.kiemTraSoDienThoai("03945664612"));
	}
}
