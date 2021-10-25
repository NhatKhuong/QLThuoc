package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class NhanVien {
	@Id
	private String maNhanVien;
	private String tenNhanVien;
	private boolean gioiTinh;
	@Column(columnDefinition = "nvarchar(11)")
	private String soDienThoaiNV;
	private String passLogin;
	private boolean trangThaiLamViec;
	private String cmnd;
	private boolean loaiNV;
	
	
	@OneToMany(mappedBy = "nhanVien")
	private List<HoaDon> hoaDons;
	
	@ManyToOne
	@JoinColumn(name = "maDC")
	private DiaChi diaChi;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
}
