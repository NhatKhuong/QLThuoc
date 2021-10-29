package dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.HoaDon;

public class HoaDonDao {
	private SessionFactory sessionFactory;

	public HoaDonDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public HoaDon getHoaDonById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			HoaDon hoaDon = session.find(HoaDon.class,id);
			tr.commit();
			
			return hoaDon;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
		
	}
	
	public List<HoaDon> getDanhSachHoaDon(String maHD,String tenKH,String sdtKH,String sdtNV,String ngayLapHD,int cmb,int page){
		long millis=System.currentTimeMillis();
		Date date = new java.sql.Date(millis);
		
		if (maHD == null)
			maHD = "";
		if (tenKH == null)
			tenKH = "";
		if (sdtKH == null)	
			sdtKH = "";
		if (sdtNV == null)
			sdtNV = "";
		if (ngayLapHD == null)
			ngayLapHD = "";
		if (cmb == 0) {
			date = java.sql.Date.valueOf("0001-01-1");
		}else if(cmb == 1) {
			date = java.sql.Date.valueOf(LocalDate.now().toString());
		}else if(cmb == 2) {
			date = java.sql.Date.valueOf(LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-1");
		}else if(cmb == 3) {
			date = java.sql.Date.valueOf(LocalDate.now().getYear()+"-01-1");
		}
		int offset = page*20;
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		List<HoaDon> hoaDons = null;
		try {
			
			tr.begin();
			String sql = "select * from [dbo].[KhachHang] join [dbo].[HoaDonBan] on [dbo].[KhachHang].maKhachHang = [dbo].[HoaDonBan].maKhachHang\r\n"
					+ "  join [dbo].[NhanVien] on [dbo].[NhanVien].maNhanVien = [dbo].[HoaDonBan].maNhanVien where "
					+ "maHoaDonBan like '%"
					+ maHD 
					+ "%' and tenKhachHang like N'%"
					+ tenKH
					+ "%' and soDienThoai like N'%"
					+ sdtKH
					+ "%' and soDienThoaiNV like '%"
					+ sdtNV
					+ "%' and ngayLapHDBan like '%"
					+ ngayLapHD
					+ "%' and ngayLapHDBan >= '"
					+ date
					+"' order by maHoaDonBan desc" + " OFFSET " + offset + " ROWS FETCH NEXT 20 ROWS ONLY";
			hoaDons = session.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return hoaDons;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		
		session.close();
		return null;
		
	}
	
	public boolean addHoaDon(HoaDon hoaDon) {
		
		Session session =sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(hoaDon);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		session.close();
		return false;
		
	}

}
