import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
    private JTextField txtHoTen, txtTuoi, txtGioiTinh, txtDiaChi, txtBac, txtNganhDaoTao, txtCongViec, txtTimKiem;
    private JButton btnThemMoi, btnTimKiem, btnHienThi, btnThoat;
    private QLCB qlcb;
    
    public GUI() {
        qlcb = new QLCB();
        
        this.setTitle("Quan ly can bo");
        this.setBounds(400, 200, 500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pnlNhapLieu = new JPanel();
        pnlNhapLieu.setLayout(new BoxLayout(pnlNhapLieu, BoxLayout.Y_AXIS));
        
        pnlNhapLieu.add(new JLabel("Ho ten:"));
        txtHoTen = new JTextField(20);
        pnlNhapLieu.add(txtHoTen);
        
        pnlNhapLieu.add(new JLabel("Tuoi:"));
        txtTuoi = new JTextField(20);
        pnlNhapLieu.add(txtTuoi);
        
        pnlNhapLieu.add(new JLabel("Gioi tinh:"));
        txtGioiTinh = new JTextField(20);
        pnlNhapLieu.add(txtGioiTinh);
        
        pnlNhapLieu.add(new JLabel("Dia chi:"));
        txtDiaChi = new JTextField(20);
        pnlNhapLieu.add(txtDiaChi);
        
        pnlNhapLieu.add(new JLabel("Bac:"));
        txtBac = new JTextField(20);
        pnlNhapLieu.add(txtBac);
        
        pnlNhapLieu.add(new JLabel("Nganh dao tao:"));
        txtNganhDaoTao = new JTextField(20);
        pnlNhapLieu.add(txtNganhDaoTao);
        
        pnlNhapLieu.add(new JLabel("Cong viec:"));
        txtCongViec = new JTextField(20);
        pnlNhapLieu.add(txtCongViec);
        
        JPanel pnlNut = new JPanel();
        
        btnThemMoi = new JButton("Them moi");
        btnThemMoi.addActionListener(this);
        pnlNut.add(btnThemMoi);
        
        btnTimKiem = new JButton("Tim kiem");
        btnTimKiem.addActionListener(this);
        pnlNut.add(btnTimKiem);
        
        btnHienThi = new JButton("Hien thi");
        btnHienThi.addActionListener(this);
        pnlNut.add(btnHienThi);
        
        btnThoat = new JButton("Thoat");
        btnThoat.addActionListener(this);
        pnlNut.add(btnThoat);
        
        JPanel pnlTimKiem = new JPanel();
        pnlTimKiem.add(new JLabel("Nhap ho ten can tim:"));
        txtTimKiem = new JTextField(20);
        pnlTimKiem.add(txtTimKiem);
        
        this.add(pnlNhapLieu, "North");
        this.add(pnlNut, "Center");
        this.add(pnlTimKiem, "South");
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnThemMoi) {
            String hoTen = txtHoTen.getText();
            int tuoi = Integer.parseInt(txtTuoi.getText());
            String gioiTinh = txtGioiTinh.getText();
            String diaChi = txtDiaChi.getText();
            
            if (!txtBac.getText().isEmpty()) {
                int bac = Integer.parseInt(txtBac.getText());
                CongNhan cn = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
                qlcb.themMoiCanBo(cn);
            } else if (!txtNganhDaoTao.getText().isEmpty()) {
                String nganhDaoTao = txtNganhDaoTao.getText();
                KySu ks = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
                qlcb.themMoiCanBo(ks);
            } else if (!txtCongViec.getText().isEmpty()) {
                String congViec = txtCongViec.getText();
                NhanVien nv = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
                qlcb.themMoiCanBo(nv);
            } else {
                CanBo canBo = new CanBo(hoTen, tuoi, gioiTinh, diaChi);
                qlcb.themMoiCanBo(canBo);
            }
            
            JOptionPane.showMessageDialog(null, "Them moi can bo thanh cong!");
        } else if (e.getSource() == btnTimKiem) {
            String hoTen = txtTimKiem.getText();
            ArrayList<CanBo> ketQua = qlcb.timKiemTheoHoTen(hoTen);
            if (ketQua.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Khong tim thay ket qua!");
            } else {
                String text = "";
                for (CanBo cb : ketQua) {
                    text += cb + "\n";
                }
                JOptionPane.showMessageDialog(null, text);
            }
        } else if (e.getSource() == btnHienThi) {
            qlcb.hienThiDanhSachCanBo();
        } else if (e.getSource() == btnThoat) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new GUI();
    }
}

