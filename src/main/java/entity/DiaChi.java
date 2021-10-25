package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class DiaChi {
	@Id
	@Column(columnDefinition = "nvarchar(10)")
	private String maDC;
	@Column(columnDefinition = "nvarchar(255)")
	private String tinhTp;
	@Column(columnDefinition = "nvarchar(255)")
	private String quanHuyen;
	@Column(columnDefinition = "nvarchar(255)")
	private String phuongXa;
	
	@OneToMany(mappedBy = "diaChi")
	private List<NhanVien> nhanList;
	
	@OneToMany(mappedBy = "diaChi")
	private List<KhachHang> khList;
	
	
	public DiaChi() {
		// TODO Auto-generated constructor stub
	}
	
}