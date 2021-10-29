package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import entity.CT_HoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;
import view.DialogThemKhachHang.DialogThemKhachHangResponse;

public class CuaHang_Pn extends JPanel implements ActionListener, MouseListener, KeyListener, ChangeListener {
	String pattern = "###,###.###";
	DecimalFormat decimalFormat = new DecimalFormat(pattern);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtThanhPhan;
	private static JTable tableThuoc;
	private DefaultTableModel modelThuoc;
	private JTable tableDanhMuc;
	private JTextField txtTimSDT;
	private JTextField txtTienNhan;
	private JTextField txtTenThuoc_pnCuaHang;
	private JScrollPane scrollPane;
	private JComboBox cbDonViTinh_pnCuaHang;
	private JComboBox cbCongDung_pnCuaHang;
	private JTextField txtSoLuongThem;
	private DefaultTableModel tableModelThuoc;
	private DefaultTableModel tableModelDanhMuc;
	private JButton btnThem;
	private JLabel lblTenKhachHang;
	private JButton btnThemKhachHang;
	private JLabel lblTongTien;
	private JLabel lblTienThoi;
	private JButton btnHuyDon;
	private JButton btnThanhToan;
	private JLabel lblKiemTraTienNhap;
	private JButton btnXemChiTiet;
	private JButton btnLuiCuoi;
	private JButton btnLui1;
	private JButton btnTien1;
	private JButton btnTienCuoi;
	private JButton btnLamMoiTimKiem;
	private JLabel lblSoTrang;
	private JButton btnTimSDT;
	private ArrayList<Thuoc> listDanhMucThuoc;
	private JLabel lblnVTnh;

	/**
	 * Create the panel.
	 */
	public CuaHang_Pn() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1310, 599);

		JLabel lblNewLabel = new JLabel("T\u00EAn thu\u1ED1c: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(88, 11, 117, 30);
		add(lblNewLabel);

		JLabel lblHotCht = new JLabel("Hoạt chất:");
		lblHotCht.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotCht.setBounds(720, 11, 117, 30);
		add(lblHotCht);

		txtTenThuoc_pnCuaHang = new JTextField();
		txtTenThuoc_pnCuaHang.setBounds(202, 11, 400, 30);
		add(txtTenThuoc_pnCuaHang);
		txtTenThuoc_pnCuaHang.setColumns(10);

		JLabel lblHotCht_2 = new JLabel("C\u00F4ng d\u1EE5ng: ");
		lblHotCht_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotCht_2.setBounds(721, 47, 117, 30);
		add(lblHotCht_2);

		JLabel lblHotCht_3 = new JLabel("ĐVTính: ");
		lblHotCht_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblHotCht_3);

		cbDonViTinh_pnCuaHang = new JComboBox();
		cbDonViTinh_pnCuaHang.setBounds(202, 47, 400, 30);
		add(cbDonViTinh_pnCuaHang);

		cbCongDung_pnCuaHang = new JComboBox();
		cbCongDung_pnCuaHang.setBounds(824, 47, 400, 30);
		add(cbCongDung_pnCuaHang);

		txtThanhPhan = new JTextField();
		txtThanhPhan.setColumns(10);
		txtThanhPhan.setBounds(824, 11, 400, 30);
		add(txtThanhPhan);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 102));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBounds(0, 366, 1284, 25);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Danh mục thuốc");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(347, 5, 113, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(1009, 5, 113, 14);
		panel_1.add(lblNewLabel_1_1);
		// String title[] = {"Mã thuốc","Tên thuốc", "Thành phần",
		// "Dạng bào chế", "ĐVT", "Hàm lượng", "Công dụng",
		// "Hạn sử dụng","Số lượng","Trạng thái", "Giá (VND)"};
		// modelThuoc = new DefaultTableModel(title,0);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 89, 1284, 240);
		add(scrollPane);
		tableThuoc = new JTable();
		scrollPane.setViewportView(tableThuoc);

		tableThuoc.setModel(tableModelThuoc = new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã thuốc", "Tên thuốc", "Thành phần", "Dạng bào chế", "ĐVT", "Hàm lượng", "Công dụng",
				"Hạn sử dụng", "Số lượng", "Trạng thái", "Giá (VND)"
				// "T\u00EAn thu\u1ED1c", "Th\u00E0nh ph\u1EA7n",
				// "D\u1EA1ng b\u00E0o ch\u1EBF", "\u0110VT",
				// "H\u00E0m l\u01B0\u1EE3ng", "C\u00F4ng d\u1EE5ng",
				// "H\u1EA1n s\u1EED d\u1EE5ng", "S\u1ED1 l\u01B0\u1EE3ng",
				// "Tr\u1EA1ng th\u00E1i", "Gi\u00E1 (VND)"
		}));
		tableThuoc.setRowHeight(35);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 394, 770, 178);
		add(scrollPane_1);

		tableDanhMuc = new JTable();
		scrollPane_1.setViewportView(tableDanhMuc);
		tableDanhMuc.setModel(tableModelDanhMuc = new DefaultTableModel(new Object[][] {}, new String[] { "Tên thuốc",
				"Thành phần", "Hàm lượng", "Số lượng", "Công dụng", "Giá (VNĐ)", "Thành tiền" }));
		tableDanhMuc.setRowHeight(32);
		// tableDanhMuc.setEnabled(false);
		JLabel lblTmSt = new JLabel("Tìm SĐT: ");
		lblTmSt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTmSt.setBounds(780, 417, 67, 14);
		add(lblTmSt);

		JLabel lblTnKhchHng = new JLabel("Tên KH: ");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnKhchHng.setBounds(780, 454, 67, 19);
		add(lblTnKhchHng);

		JLabel lblTngTin = new JLabel("Tổng tiền: ");
		lblTngTin.setToolTipText("Đã bao gồm 10% VAT");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTngTin.setBounds(1052, 454, 102, 19);
		add(lblTngTin);

		JLabel lblTinNhn = new JLabel("Tiền nhận: ");
		lblTinNhn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTinNhn.setBounds(782, 488, 89, 29);
		add(lblTinNhn);

		JLabel lblTinThi = new JLabel("Tiền thối: ");
		lblTinThi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTinThi.setBounds(1052, 488, 79, 29);
		add(lblTinThi);

		txtTimSDT = new JTextField();
		txtTimSDT.setBounds(862, 412, 175, 30);
		add(txtTimSDT);
		txtTimSDT.setColumns(10);

		txtTienNhan = new JTextField();
		txtTienNhan.setColumns(10);
		txtTienNhan.setBounds(862, 488, 175, 30);
		add(txtTienNhan);

		btnThemKhachHang = new JButton("Thêm KH");
		btnThemKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemKhachHang.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/them.png")));
		btnThemKhachHang.setBounds(1117, 412, 117, 30);
		add(btnThemKhachHang);

		lblTenKhachHang = new JLabel("");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenKhachHang.setBounds(862, 450, 170, 30);
		add(lblTenKhachHang);

		lblTongTien = new JLabel("");
		lblTongTien.setToolTipText("Đã bao gồm 10% VAT");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongTien.setBounds(1153, 450, 141, 29);
		add(lblTongTien);

		lblTienThoi = new JLabel("");
		lblTienThoi.setForeground(Color.RED);
		lblTienThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienThoi.setBounds(1153, 488, 141, 29);
		add(lblTienThoi);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/them.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(171, 330, 150, 35);
		add(btnThem);

		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/description.png")));
		btnXemChiTiet.setFont(new Font("Arial", Font.PLAIN, 14));
		btnXemChiTiet.setBounds(0, 330, 149, 35);
		add(btnXemChiTiet);

		btnLamMoiTimKiem = new JButton("Làm mới tìm kiếm");
		btnLamMoiTimKiem.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/lam_moi.png")));
		btnLamMoiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoiTimKiem.setBounds(1115, 330, 170, 35);
		add(btnLamMoiTimKiem);

		btnHuyDon = new JButton("Hủy đơn");
		btnHuyDon.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/stopping.png")));
		btnHuyDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuyDon.setBounds(862, 535, 175, 35);
		add(btnHuyDon);

		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/pay.png")));
		btnThanhToan.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThanhToan.setBounds(1059, 535, 175, 35);
		add(btnThanhToan);

		txtSoLuongThem = new JTextField();
		txtSoLuongThem.setBounds(370, 330, 60, 35);
		add(txtSoLuongThem);
		txtSoLuongThem.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("SL:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(330, 330, 40, 35);
		add(lblNewLabel_3);

		btnTien1 = new JButton("");
		btnTien1.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/forward-button.png")));
		btnTien1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTien1.setBounds(747, 333, 100, 30);
		add(btnTien1);

		btnLui1 = new JButton("");
		btnLui1.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/rewind-button.png")));
		btnLui1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLui1.setBounds(587, 333, 100, 30);
		add(btnLui1);

		btnTienCuoi = new JButton("");
		btnTienCuoi.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/nextEnd.png")));
		btnTienCuoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTienCuoi.setBounds(857, 333, 100, 30);
		add(btnTienCuoi);

		btnLuiCuoi = new JButton("");
		btnLuiCuoi.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/previousEnd.png")));
		btnLuiCuoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLuiCuoi.setBounds(477, 333, 100, 30);
		add(btnLuiCuoi);

		lblSoTrang = new JLabel("1");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSoTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoTrang.setBounds(687, 333, 60, 28);
		add(lblSoTrang);

		btnTimSDT = new JButton("");
		btnTimSDT.setBackground(Color.WHITE);
		btnTimSDT.setIcon(new ImageIcon(CuaHang_Pn.class.getResource("/img/Search.png")));
		btnTimSDT.setBounds(1057, 412, 50, 30);
		add(btnTimSDT);

		lblKiemTraTienNhap = new JLabel("");
		lblKiemTraTienNhap.setBounds(1034, 490, 30, 26);
		add(lblKiemTraTienNhap);
//
//		addItemInToCbDVT();
//		addItemInToCbCongDung();

		btnThem.addActionListener(this);
		txtSoLuongThem.addActionListener(this);
		tableThuoc.addMouseListener(this);
		tableDanhMuc.addMouseListener(this);
		txtTimSDT.addActionListener(this);
		txtTienNhan.addKeyListener(this);
		btnLamMoiTimKiem.addActionListener(this);
		btnLui1.addActionListener(this);
		btnLuiCuoi.addActionListener(this);
		btnTien1.addActionListener(this);
		btnTienCuoi.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnHuyDon.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemKhachHang.addActionListener(this);
		btnHuyDon.addActionListener(this);
		cbCongDung_pnCuaHang.addActionListener(this);
		cbDonViTinh_pnCuaHang.addActionListener(this);
		txtThanhPhan.addKeyListener(this);
		txtTenThuoc_pnCuaHang.addKeyListener(this);
		btnTimSDT.addActionListener(this);

		JLabel lblNewLabel_2 = new JLabel("(Đã bao gồm 10% VAT)");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblNewLabel_2.setBounds(1052, 475, 104, 13);
		add(lblNewLabel_2);

		lblnVTnh = new JLabel("Đơn vị tính:");
		lblnVTnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnVTnh.setBounds(88, 47, 117, 30);
		add(lblnVTnh);
		listDanhMucThuoc = new ArrayList<Thuoc>();

		// khong cho sua table
		tableThuoc.setDefaultEditor(Object.class, null);
		tableDanhMuc.setDefaultEditor(Object.class, null);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
