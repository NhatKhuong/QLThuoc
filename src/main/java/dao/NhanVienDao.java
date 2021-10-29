package dao;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.DiaChi;
import entity.KhachHang;
import entity.NhanVien;

public class NhanVienDao {
	private SessionFactory sessionFactory;
	final private int limit = 2;

	public NhanVienDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public List<NhanVien> danhSachNhanVien(int page, String txtSearch, String gioiTinh, boolean trangThaiLamViec) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		if (txtSearch == null)
			txtSearch = "";
		if (gioiTinh == null)
			gioiTinh = "";
		String ttlv = trangThaiLamViec ? "0" : "1";
		int offset = page * limit;// lay du lieu bat dau tu vi tri page*20

		try {
			tr.begin();

			String sql = "select * from NhanVien inner join DiaChi on  NhanVien.maDC = DiaChi.maDC where tenNhanVien like N'%"
					+ txtSearch + "%'  and trangThaiLamViec like '%" + ttlv + "%' " + " order by maNhanVien desc"
					+ " OFFSET " + offset + " ROWS FETCH NEXT " + limit + " ROWS ONLY;";

//			"from ModelClassname where ClassVariableId= :ClassVariableId"
//			Query q = session.createQuery(sql);
//			q.setParameter("ClassVariableId", 001);

			List<NhanVien> dsNhanVien = session.createNativeQuery(sql, NhanVien.class).getResultList();

//			KhachHang khachHang = session.
			tr.commit();

			return dsNhanVien;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();

		} finally {
			session.close();
		}
		return null;
	}

	public boolean thayDoiTrangThaiLamViec(String maNhanVien, boolean trangThaiLamViec) {
		String sql = "UPDATE NhanVien set trangThaiLamViec = :trangThaiLamViec WHERE maNhanVien = :maNhanVien ";
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			Query query = session.createQuery(sql);

			query.setParameter("trangThaiLamViec", trangThaiLamViec);
			query.setParameter("maNhanVien", maNhanVien);
			int result = query.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();

		} finally {
			session.close();
		}
		return false;
	}
	public boolean themNhanVien (NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
//			KhachHang khachHang =session.createQuery("select * from KhachHang where soDienThoai = :sdt",KhachHang.class).setParameter("sdt", sdt).getSingleResult();
			tr.begin();
			session.save(nhanVien);
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
	public boolean suaNhanVien (NhanVien nhanVien) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update("NhanVien", nhanVien);
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
	public NhanVien layThongTinNhanVienQuaSDT(String sdt) {

		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select * from nhanVien where soDienThoaiNV = '"+sdt+"'";

			NhanVien nhanVien = session.createNativeQuery(sql , NhanVien.class).getSingleResult();

			tr.commit();

			return nhanVien;
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			tr.rollback();

		} finally {
			session.close();
		}
		return null;
	}
	public boolean kiemTraSoDienThoai( String sdt) {
		return layThongTinNhanVienQuaSDT(sdt) == null ? true : false;
	}
	public  boolean kiemTraSoChungMinhNhanDan( String cmnd) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select * from nhanVien where cmnd = '"+cmnd+"'";
			NhanVien nhanVien = session.createNativeQuery(sql , NhanVien.class).getSingleResult();
			tr.commit();
			if(nhanVien == null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			tr.rollback();

		} finally {
			session.close();
		}
		return false;
	}
	public  boolean dangNhap( String sdt,String pass) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();

		try {
			tr.begin();
			String sql = "select * from nhanVien where soDienThoaiNV = '"+sdt+"' and passLogin = '"+pass+"'" ;
			NhanVien nhanVien = session.createNativeQuery(sql , NhanVien.class).getSingleResult();
			tr.commit();
			if(nhanVien != null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			tr.rollback();

		} finally {
			session.close();
		}
		return false;
	}
//	public static void main(String[] args) {
//		SessionFactory sessionFactory = new MySessionFactory().getSessionFactory();
//
//		NhanVienDao nhanVienDao = new NhanVienDao(sessionFactory);
//		System.out.println(nhanVienDao.layThongTinNhanVienQuaSDT("0945601318"));
//		System.out.println(nhanVienDao.kiemTraSoChungMinhNhanDan("8563780921"));
//		System.out.println(nhanVienDao.dangNhap("0945601318", "1231"));
		
////		System.out.println(nhanVienDao.thayDoiTrangThaiLamViec("NVAA000001", false));
//		System.out.println(nhanVienDao.themNhanVien(new NhanVien("1", "son", false, "0", "0", false, "0", false, new DiaChi("DC-0000003"))));
//		System.out.println(nhanVienDao.suaNhanVien(new NhanVien("NVAA000001", "son update", false, "0", "0", false, "0", false, new DiaChi("DC-0000003"))));
//	}
	
}
