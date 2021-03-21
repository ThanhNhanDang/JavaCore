package OOPKeThua;

import java.util.Scanner;

public class ChuyenXe {
	protected String 	maSoChuyen;
	protected String 	hoTenTaiXe;
	protected String 	soXe;
	protected float 	doanhThu;
	
	public ChuyenXe() {
		this.doanhThu		 = 0;
		this.soXe 			 = "Null";
		this.hoTenTaiXe 	 = "Null";
		this.maSoChuyen 	 = "Null";
	}
	public ChuyenXe(String vMASoChuyen, String vHoTen, String vSoXe, float vDoanhThu) {
		this.maSoChuyen 	 = vMASoChuyen;
		this.hoTenTaiXe 	 = vHoTen;
		this.soXe 			 = vSoXe;
		this.doanhThu 		 = vDoanhThu;
	}

	public void print() {
		System.out.println("Ma so chuyen = "	 + this.maSoChuyen);
		System.out.println("Ho ten tai xe = " 	 + this.hoTenTaiXe);
		System.out.println("So xe = " 			 + this.soXe);
		System.out.println("Doanh thu = "		 + this.doanhThu);
		
	}
	
	public void input(Scanner scanner) {
		System.out.print("=>Ma so chuyen: ");
		this.maSoChuyen = scanner.nextLine();
		System.out.print("=>Ho ten tai xe: ");
		this.hoTenTaiXe= scanner.nextLine();
		System.out.print("=>So xe: ");
		this.soXe = scanner.nextLine();
		System.out.print("=>Doanh thu: ");
		this.doanhThu = Float.parseFloat(scanner.nextLine());	
	}
	
	public float GetDoanhThu() {
		return this.doanhThu;
	}
	
}
