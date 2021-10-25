package entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "HoaDonBan")
public class HoaDon {
	@Id
	private String maHoaDonBan;
	private Date ngayLapHDBan;
	@Column(columnDefinition = "money")
	private double tienNhan;
	
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	
	@OneToMany(mappedBy = "hoaDon")
//	@Embedded
	private List<CT_HoaDon> ct_HoaDons;
	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

}
