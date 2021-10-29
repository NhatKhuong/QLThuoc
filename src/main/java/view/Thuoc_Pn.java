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
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.table.DefaultTableModel;
import entity.CongDung;
import entity.Thuoc;

public class Thuoc_Pn extends JPanel implements ActionListener, KeyListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField txtTen;
	private static JTextField txtHoatChat;
	private static JTable table;
	private JButton btnLui1;
	private JButton btnTien1;
	private JButton btnTienCuoi;
	private JButton btnLuiCuoi;
	private static JLabel lblSoTrang;
	private JButton btnNgungBan;
	private JButton btnChiTiet;
	private JButton btnSuaChua;
	private JButton btnLamMoi;
	private static JComboBox<String> cboNuocSanXuat;
	private static JComboBox<String> cboDVT;
	private static JComboBox<String> cboDangBaoChe;
	private static JComboBox<String> cboNCongDung;
	private static JComboBox<String> cboCongDung;
	private static DefaultTableModel model;

	private static ArrayList<Thuoc> listThuoc;

	/**
	 * Create the panel.
	 */
	public Thuoc_Pn() {

		setBackground(Color.white);
		setLayout(null);
		setSize(1353, 570);

		JLabel lblNewLabel = new JLabel("Tên thuốc: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(79, 11, 98, 22);
		add(lblNewLabel);

		JLabel lblHotCht = new JLabel("Hoạt chất: ");
		lblHotCht.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHotCht.setBounds(671, 11, 98, 22);
		add(lblHotCht);

		JLabel lblNhpm = new JLabel("N.Công dụng: ");
		lblNhpm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNhpm.setBounds(79, 44, 109, 22);
		add(lblNhpm);

		JLabel lblCngDng = new JLabel("Công dụng: ");
		lblCngDng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng.setBounds(671, 44, 98, 22);
		add(lblCngDng);

		txtTen = new JTextField();
		txtTen.setBounds(216, 11, 400, 30);
	    add(txtTen);
		txtTen.setColumns(10);

		txtHoatChat = new JTextField();
		txtHoatChat.setColumns(10);
		txtHoatChat.setBounds(790, 11, 400, 30);
		add(txtHoatChat);

		cboNCongDung = new JComboBox<String>();
		cboNCongDung.setBounds(216, 47, 400, 30);
		add(cboNCongDung);

		cboCongDung = new JComboBox<String>();
		cboCongDung.setBounds(790, 47, 400, 30);
		add(cboCongDung);

		JLabel lblDngBoCh = new JLabel("Dạng bào chế: ");
		lblDngBoCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDngBoCh.setBounds(79, 84, 109, 22);
		add(lblDngBoCh);

		cboDangBaoChe = new JComboBox<String>();
		cboDangBaoChe.setBounds(216, 84, 400, 30);
		add(cboDangBaoChe);

		JLabel lblCngDng_1 = new JLabel("ĐVTính: ");
		lblCngDng_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng_1.setBounds(671, 84, 98, 22);
		add(lblCngDng_1);

		cboDVT = new JComboBox<String>();
		cboDVT.setBounds(790, 84, 125, 30);
		add(cboDVT);

		JLabel lblCngDng_1_1 = new JLabel("Nước SX: ");
		lblCngDng_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng_1_1.setBounds(957, 84, 98, 22);
		add(lblCngDng_1_1);

		cboNuocSanXuat = new JComboBox<String>();
		cboNuocSanXuat.setBounds(1065, 84, 125, 30);
		add(cboNuocSanXuat);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 102));
		panel.setBounds(0, 124, 1300, 35);
		add(panel);
		panel.setLayout(null);

		btnNgungBan = new JButton("Ngừng bán");
		btnNgungBan.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/stopping.png")));
		btnNgungBan.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNgungBan.setBounds(340, 0, 140, 35);
		panel.add(btnNgungBan);

		btnChiTiet = new JButton("Chi tiết");
		btnChiTiet.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/description.png")));
		btnChiTiet.setFont(new Font("Arial", Font.PLAIN, 14));
		btnChiTiet.setBounds(501, 0, 140, 35);
		panel.add(btnChiTiet);

		btnSuaChua = new JButton("Sửa");
		btnSuaChua.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/repair.png")));
		btnSuaChua.setFont(new Font("Arial", Font.PLAIN, 14));
		btnSuaChua.setBounds(663, 0, 140, 35);
		panel.add(btnSuaChua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLamMoi.setBounds(825, 0, 140, 35);
		panel.add(btnLamMoi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 170, 1267, 362);
		add(scrollPane);
		model = new DefaultTableModel(new String[] { "Tên thuốc", "Thành phần", "Dạng bào chế", "ĐVT", "Hàm lượng",
				"Nước sản xuất", "Nhóm công dụng", "Công dụng", "Giá (Vnđ)", "Số lượng" ,"Trạng Thái kinh doanh"}, 0);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 533, 1300, 37);
		add(panel_1);
		panel_1.setLayout(null);

		btnLuiCuoi = new JButton("");
		btnLuiCuoi.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/previousEnd.png")));
		btnLuiCuoi.setBounds(442, 3, 89, 30);
		panel_1.add(btnLuiCuoi);

		btnLui1 = new JButton("");
		btnLui1.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/rewind-button.png")));
		btnLui1.setBounds(541, 3, 89, 30);
		panel_1.add(btnLui1);

		btnTien1 = new JButton("");
		btnTien1.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/nextbutton.png")));
		btnTien1.setBounds(701, 3, 89, 30);
		panel_1.add(btnTien1);

		btnTienCuoi = new JButton("");
		btnTienCuoi.setIcon(new ImageIcon(Thuoc_Pn.class.getResource("/img/nextEnd.png")));
		btnTienCuoi.setBounds(811, 3, 89, 30);
		panel_1.add(btnTienCuoi);

		lblSoTrang = new JLabel("1");
		lblSoTrang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoTrang.setBounds(645, 3, 46, 30);
		panel_1.add(lblSoTrang);

		table.setRowHeight(35);
		cboDangBaoChe.setFont(new Font("Arial", Font.PLAIN, 16));
		cboDangBaoChe.setModel(new DefaultComboBoxModel<String>(new String[] {"Tất cả", "dung dịch tiêm",
				"Thuốc tiêm (gây tê tủy sống)", "Nhũ dịch tiêm truyền", "dung dịch để hít",
				"Chất lỏng dễ bay hơi dùng gây mê đường hô hấp", "hơi dùng gây mê đường hô hấp", "Thuốc tiêm", "Gel",
				"Kem bôi", "Nhũ tương dùng tiêm hoặc truyền tĩnh mạch", "Nhũ tương tiêm hoặc truyền tĩnh mạch",
				"Nhũ tương để tiêm hoặc tiêm truyền tĩnh mạch", "Nhũ tương để tiêm hoặc truyền", "Dung dịch hít",
				"Chất lỏng dễ bay hơi dung gây mê đường hô hấp", "Viên nang", "Viên nang cứng ( trắng - trắng)",
				"Viên nang cứng", "Gel bôi ngoài da", "Dung dịch nhỏ mắt", "Viên nén", "viên nén bao phim",
				"Miếng dán phóng thích qua da", "dung dịch tiêm", "Viên sủi", "Viên", "Dung dịch tiêm truyền tĩnh mạch",
				"dung dịch tiêm truyền", "dung dịch truyền tĩnh mạch", "Bột pha dung dịch đậm đặc pha dung dịch truyền",
				"Dung dịch đậm đặt để pha dung dịch tiêm truyền", "Dung dịch tiêm truyền",
				"Dung dịch đậm đặc pha tiêm truyền", "thuốc tiêm đông khô",
				"Dung dịch đậm đặc để tiêm hoặc tiêm truyền tĩnh mạ", "Thuốc Bột", "bột pha tiêm",
				"dung dịch vô khuẩn dùng trong phẫu thuật", "Viên tác dụng kéo dài", "viên nén dài bao phim",
				"viên bao phim tan trong ruột", "Viên nén bao phim phóng thích kéo dài", "viên nén dài",
				"Viên nang cam-kem", "Bột pha dung dịch tiêm hoặc truyền tĩnh mạch", "thuốc tiêm bột",
				"Viên nén bao phim giải phóng chậm", "viên nang cứng (xám+vàng)", "Bột pha dung dịch tiêm/truyền",
				"Hộp 1 lọ thuốc + 1 ống 10 ml dung môi pha tiêm", "Thuốc tiêm",
				"Bột pha dung dịch tiêm/truyền tĩnh mạch", "bột đông khô pha tiêm hoặc tiêm truyền" }));

		cboNuocSanXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		cboNuocSanXuat.setModel(new DefaultComboBoxModel<String>(
				new String[] {"Tất cả", "Việt Nam", "Pháp", "India", "France", "Đức", "Germany", "Anh", "Mỹ",
						"Na Uy, đóng gói Ý", "Italy", "VietNam", "Ý, đóng gói Anh", "Áo", "Mỹ, Đóng gói Đức", "Thụy Sỹ",
						"Slovenia", "Hàn Quốc", "Tây Ban Nha, đóng gói Anh", "Bỉ", "Indonesia", "Hy Lạp", "Ukraine",
						"Cyprus", "Ý", "Greece", "Thụy Sỹ (xuất xưởng: Hà Lan)", "Síp", "Nhật", "Bồ Đào Nha", "Hungary",
						"Taiwan", "Poland", "Korea", "Mỹ; Đóng gói: Đức", "Bỉ", "Ấn Độ", "Bulgaria", "Portugal" }));

		cboDVT.setFont(new Font("Arial", Font.PLAIN, 16));
		cboDVT.setModel(new DefaultComboBoxModel<String>(new String[] {"Tất cả", "Bịch nhựa", "Lọ", "Ống", "Chai", "Tuýp", "Hộp",
				"Viên", "Miếng", "Viên sủi", "Chai thủy tinh", "Chai nhựa" }));

		cboNCongDung.addItem("Tất cả");
		cboNCongDung.setFont(new Font("Arial", Font.PLAIN, 16));
//		ArrayList<CongDung> list1 = new DAO_CongDung().getNCongDung();
//		for (CongDung congDung : list1) {
//			cboNCongDung.addItem(congDung.getNhomCongDung());
//		}
		
		cboCongDung.addItem("Tất cả");
		cboCongDung.setFont(new Font("Arial", Font.PLAIN, 16));
//		ArrayList<CongDung> list2 = new DAO_CongDung().getCongDung();
//		for (CongDung congDung : list2) {
//			cboCongDung.addItem(congDung.getCongDung());
//		}
//
//		addInToTable();

		btnChiTiet.addActionListener(this);
		btnLui1.addActionListener(this);
		btnLuiCuoi.addActionListener(this);
		btnTien1.addActionListener(this);
		btnTienCuoi.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnSuaChua.addActionListener(this);
		btnNgungBan.addActionListener(this);

		txtTen.addKeyListener(this);
		txtHoatChat.addKeyListener(this);

		cboCongDung.addActionListener(this);
		cboDangBaoChe.addActionListener(this);
		cboDVT.addActionListener(this);
		cboNCongDung.addActionListener(this);
		cboNuocSanXuat.addActionListener(this);

		table.addMouseListener(this);
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
