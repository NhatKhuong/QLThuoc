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
	@Column(columnDefinition = "text")
	private String tenThuoc;
	@Column(columnDefinition = "money")
	private Double giaBan;
	private String donViTinh;
	
	@Column(columnDefinition = "text")
	private String thanhPhan;
	@Column(columnDefinition = "text")
	private String quyCachDongGoi;
	@Column(columnDefinition = "text")
	private String dangBaoChe;
	@Column(columnDefinition = "text")
	private String hamLuong;
	@Column(columnDefinition = "text", name = "cTySanXuat")
	private String congTySanXuat;
	@Column(columnDefinition = "text")
	private String nuocSanXuat;
	@Column(name = "trangThaiKD")
	private boolean trangThaiKinhDoanh;
	private float thueVAT;
	@Column(columnDefinition = "text", name = "soDK")
	private String soDangKy;
	@ManyToOne
	@JoinColumn(name = "maCongDung")
	private CongDung congDung;
	
	@OneToMany(mappedBy = "thuoc")
	private List<CT_HoaDon> ct_HoaDons;
	
	private int soLuongBanDau;
	private Date hanSuDung;
	
//	[maThuoc]
//		      ,[cTySanXuat]
//		      ,[dangBaoChe]
//		      ,[donViTinh]
//		      ,[giaBan]
//		      ,[hamLuong]
//		      ,[hanSuDung]
//		      ,[nuocSanXuat]
//		      ,[quyCachDongGoi]
//		      ,[soDK]
//		      ,[soLuongBanDau]
//		      ,[tenThuoc]
//		      ,[thanhPhan]
//		      ,[thueVAT]
//		      ,[trangThaiKD]
//		      ,[maCongDung]

}
