import java.util.ArrayList;

public class QLCB {
    private ArrayList<CanBo> danhSachCanBo;
    
    public QLCB() {
        danhSachCanBo = new ArrayList<CanBo>();
    }
    
    public void themMoiCanBo(CanBo canBo) {
        danhSachCanBo.add(canBo);
    }
    
    public ArrayList<CanBo> timKiemTheoHoTen(String hoTen) {
        ArrayList<CanBo> danhSachKetQua = new ArrayList<CanBo>();
        
        for (CanBo canBo : danhSachCanBo) {
            if (canBo.getHoTen().equalsIgnoreCase(hoTen)) {
                danhSachKetQua.add(canBo);
            }
        }
        
        return danhSachKetQua;
    }
    
    public void hienThiDanhSachCanBo() {
        System.out.println("Danh sach can bo:");
        
        for (CanBo canBo : danhSachCanBo) {
            System.out.println(canBo);
        }
    }
}

