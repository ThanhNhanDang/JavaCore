package OOPKeThua;

import java.util.Scanner;

public class  ChuyenXeNgoaiThanh extends ChuyenXe{
	private String 		soTuyen;
	private float 		soNgayDiDuoc;
	
	public ChuyenXeNgoaiThanh() {
		super ();
		this.soTuyen		 = "Null";
		this.soNgayDiDuoc	 = 0;
	}
	
	public ChuyenXeNgoaiThanh(String maSo, String hoTen, String soXe, float doanhThu, String soTuyen, float soNgayDiDuoc) {
		super(maSo, hoTen, soXe, doanhThu);
		this.soTuyen 		= soTuyen;
		this.soNgayDiDuoc	= soNgayDiDuoc;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("So tuyen = " 			+ this.soTuyen);
		System.out.println("So so ngay di duoc = " 	+ this.soNgayDiDuoc);
	}
	@Override
	public void input(Scanner scanner) {
		super.input(scanner);
		System.out.print("=>So tuyen: ");
		this.soTuyen = scanner.nextLine();
		System.out.print("=>So ngay di duoc: ");
		this.soNgayDiDuoc = Float.parseFloat(scanner.nextLine());
		
	}
}
