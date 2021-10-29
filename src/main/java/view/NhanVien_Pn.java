package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class NhanVien_Pn extends JPanel implements ActionListener, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtSDT;
	private JTextField txtTimTen;
	private JLabel txtPage;
	private JTable table;
	private DefaultTableModel tableModle;
	private JButton btnDau;
	private JButton btnTru1;
	private JButton btnCong1;
	private JButton btnCuoi;
	private JButton btnLamMoi;
	private JButton btnTim;
	private JComboBox<String> cbTrangThaiLamViec;
	private JButton btnTrangThaiLamViec;
	private JButton btnThem;
	private JButton btnSua;

	public NhanVien_Pn() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Nh\u1EADp t\u00EAn: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 10, 91, 41);
		add(lblNewLabel);

		txtSDT = new JTextField();
		txtSDT.setBounds(100, 60, 650, 35);
		add(txtSDT);
		txtSDT.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tr\u1EA1ng th\u00E1i l\u00E0m vi\u1EC7c");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(762, 10, 186, 35);
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 108, 1300, 1);
		add(panel);

		btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(this);
		btnThem.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/them.png")));
		btnThem.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThem.setBounds(892, 60, 120, 35);
		add(btnThem);

		btnTrangThaiLamViec = new JButton("TTLV");
		btnTrangThaiLamViec.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/lam_moi.png")));
		btnTrangThaiLamViec.addActionListener(this);
		btnTrangThaiLamViec.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTrangThaiLamViec.setBounds(1022, 58, 120, 35);
		add(btnTrangThaiLamViec);

		btnSua = new JButton("S\u1EEFa");
		btnSua.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/cap_nhat.png")));
		btnSua.setFont(new Font("Arial", Font.PLAIN, 16));
		btnSua.addActionListener(this);
		btnSua.setBounds(1152, 58, 120, 35);
		add(btnSua);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 119, 1290, 401);
		add(scrollPane);

		tableModle = new DefaultTableModel(new Object[][] {

		}, new String[] { "T\u00EAn nh\u00E2n vi\u00EAn", "Gi\u1EDBi t\u00EDnh", "SDT", "T\u1EC9nh/TP",
				"Qu\u1EADn/Huy\u1EC7n", "Ph\u01B0\u1EDDng x\u00E3", "Tr\u1EA1ng th\u00E1i" });
		table = new JTable();
		table.addMouseListener(this);
		table.setRowHeight(35);
		scrollPane.setViewportView(table);
		table.setModel(tableModle);

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
		lblNhpSdt.setBounds(10, 60, 91, 41);
		add(lblNhpSdt);

		txtTimTen = new JTextField();
		txtTimTen.setColumns(10);
		txtTimTen.setBounds(100, 10, 650, 35);
		txtTimTen.addKeyListener(this);
		add(txtTimTen);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(this);
		btnLamMoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(1152, 10, 120, 35);
		add(btnLamMoi);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/nextEnd.png")));
		btnCuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCuoi.setBounds(791, 530, 85, 30);
		btnCuoi.addActionListener(this);
		add(btnCuoi);

		txtPage = new JLabel("1");
		txtPage.setForeground(new Color(0, 0, 0));
		txtPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPage.setBounds(644, 530, 46, 30);
		add(txtPage);

		cbTrangThaiLamViec = new JComboBox<String>();
		cbTrangThaiLamViec.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTrangThaiLamViec
				.setModel(new DefaultComboBoxModel<String>(new String[] { "(Tất cả)", "Đã nghĩ", "Đang làm" }));
		cbTrangThaiLamViec.setBounds(921, 10, 220, 35);
		cbTrangThaiLamViec.addActionListener(this);
		add(cbTrangThaiLamViec);

		btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/Search.png")));
		btnTim.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTim.setBounds(762, 60, 120, 35);
		btnTim.addActionListener(this);
		add(btnTim);

		// khong cho sua table
		table.setDefaultEditor(Object.class, null);
		// add du lieu
//		themDuLieuVaoTable();
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