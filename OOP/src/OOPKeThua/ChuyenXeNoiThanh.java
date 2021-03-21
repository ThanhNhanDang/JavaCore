package OOPKeThua;
import java.util.Scanner;
public class ChuyenXeNoiThanh extends ChuyenXe {
	private String 		noiDen;
	private float 		soKmDiDuoc;
	
	public ChuyenXeNoiThanh() {
		super ();
		this.noiDen		 = "Null";
		this.soKmDiDuoc	 = 0;
	}
	public ChuyenXeNoiThanh(String maSo, String hoTen, String soXe, float doanhThu, String soTuyen, float soKM) {
		super(maSo, hoTen, soXe, doanhThu);
		this.noiDen		= soTuyen;
		this.soKmDiDuoc	= soKM;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("Noi den = " 	+ this.noiDen);
		System.out.println("So kilomet = " 	+ this.soKmDiDuoc);
	}
	@Override
	public void input(Scanner scanner) {
		super.input(scanner);
		System.out.print("=>Noi den: ");
		this.noiDen = scanner.nextLine();
		System.out.print("=>So kilomet di duoc: ");
		this.soKmDiDuoc = Float.parseFloat(scanner.nextLine());
		
	}
}
