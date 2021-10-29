 
package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class KhachHang_Pn extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel lblNewLabel_1;
	private JComboBox<String> cbGioiTinh;
	private JTextField txtSearch;
	private JButton btnTim;
	private JButton btnLamMoi;
	private JLabel txtPage;
	private JButton btnDau;
	private JButton btnTru1;
	private JButton btnCong1;
	private JButton btnCuoi;
	private JButton btnThemKhachHang;
	private JButton btnSua;

	public KhachHang_Pn() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nh\u1EADp t\u00EAn: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 10, 91, 41);
		add(lblNewLabel);

		txtSDT = new JTextField();
		txtSDT.setBounds(100, 61, 782, 35);
		add(txtSDT);
		txtSDT.setColumns(10);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "(Tất cả)", "Nam", "Nữ" }));
		cbGioiTinh.setBounds(1022, 13, 120, 35);
		cbGioiTinh.addActionListener(this);
		add(cbGioiTinh);

		lblNewLabel_1 = new JLabel("Giới tính");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(892, 13, 120, 35);
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 108, 1300, 1);
		add(panel);

		btnThemKhachHang = new JButton("Th\u00EAm");
		btnThemKhachHang.addActionListener(this);
		btnThemKhachHang.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/them.png")));
		btnThemKhachHang.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThemKhachHang.setBounds(1022, 59, 120, 35);
		add(btnThemKhachHang);

		btnSua = new JButton("S\u1EEFa");
		btnSua.addActionListener(this);
		btnSua.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/cap_nhat.png")));
btnSua.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSua.setBounds(1152, 59, 120, 35);
		add(btnSua);

		btnDau = new JButton("");
		btnDau.addActionListener(this);
		btnDau.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/previousEnd.png")));
		btnDau.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDau.setBounds(422, 530, 80, 30);
		add(btnDau);

		btnTru1 = new JButton("");
		btnTru1.addActionListener(this);
		btnTru1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/rewind-button.png")));
		btnTru1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTru1.setBounds(517, 530, 80, 30);
		add(btnTru1);

		btnCong1 = new JButton("");
		btnCong1.addActionListener(this);
		btnCong1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/forward-button.png")));
		btnCong1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCong1.setBounds(696, 530, 80, 30);
		add(btnCong1);

		JLabel lblNhpSdt = new JLabel("Nhập SDT: ");
		lblNhpSdt.setForeground(Color.BLACK);
		lblNhpSdt.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSdt.setBounds(10, 58, 91, 41);
		add(lblNhpSdt);

		txtSearch = new JTextField();
		txtSearch.setColumns(10);

		txtSearch.setBounds(100, 15, 782, 35);
		txtSearch.addKeyListener(this);
		add(txtSearch);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(this);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(1152, 13, 120, 35);
		add(btnLamMoi);

		btnCuoi = new JButton("");
		btnCuoi.addActionListener(this);
		btnCuoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/nextEnd.png")));
		btnCuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCuoi.setBounds(791, 530, 80, 30);
		add(btnCuoi);

		txtPage = new JLabel("1");
		txtPage.setForeground(new Color(0, 0, 0));
		txtPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPage.setBounds(644, 530, 46, 30);
		add(txtPage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 119, 1290, 401);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Mã khách hàng",
				"Tên Khách hàng", "Giới tính", "SDT", "Tỉnh/TP", "Quận/Huyện", "Phường xã" }));
		table.setRowHeight(35);

		btnTim = new JButton("Tim");
		btnTim.setIcon(new ImageIcon(KhachHang_Pn.class.getResource("/img/Search.png")));
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTim.addActionListener(this);
		btnTim.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTim.setBounds(892, 59, 120, 35);
		add(btnTim);
//		themDuLieuVaoTable();

		// khong cho sua table
		table.setDefaultEditor(Object.class, null);
		
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
