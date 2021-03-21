package com.cyber.java.object;
import java.util.ArrayList;
import java.util.Scanner;

public class TruongDaiHoc {
	public static void main(String[] args) {
		ArrayList<SinhVien> listSinhVien = new ArrayList <>();
		Scanner scanner = new Scanner(System.in);
		int choose = 0;
		
		do {
			showMenu();
			System.out.print("Choose: ");
			choose =Integer.parseInt(scanner.nextLine());
			switch(choose) {
			case 1: 
				int len = 0;
				System.out.print("Nhap so sinh vien: ");
				len = Integer.parseInt(scanner.nextLine());
				for (int i = 0; i < len; i++) {
					SinhVien sinhVien = new SinhVien();
					System.out.println("Sinh vien "  +  (i+1) + ":");
					sinhVien.input();
					listSinhVien.add(sinhVien);
				}
				
				break;
			case 2:
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					System.out.println("_____INFORMATION_____");
					for(int i = 0; i < listSinhVien.size(); i++) {
						System.out.println("___________________________________");
						System.out.println("Sinh Vien "  + (i+1)  + ":");
						listSinhVien.get(i).output();
					}
				}
				break;
			case 3: 
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					for(int i = 0; i < listSinhVien.size(); i++) {
						System.out.println("Sinh vien " + (i+1) + ":");
						System.out.println("- Name		     :" + listSinhVien.get(i).getName());
						System.out.println("- Code		     :" + listSinhVien.get(i).getMaSo());
						System.out.println("- Average score	 :"	+ listSinhVien.get(i).getDiemTB());
					}
				}
				break;
			case 4:
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					System.out.println("- Ranking	   	   :"		+ sinhVien.getXepLoai());
				}
				else {
					for(int i = 0; i < listSinhVien.size(); i++) {
						System.out.println("Sinh vien " + (i+1) + ":");
						listSinhVien.get(i).output();
					}
				}
			case 5:
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					int indexRef = 0;
					for(int index = 1; index < listSinhVien.size(); index++) {
						if (listSinhVien.get(indexRef).getDiemTB()
							<= listSinhVien.get(index).getDiemTB()) 
							indexRef = index;	
					}
					System.out.println("___________________________________");
					System.out.println("Sinh vien " + (indexRef+1) + ":");
					System.out.println("- Average score	 :"	+ listSinhVien.get(indexRef).getDiemTB());
					System.out.println("Info : ");
					listSinhVien.get(indexRef).output();
				}
				break;
			case 6:
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					for(int index = 0; index < listSinhVien.size(); index++) {
						if (listSinhVien.get(index).getXepLoai().equals("Yeu")) {
							System.out.println("___________________________________");
							System.out.println("Sinh vien " + (index+1) + ":");
							System.out.println("- Ranking	 :"	+ listSinhVien.get(index).getXepLoai());
							System.out.println("Info: ");
							listSinhVien.get(index).output();
						}
						else 
							System.out.println("khong tim thay");
						}
					}
				break;
			case 7: 
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					System.out.print("Nhap ten sinh vien can tim: ");
					String ten = scanner.nextLine();
					int coutn = 0;
					for(int index = 0; index < listSinhVien.size(); index++) {
						if(listSinhVien.get(index).getTen().equalsIgnoreCase(ten)) {
							coutn++;
							listSinhVien.get(index).output();
						}
					}
					if(coutn == 0) 
						System.err.println("Khong tim thay sinh vien co ten: "  + ten);
				}
				break;
			case 8: 
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					System.out.print("Nhap ma sinh vien can tim: ");
					String maSo = scanner.nextLine();
					int coutn = 0;
					for(int index = 0; index < listSinhVien.size(); index++) {
						if(listSinhVien.get(index).getMaSo().equalsIgnoreCase(maSo)) {
							coutn++;
							listSinhVien.get(index).output();
						}
					}
					if(coutn == 0) 
						System.err.println("Khong tim thay sinh vien co ma so: "  + maSo);
				}
				break;
			case 9: 
				if (listSinhVien.size() == 0) {
					SinhVien sinhVien = new SinhVien();
					sinhVien.output();
				}
				else {
					System.out.print("Nhap ma sinh vien can xoa: ");
					String maSo = scanner.nextLine();
					int coutn = 0;
					for(int index = 0; index < listSinhVien.size(); index++) {
						if(listSinhVien.get(index).getMaSo().equalsIgnoreCase(maSo)) {
							coutn++;
							listSinhVien.remove(index);
							System.err.println("Xoa thanh cong !");
						}
					}
					if(coutn == 0) 
						System.err.println("Khong tim thay sinh vien co ma so: "  + maSo);
				}
				break;
			case 0:
				System.out.println("Goodbye !!!");
				break;
			default:
				System.err.println("Nhap sai !!");
			}	
		}while(choose != 0);
		
	}
	
	static void showMenu() {
		System.out.println("____________ MENU ____________");
		System.out.println("1. Nhap thong tin sinh vien:");
		System.out.println("2. Xuat thong tin sinh vien:");
		System.out.println("3. Diem trung binh tung sinh vien:");
		System.out.println("4. Xep loai tung sinh vien, in danh sach:");
		System.out.println("5. Sinh vien co diemTB cao nhat, in danh sach:");
		System.out.println("6. Tat ca sinh vien yeu, in danh sach:");
		System.out.println("7. Tim sinh vien theo ten, in danh sach:");
		System.out.println("8. Tim sinh vien theo ma, in danh sach:");
		System.out.println("9. Xoa sinh vien theo ma, in danh sach:");
	}
}
