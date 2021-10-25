package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CongDung {
	@Id
	@Column(columnDefinition = "nvarchar(30)")
	private String maCongDung;
	
	@OneToMany(mappedBy = "congDung")
	private List<Thuoc> thuocs;
	@Column(columnDefinition = "text")
	private String nhomCongDung;
	@Column(columnDefinition = "text")
	private String congDung;
	public CongDung() {
		// TODO Auto-generated constructor stub
	}
}
