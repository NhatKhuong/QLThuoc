package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.DiaChi;
import entity.NhanVien;

public class DialogThemNhanVien extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTenNhanVien;
	private JTextField txtCmnd;
	private JTextField txtSDT;
	private JTextField txtPass;
	private JComboBox<String> cbTinhTP;
	private DefaultComboBoxModel<String> modelTinhTp;
	private DefaultComboBoxModel<String> modelPhuongXa;
	private DefaultComboBoxModel<String> modelQuanHuyen;
	private JComboBox<String> cbQuanHuyen;
	private JComboBox<String> cbPhuongXa;
	private JComboBox<?> cbGioiTinh;
	private JButton btnLuu;
	private JButton btnHuy;
	private JButton btnLamMoi;
	private JLabel lbMaNhanVien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogThemNhanVien dialog = new DialogThemNhanVien();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogThemNhanVien() {
		setResizable(false);
		setModal(true);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);

		setBounds(100, 100, 850, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("NH?? THU???C VI???T NAM");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
			lblNewLabel.setForeground(new Color(46, 139, 87));
			lblNewLabel.setBounds(223, 10, 411, 78);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Th??m nh??n vi??n m???i");
			lblNewLabel_1.setForeground(new Color(0, 0, 128));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblNewLabel_1.setBounds(286, 73, 255, 31);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("M?? nh??n vi??n:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 141, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Gi???i t??nh:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(567, 141, 110, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("T??n nh??n vi??n:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 186, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			cbGioiTinh = new JComboBox();
			cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
			cbGioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "N???" }));
			cbGioiTinh.setBounds(674, 141, 131, 35);
			contentPanel.add(cbGioiTinh);
		}
		{
			
			lbMaNhanVien = new JLabel("M?? nh??n vi??n");
			lbMaNhanVien.setText("---");
//			lbMaNhanVien.setText(DAO_NhanVien.phatSinhMaTuDong(conn));
			lbMaNhanVien.setFont(new Font("Arial", Font.ITALIC, 16));
			lbMaNhanVien.setBounds(149, 141, 110, 35);
			contentPanel.add(lbMaNhanVien);
		
		}
		{
			JLabel lblNewLabel_2 = new JLabel("CMND/CC:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 231, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("?????a ch???:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 276, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("M???t kh???u:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(28, 321, 115, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			btnHuy = new JButton("H???y");
			btnHuy.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/xoa.png")));
			btnHuy.setFont(new Font("Arial", Font.PLAIN, 16));
			btnHuy.setBounds(28, 400, 120, 35);
			btnHuy.addActionListener(this);
			contentPanel.add(btnHuy);
		}
		{
			btnLamMoi = new JButton("L??m m???i");
			btnLamMoi.addActionListener(this);
			btnLamMoi.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/lam_moi.png")));
			btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
			btnLamMoi.setBounds(513, 400, 120, 35);
			contentPanel.add(btnLamMoi);
		}
		{
			btnLuu = new JButton("L??u");
			btnLuu.setIcon(new ImageIcon(DialogThemNhanVien.class.getResource("/img/cap_nhat.png")));
			btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnLuu.setBounds(674, 400, 131, 35);
			btnLuu.addActionListener(this);
			contentPanel.add(btnLuu);
		}
		{
			txtTenNhanVien = new JTextField();
			txtTenNhanVien.setBounds(149, 186, 656, 35);
			contentPanel.add(txtTenNhanVien);
			txtTenNhanVien.setColumns(10);
		}
		{
			txtCmnd = new JTextField();
			txtCmnd.setBounds(149, 233, 318, 35);
			contentPanel.add(txtCmnd);
			txtCmnd.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("S??T:");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
			lblNewLabel_2.setBounds(513, 233, 44, 35);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtSDT = new JTextField();
			txtSDT.setBounds(567, 233, 238, 35);
			contentPanel.add(txtSDT);
			txtSDT.setColumns(10);
		}
		{
			txtPass = new JTextField();
			txtPass.setBounds(149, 323, 656, 35);
			contentPanel.add(txtPass);
			txtPass.setColumns(10);
		}
		cbTinhTP = new JComboBox<String>();
		modelTinhTp = new DefaultComboBoxModel<String>(new String[] { "T???nh/TP" });
		cbTinhTP.setModel(modelTinhTp);
		cbTinhTP.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTinhTP.setBounds(149, 276, 200, 35);
		cbTinhTP.addActionListener(this);
		themDuLieuTinh();
		contentPanel.add(cbTinhTP);

		cbPhuongXa = new JComboBox();
		modelPhuongXa = new DefaultComboBoxModel(new String[] { "Ph?????ng/X??" });
		cbPhuongXa.setModel(modelPhuongXa);
		cbPhuongXa.setFont(new Font("Arial", Font.PLAIN, 16));
		cbPhuongXa.setBounds(605, 276, 200, 35);
		cbPhuongXa.addActionListener(this);
		contentPanel.add(cbPhuongXa);

		cbQuanHuyen = new JComboBox<String>();
		modelQuanHuyen = new DefaultComboBoxModel<String>(new String[] { "Qu???n/Huy???n" });
		cbQuanHuyen.setModel(modelQuanHuyen);
		cbQuanHuyen.setFont(new Font("Arial", Font.PLAIN, 16));
		cbQuanHuyen.setBounds(375, 276, 200, 35);
		cbQuanHuyen.addActionListener(this);
		contentPanel.add(cbQuanHuyen);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

//		gan nhan vien

	}

	public void themDuLieuTinh() {
		
	}

	public NhanVien layDuLieu() {

		String tenNhanVien = txtTenNhanVien.getText().trim();
		String cmnd = txtCmnd.getText();
		String pass = txtPass.getText().trim();
		String sdt = txtSDT.getText().trim();
		boolean gt = cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nam") ? true : false;
		String tinh = cbTinhTP.getSelectedItem().toString();
		String quan = cbQuanHuyen.getSelectedItem().toString();
		String phuong = cbPhuongXa.getSelectedItem().toString();
	
		if (tenNhanVien.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p t??n");
			txtTenNhanVien.selectAll();
			txtTenNhanVien.requestFocus();
			return null;
		}
		if (!tenNhanVien.matches("[^0-9!@#$%^&*()_+{}:]*")) {
			JOptionPane.showMessageDialog(this,
					"T??n nh??n vi??n ph???i l?? ch??? Kh??ng ???????c ch???a s??? v?? k?? t??? ?????c bi???t ");
			txtTenNhanVien.selectAll();
			txtTenNhanVien.requestFocus();
			return null;
		}
		if (cmnd.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "S??? Ch???ng minh nh??n d??n R???ng");
			txtCmnd.selectAll();
			txtCmnd.requestFocus();
			return null;
		}
		// kiem tra sdt
		if (sdt.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p s??? ??i???n tho???i");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return null;
		}
		if (!sdt.matches(
				"(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i kh??ng ????ng ?????ng d???ng");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return null;
		}
//		if (!DAO_NhanVien.kiemTraSoDienThoai(conn, sdt)) {
//			JOptionPane.showMessageDialog(this, "S??? ??i???n tho???i ???? t???n t???i");
//			txtSDT.selectAll();
//			txtSDT.requestFocus();
//			return null;
//		}
		
		if (!cmnd.matches("[0-9]{9,}")) {
			JOptionPane.showMessageDialog(this, "S??? Ch???ng minh nh??n d??n kh??ng ????ng");
			txtCmnd.selectAll();
			txtCmnd.requestFocus();
			return null;
		}
//		if (!DAO_NhanVien.kiemTraSoChungMinhNhanDan(conn, cmnd)) {
//			JOptionPane.showMessageDialog(this, "S??? Ch???ng minh nh??n d??n ???? t???n t???i");
//			txtCmnd.selectAll();
//			txtCmnd.requestFocus();
//			return null;
//		}
		if (cbTinhTP.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "B???n ch??a ch???n ?????a ch???");
			return null;
		}
		if(pass.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "B???n ch??a nh???p m???t kh???u");
			txtPass.selectAll();
			txtPass.requestFocus();
			return null;
		}
		if(!pass.trim().matches("[0-9]{4,}") ) {
			JOptionPane.showMessageDialog(this, "M???t kh???u ph??i l?? s??? v?? l???n h??n ho???c b???ng 4 s???");
			txtPass.selectAll();
			txtPass.requestFocus();
			return null;
		}

		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}