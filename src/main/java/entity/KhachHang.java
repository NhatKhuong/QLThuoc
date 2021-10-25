package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class KhachHang {
	@Id
	private String maKhachHang;
	private String tenKhachHang;
	private boolean gioiTinh;
	private String soDienThoai;
	
	@ManyToOne
	@JoinColumn(name = "maDC")
	private DiaChi diaChi;
	
	@OneToMany(mappedBy = "khachHang")
	private List<HoaDon> hoaDons;
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

}
