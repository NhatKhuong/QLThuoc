package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class ChiTietThuoc_JFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDong;
	private JLabel lblTenThuoc;
	private JLabel lblTrangThai;
	private JLabel lblMaThuoc;
	private JLabel lblNhomThuoc;
	private JLabel lblQuiCachDongGoi;
	private JLabel lblDangBaoChe;
	private JLabel lblSoLuongTon;
	private JLabel lblDonViTinh;
	private JLabel lblGia;
	private JLabel lblCongDung;
	private JLabel lblHoatChat;
	private JLabel lblHamLuong;
	private JLabel lblVAT;
	private JLabel lblNuocSX;
	private JLabel lblHangSX;
	private String maThuoc;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIManager
//							.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//					ChiTietThuoc_JFrame frame = new ChiTietThuoc_JFrame(null);
//					
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//	}

	/**
	 * Create the frame.
	 */
	public ChiTietThuoc_JFrame(String maThuoc) {
		
		this.maThuoc = maThuoc;
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 990, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 984, 52);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblChiTitThuc = new JLabel("Chi Ti???t Thu???c");
		lblChiTitThuc.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTitThuc.setForeground(Color.WHITE);
		lblChiTitThuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChiTitThuc.setBounds(0, 11, 983, 30);
		panel.add(lblChiTitThuc);

		lblTenThuoc = new JLabel("5-Fluorouracil \"Ebewe\"");
		lblTenThuoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenThuoc.setForeground(new Color(30, 144, 255));
		lblTenThuoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenThuoc.setBounds(44, 74, 915, 30);
		contentPane.add(lblTenThuoc);

		JLabel lblTnThuc = new JLabel("M?? thu???c");
		lblTnThuc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc.setBounds(44, 119, 100, 20);
		contentPane.add(lblTnThuc);

		JLabel lblTnThuc_1 = new JLabel("N.Thu???c");
		lblTnThuc_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_1.setBounds(44, 177, 100, 20);
		contentPane.add(lblTnThuc_1);

		JLabel lblTnThuc_2 = new JLabel("QC.????ng g??i");
		lblTnThuc_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_2.setBounds(44, 241, 100, 20);
		contentPane.add(lblTnThuc_2);

		JLabel lblTnThuc_3 = new JLabel("D???ng BC ");
		lblTnThuc_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_3.setBounds(44, 494, 100, 20);
		contentPane.add(lblTnThuc_3);

		JLabel lblTnThuc_4 = new JLabel("SL.T???n");
		lblTnThuc_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_4.setBounds(44, 366, 100, 20);
		contentPane.add(lblTnThuc_4);

		lblTrangThai = new JLabel("Ng???ng kinh doanh");
		lblTrangThai.setForeground(Color.RED);
		lblTrangThai.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTrangThai.setBounds(853, 51, 131, 30);
		contentPane.add(lblTrangThai);

		JLabel lblTnThuc_4_1 = new JLabel("??V.T??nh");
		lblTnThuc_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_4_1.setBounds(44, 433, 100, 20);
		contentPane.add(lblTnThuc_4_1);

		JLabel lblCngDng = new JLabel("C??ng d???ng");
		lblCngDng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCngDng.setBounds(546, 115, 100, 20);
		contentPane.add(lblCngDng);

		JLabel lblTnThuc_1_1 = new JLabel("Ho???t ch???t");
		lblTnThuc_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_1_1.setBounds(546, 173, 100, 20);
		contentPane.add(lblTnThuc_1_1);

		JLabel lblTnThuc_2_1 = new JLabel("H??m l?????ng");
		lblTnThuc_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_2_1.setBounds(546, 237, 100, 20);
		contentPane.add(lblTnThuc_2_1);

		JLabel lblTnThuc_3_1 = new JLabel("VAT");
		lblTnThuc_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_3_1.setBounds(546, 299, 100, 20);
		contentPane.add(lblTnThuc_3_1);

		JLabel lblTnThuc_4_2 = new JLabel("N?????c SX");
		lblTnThuc_4_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_4_2.setBounds(546, 366, 100, 20);
		contentPane.add(lblTnThuc_4_2);

		JLabel lblTnThuc_4_1_1 = new JLabel("H??ng SX");
		lblTnThuc_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnThuc_4_1_1.setBounds(44, 299, 100, 20);
		contentPane.add(lblTnThuc_4_1_1);

		lblMaThuoc = new JLabel("A0001");
		lblMaThuoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaThuoc.setBounds(156, 119, 324, 20);
		contentPane.add(lblMaThuoc);

		lblNhomThuoc = new JLabel("Tr??? ung th?? v?? mi???n d???ch");
		lblNhomThuoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNhomThuoc.setBounds(154, 176, 326, 20);
		contentPane.add(lblNhomThuoc);

		lblQuiCachDongGoi = new JLabel("D???ng l??? 10ml");
		lblQuiCachDongGoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuiCachDongGoi.setBounds(154, 241, 382, 20);
		contentPane.add(lblQuiCachDongGoi);

		lblDangBaoChe = new JLabel("Dung d???ch ?????m ?????c ????? pha thu???c ti??m");
		lblDangBaoChe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDangBaoChe.setBounds(147, 494, 520, 20);
		contentPane.add(lblDangBaoChe);

		lblSoLuongTon = new JLabel("100");
		lblSoLuongTon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoLuongTon.setBounds(147, 366, 333, 20);
		contentPane.add(lblSoLuongTon);

		lblDonViTinh = new JLabel("L???");
		lblDonViTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonViTinh.setBounds(147, 433, 333, 20);
		contentPane.add(lblDonViTinh);

		lblCongDung = new JLabel("Tr??? ung th??");
		lblCongDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCongDung.setBounds(636, 115, 338, 20);
		contentPane.add(lblCongDung);

		lblHoatChat = new JLabel("Nacl,Zn,P");
		lblHoatChat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoatChat.setBounds(640, 173, 334, 20);
		contentPane.add(lblHoatChat);

		lblHamLuong = new JLabel("500mg/10ml");
		lblHamLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHamLuong.setBounds(640, 238, 334, 20);
		contentPane.add(lblHamLuong);

		lblVAT = new JLabel("0.1");
		lblVAT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVAT.setBounds(636, 300, 338, 20);
		contentPane.add(lblVAT);

		lblNuocSX = new JLabel("?????c");
		lblNuocSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNuocSX.setBounds(636, 366, 338, 20);
		contentPane.add(lblNuocSX);

		lblHangSX = new JLabel("Honda");
		lblHangSX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHangSX.setBounds(147, 299, 333, 20);
		contentPane.add(lblHangSX);

		JLabel lblGi = new JLabel("Gi??");
		lblGi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGi.setBounds(546, 433, 46, 14);
		contentPane.add(lblGi);

		lblGia = new JLabel("100.000.00");
		lblGia.setForeground(new Color(255, 0, 0));
		lblGia.setFont(new Font("Dialog", Font.ITALIC, 15));
		lblGia.setBounds(636, 431, 338, 18);
		contentPane.add(lblGia);

		btnDong = new JButton("Tho??t");
		btnDong.setIcon(new ImageIcon(ChiTietThuoc_JFrame.class
				.getResource("/img/logout.png")));
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDong.setBounds(808, 506, 131, 33);
		contentPane.add(btnDong);
		
//		Thuoc thuoc = dataChiTietThuoc();
//		lblTenThuoc.setText(thuoc.getTenThuoc());
//		lblVAT.setText(Float.toString(thuoc.getThue())+"%");
//		lblTrangThai.setText(thuoc.isTrangThaiKinhDoanh()?"??ang kinh doanh":"Ng???ng kinh doanh");
//		lblSoLuongTon.setText(Integer.toString(thuoc.getSoLuongBanDau()));
//		lblQuiCachDongGoi.setText(thuoc.getQuyCachDongGoi());
//		lblNuocSX.setText(thuoc.getNuocSanXuat());
//		lblNhomThuoc.setText(thuoc.getCongDung().getNhomCongDung());
//		lblMaThuoc.setText(thuoc.getMaThuoc());
//		lblHoatChat.setText(thuoc.getThanhPhan());
//		lblHangSX.setText(thuoc.getCongTySanXuat());
//		lblHamLuong.setText(thuoc.getHamLuong());
//		lblGia.setText(Double.toString(thuoc.getGiaBan())+" ??/ "+thuoc.getDonViTinh());
//		lblDonViTinh.setText(thuoc.getDonViTinh());
//		lblDangBaoChe.setText(thuoc.getDangBaoChe());
//		lblCongDung.setText(thuoc.getCongDung().getCongDung());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(44, 158, 895, 325);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(44, 218, 895, 265);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(44, 283, 895, 200);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(44, 345, 895, 138);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(44, 411, 895, 72);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(44, 478, 895, 5);
		contentPane.add(separator_5);
//		lblvt.setText("??/"+thuoc.getDonViTinh());
		
		btnDong.addActionListener(this);
	}

//	private Thuoc dataChiTietThuoc() {
//		if(maThuoc.length() == 0){
//			return null;
//		}
//		Connection conn = DB.Connect.CreateConnection();
//		return DAO_Thuoc.getThuocTheoMa(conn, maThuoc);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDong)){
			dispose();
		}

	}
}
