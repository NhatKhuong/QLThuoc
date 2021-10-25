package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
//@Embeddable
@Table(name = "CT_HoaDonBan")
@IdClass(CT_HoaDonPK.class)
public class CT_HoaDon {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maHoaDon")
	private HoaDon hoaDon;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maThuoc")
	private Thuoc thuoc;
	
	
	private int soLuong;
	@Column(columnDefinition = "money")
	private double giaBan;
	private float thueVat;
	public CT_HoaDon() {
		// TODO Auto-generated constructor stub
	}

}
