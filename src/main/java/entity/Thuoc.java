package entity;

import java.sql.Date;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Thuoc {
	@Id
//	@Column(columnDefinition = "nvarchar(30)")
	
	private String maThuoc;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenThuoc;
	@Column(columnDefinition = "money")
	private Double giaBan;
	private String donViTinh;
	@Column(columnDefinition = "nvarchar(255)")
	private String thanhPhan;
	@Column(columnDefinition = "nvarchar(255)")
	private String quyCachDongGoi;
	@Column(columnDefinition = "nvarchar(255)")
	private String dangBaoChe;
	private String hamLuong;
	@Column(name = "cTySanXuat",columnDefinition = "nvarchar(255)")
	private String congTySanXuat;
	@Column(columnDefinition = "nvarchar(255)")
	private String nuocSanXuat;
	@Column(name = "trangThaiKD")
	private boolean trangThaiKinhDoanh;
	private float thueVAT;
	@Column(name = "soDK")
	private String soDangKy;
	@ManyToOne
	@JoinColumn(name = "maCongDung")
	private CongDung congDung;
	
	private int soLuongBanDau;
	private Date hanSuDung;
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", giaBan=" + giaBan + ", donViTinh="
				+ donViTinh + ", thanhPhan=" + thanhPhan + ", quyCachDongGoi=" + quyCachDongGoi + ", dangBaoChe="
				+ dangBaoChe + ", hamLuong=" + hamLuong + ", congTySanXuat=" + congTySanXuat + ", nuocSanXuat="
				+ nuocSanXuat + ", trangThaiKinhDoanh=" + trangThaiKinhDoanh + ", thueVAT=" + thueVAT + ", soDangKy="
				+ soDangKy + ", soLuongBanDau=" + soLuongBanDau + ", hanSuDung=" + hanSuDung + "]";
	}

	
	
	
	
	

}
