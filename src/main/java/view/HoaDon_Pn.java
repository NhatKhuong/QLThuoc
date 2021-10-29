package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entity.HoaDon;

public class HoaDon_Pn extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private DefaultTableModel tableModel;
	private JComboBox<String> comboBox;
	private JButton btnNewButton_2_1_1;
	private JButton btnNewButton_2_1;
	private JButton btnDau;
	private JButton btntru1;
	private JLabel lbPage;
	private JButton btnCong1;
	private JButton btnCuoi;

	/**
	 * Create the panel.
	 */
	public HoaDon_Pn() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên KH: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 10, 91, 41);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(84, 61, 341, 35);
		add(textField);
		textField.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"(Tất cả)", "Hôm nay", "Trong tháng ", "Trong năm"}));
		comboBox.setBounds(977, 13, 165, 35);
		add(comboBox);

		JLabel lblNewLabel_1 = new JLabel("Thời gian");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(862, 13, 80, 35);
		add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 108, 1300, 1);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 134, 1327, 386);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		table.setModel(tableModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Mã khách hàng", "Ngày lập", "Tên Khách hàng", "Số điện thoại KH",
						"Nhân viên lập", "Số điện thoại NV", "Tổng tiền" }));

		btnDau = new JButton("");
		btnDau.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/previousEnd.png")));
		btnDau.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDau.setBounds(422, 530, 80, 30);
		add(btnDau);

		btntru1 = new JButton("");
		btntru1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/rewind-button.png")));
		btntru1.setFont(new Font("Arial", Font.PLAIN, 16));
		btntru1.setBounds(517, 530, 80, 30);
		add(btntru1);

		btnCong1 = new JButton("");
		btnCong1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/forward-button.png")));
		btnCong1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCong1.setBounds(696, 530, 80, 30);
		add(btnCong1);

		JLabel lblNhpSdt = new JLabel("Mã HD: ");
		lblNhpSdt.setForeground(Color.BLACK);
		lblNhpSdt.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSdt.setBounds(10, 58, 91, 41);
		add(lblNhpSdt);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 15, 341, 35);
		add(textField_1);

		btnNewButton_2_1 = new JButton("Làm mới");
		btnNewButton_2_1.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/lam_moi.png")));
		btnNewButton_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_2_1.setBounds(1152, 13, 120, 35);
		add(btnNewButton_2_1);

		btnCuoi = new JButton("");
		btnCuoi.setIcon(new ImageIcon(NhanVien_Pn.class.getResource("/img/nextEnd.png")));
		btnCuoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCuoi.setBounds(791, 530, 80, 30);
		add(btnCuoi);

		lbPage = new JLabel("1");
		lbPage.setForeground(new Color(0, 0, 0));
		lbPage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbPage.setBounds(644, 530, 46, 30);
		add(lbPage);

		JLabel lblStKh = new JLabel("SĐT NV: ");
		lblStKh.setForeground(Color.BLACK);
		lblStKh.setFont(new Font("Arial", Font.BOLD, 16));
		lblStKh.setBounds(454, 56, 91, 41);
		add(lblStKh);

		JLabel lblSdtKh = new JLabel("SĐT KH: ");
		lblSdtKh.setForeground(Color.BLACK);
		lblSdtKh.setFont(new Font("Arial", Font.BOLD, 16));
		lblSdtKh.setBounds(454, 10, 91, 41);
		add(lblSdtKh);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(529, 15, 308, 35);
		add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(529, 61, 308, 35);
		add(textField_3);

		btnNewButton_2_1_1 = new JButton("Chi tiết");

		btnNewButton_2_1_1.setIcon(new ImageIcon(HoaDon_Pn.class.getResource("/img/detail.png")));
		btnNewButton_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton_2_1_1.setBounds(1152, 61, 120, 35);
		add(btnNewButton_2_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày lập HĐ");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(862, 61, 105, 35);
		add(lblNewLabel_1_1);

		textField_4 = new JTextField();
		textField_4.setBounds(977, 61, 165, 35);
		add(textField_4);
		textField_4.setColumns(10);

		comboBox.addActionListener(this);
		textField.addKeyListener(this);
		textField_1.addKeyListener(this);
		textField_2.addKeyListener(this);
		textField_3.addKeyListener(this);
		textField_4.addKeyListener(this);
//		btnNewButton_2_1_1: chi tiết
		btnNewButton_2_1_1.addActionListener(this);
		btnNewButton_2_1.addActionListener(this);

		// khong cho sua table
		table.setDefaultEditor(Object.class, null);

		btnCong1.addActionListener(this);
		btnDau.addActionListener(this);
		btntru1.addActionListener(this);
		btnCuoi.addActionListener(this);

	}

	public void khoiTaoDuLieu() {
		xoaData();
//		truyVanData();
	}

	public void lamMoi() {
		comboBox.setSelectedIndex(0);
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		xoaData();
//		truyVanData();
	}

	private void xoaData() {
		for (int i = tableModel.getRowCount(); i > 0; i--) {
			tableModel.removeRow(0);
		}
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
		lbPage.setText("1");
		xoaData();
//		truyVanData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}