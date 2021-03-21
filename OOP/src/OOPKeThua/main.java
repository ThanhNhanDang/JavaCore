package OOPKeThua;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
	public static void main(String[] args) {
		byte lenght = 0;
		float doanhThuNoiThanh = 0;
		float doanhThuNgoaiThanh = 0;
		Scanner scanner = new Scanner(System.in);
		ArrayList<ChuyenXe> listChuyenXe= new ArrayList<ChuyenXe> ();
		ChuyenXe chuyenXe;
		
		System.out.print("Nhap vao so chuyen xe noi thanh: ");
		lenght = Byte.parseByte(scanner.nextLine());
		for(int i = 0; i < lenght; i++) {
			System.out.println(".............................................");
			chuyenXe = new ChuyenXeNoiThanh();
			chuyenXe.input(scanner);
			listChuyenXe.add(chuyenXe);
			
		}
		for(int i = 0; i < lenght; i++) {
			doanhThuNoiThanh += listChuyenXe.get(i).GetDoanhThu();
		}
		System.out.println();
		System.out.print("Nhap vao so chuyen xe ngoai thanh: ");
		lenght = Byte.parseByte(scanner.nextLine());
		for(int i = 0; i < lenght; i++) {
			System.out.println(".............................................");
			chuyenXe = new ChuyenXeNgoaiThanh();
			chuyenXe.input(scanner);
			listChuyenXe.add(chuyenXe);
			
		}
		for(int i = listChuyenXe.size()-1; i >= listChuyenXe.size() - lenght; i--) {
			doanhThuNgoaiThanh += listChuyenXe.get(i).GetDoanhThu();
		}
	
		System.out.println("-Doanh thu noi thanh: " 	+ doanhThuNoiThanh);
		System.out.println("-Doanh thu ngoai thanh " 	+ doanhThuNgoaiThanh);
		System.out.println("-Doanh thu tong: " 			+ (doanhThuNoiThanh + doanhThuNgoaiThanh));
		
		
	}
}
