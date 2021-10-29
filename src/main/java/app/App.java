package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import dao.HoaDonDao;
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
		HoaDonDao daoHoaDon = new HoaDonDao(sessionFactory);
//		System.out.println(dao.getThuocById("DPAA000002"));
		
//		Thuoc thuoc = dao.getThuocById("DPAA000001");
//		System.out.println(thuoc);
//		thuoc.setNuocSanXuat("Mỹ");
//		thuoc.setSoLuongBanDau(50);
//		System.out.println(dao.update(thuoc));
//		System.out.println(thuoc);
//		System.out.println(dao.getThuocById("DPAA000001"));
//		System.out.println(dao.setTrangThaiKinhDoanh("DPAA000001", true));
//		System.out.println(dao.getThuocById("DPAA000001"));
		
		
//		List<Thuoc> thuoList = dao.danhSachThuoc(0,"A","","","","","","");
//		thuoList.forEach(thuoc->{
//			System.out.println(thuoc);
//		});
		
//		System.out.println(daoHoaDon.getHoaDonById("BTAA000001"));
		daoHoaDon.getDanhSachHoaDon("","A","","","", 0, 0)
		.forEach(item->{
			System.out.println(item);
		});
		
		
		
	}

}
