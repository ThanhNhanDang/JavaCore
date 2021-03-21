package com.cyber.java.object;


public class SinhVien extends QuanLySinhVien{
	private 	float 	diemLy;
	private 	float 	diemHoa;
	private 	float 	diemToan;
	private 	float 	diemTB;
	private 	String 	xepLoai;
	
	public float getDiemLy() {
		return diemLy;
	}

	public boolean setDiemLy(float diemLy) {
		if(diemLy <= 10 && diemLy >= 0) {
			this.diemLy = diemLy;
			return true;
		}
		else {
			System.err.print("ERROR!!");
			System.out.println(" diem Ly >= 0 && diem Ly <= 10.");
			return false;
		}
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public boolean setDiemHoa(float diemHoa) {
		if(diemHoa <= 10 && diemHoa >= 0) {
			this.diemHoa = diemHoa;
			return true;
		}
		else {
			System.err.print("ERROR!!");
			System.out.println(" diem Hoa >= 0 && diem Hoa <= 10.");
			return false;
		}
	}

	public float getDiemToan() {
		return diemToan;
	}

	public boolean setDiemToan(float diemToan) {
		if(diemToan <= 10 && diemToan >= 0) {
			this.diemToan = diemToan;
			return true;
		}
		else {
			System.err.print("ERROR!!");
			System.out.println(" diem Toan >= 0 && diem Toan <= 10.");
			return false;
		}
	}

	public float getDiemTB() {
		diemTB = (diemHoa + diemLy + diemToan) / 3;
		return diemTB;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai() {
		if 		(diemTB >= 9)
			xepLoai = "Xuat sac";
		else if (diemTB < 9 && diemTB >= 8)
			xepLoai = "Gioi";
		else if (diemTB < 8 && diemTB >= 7)
			xepLoai = "Kha";
		else if (diemTB < 7 && diemTB >= 6)
			xepLoai = "Trung binh kha";
		else if (diemTB < 6 && diemTB >= 5)
			xepLoai = "Trung binh";
		else
			xepLoai = "Yeu";
	}
	
	public SinhVien() {
		diemLy 		= 2;
		diemHoa		= 2;
		diemToan	= 2;
		diemTB		= 2;
		xepLoai  	= "Rong";
	}
	
	public SinhVien(float diemLy, float diemHoa, float diemToan) {
		this.diemLy 		= diemLy;
		this.diemHoa		= diemHoa;
		this.diemToan		= diemToan;
	}	
	
	@Override
	public void input() {
		super.input();
		float diemLy 	= 0;
		float diemHoa 	= 0;
		float diemToan 	= 0;
		System.out.print("- Enter physics scores: ");
		while (true){
			diemLy		= Float.parseFloat(scanner.nextLine());
			if(setDiemLy(diemLy)) {
				break;
			}
			System.out.print("  Enter physics score:");
			
		}
		System.out.print("- Enter chemistry scores: ");
		while (true){
			diemHoa		= Float.parseFloat(scanner.nextLine());
			if(setDiemHoa(diemHoa)) {
				break;
			 }
			System.out.print("  Enter chemistry score:");
		}
		System.out.print("- Enter math scores: ");
		while (true){
			diemToan	= Float.parseFloat(scanner.nextLine());
			if(setDiemToan(diemToan)) {
				break;
			}
			System.out.print("  Enter math score:");
		}
		diemTB = getDiemTB();
		System.out.println("  Average score	   :"+ diemTB);
		setXepLoai();
	}
	
	@Override
	public void output() {
		super.output();
		System.out.println("- Physics scores   :"   		+ diemLy);
		System.out.println("- Chemistry scores :"			+ diemHoa);
		System.out.println("- Math scores 	   :"			+ diemToan);
		System.out.println("- Average score	   :"			+ diemTB);
		System.out.println("= Ranking   	   :"			+ xepLoai);
	}
	
	
}

