package com.java.object.view;

import com.java.object.model.NhanVien;
import com.java.object.model.GiamDoc;
import com.java.object.model.TruongPhong;
import java.util.Scanner;

import com.java.object.controller.QuanLyNhanVien;

public class CongTy {
	private String 	maSoThue;
	private String 	tenCongTy;
	private float 	doanhThuThang;
	QuanLyNhanVien 	quanLyNhanVien;
	public CongTy() {
		quanLyNhanVien = new QuanLyNhanVien();
		this.maSoThue 		= "Rong";
		this.tenCongTy 		= "Rong";
		this.doanhThuThang 	= 0; 
	}
	public void mainFunc() {
		Scanner scanner = new Scanner(System.in);
		int luaChon = 0;
		do {
			showMenu();
			System.out.print("Lua chon: ");
			luaChon = Integer.parseInt(scanner.nextLine());
			switch(luaChon) {
			case 1:
				nhapThongTin(scanner);
				break;
			case 2:
				quanLyNhanVien.phanBoNhanVien();
				break;
				
			case 3:
				System.out.println("Chon loai nhan vien can them:\n\t1. Nhan vien.\n\t2. Truong phong.\n\t3. Giam doc\n\t0. Thoat");
				switch (Integer.parseInt(scanner.nextLine())){
				case 1:
					NhanVien nhanVien = new NhanVien();
					nhanVien.themThongTin(scanner);
					if(quanLyNhanVien.Them(nhanVien)) {
						System.out.println("Them nhan Vien Thanh Cong");
					}
					else
						System.err.println("Them nhan Vien That Bai!\nMa so nhan vien da ton tai");
					break;
				case 2:
					TruongPhong truongPhong = new TruongPhong();
					truongPhong.themThongTin(scanner);
					if(quanLyNhanVien.Them(truongPhong)) {
						System.out.println("Them truong phong Thanh Cong");
					}
					else
						System.err.println("Them truong phong That Bai!\nMa so nhan vien da ton tai");
					break;
				case 3:
					GiamDoc giamDoc = new GiamDoc();
					giamDoc.themThongTin(scanner);
					if(quanLyNhanVien.Them(giamDoc)) {
						if(!quanLyNhanVien.tinhTongCoPhan()) {
							System.out.print("Co phan con lai: ");
							if(quanLyNhanVien.getTongCoPhan() == 0)
								System.err.println(String.format("%.2f", quanLyNhanVien.getTongCoPhan())+ "%");
							else
								System.err.println(String.format("%.2f", 100 -quanLyNhanVien.getTongCoPhan()) + "%");
							giamDoc.setSoCoPhan(0);
							}
						System.out.println("Them giam doc Thanh Cong");
					}
					else
						System.err.println("Them giam doc That Bai!\nMa so nhan vien da ton tai");
					break;
				case 0:
					System.out.println("GoodBye!!!");
					break;
				default:
					System.err.println("Chon sai");
				}
				break;
			case 4:
				System.out.print("Nhap ma so nhan vien can xoa:");
				if(quanLyNhanVien.Xoa(scanner.nextLine()))
					System.out.println("Xoa thanh cong");
				else
					System.err.println("Khong tim thay ma so ban vua nhap !");
				break;
				
			case 5:
				quanLyNhanVien.inDanhSachNhanSu();
				break;
			case 6:
				System.out.print("TONG LUONG TRONG CONG TY: " + quanLyNhanVien.tinhTongLuong());
				break;
			case 7:
				System.out.println("Danh sach nhan vien thuong co luong cao nhat:");
				quanLyNhanVien.timNhanVienLuongMax();
				break;
			case 8: 
				System.out.println("Danh sach truong phong co so luong nhan vien nhieu nhat:");
				quanLyNhanVien.timTruongPhongCoSoLuongNhanVienCaoNhat();
				break;
			case 9:
				System.out.println("SAP XEP TEN NHAN VIEN TOAN CONG TY THEO THU TU ABC:");
				quanLyNhanVien.Sort("Ten");
				quanLyNhanVien.inDanhSachNhanSu();
				break;
			case 10:
				System.out.println("SAP XEP NHAN VIEN THEO THU TU LUONG GIAM DAN:");
				quanLyNhanVien.Sort("Luong");
				quanLyNhanVien.inDanhSachNhanSu();
				break;
			case 11:
				System.out.println("Danh sach giam doc so co phan cao nhat:");
				quanLyNhanVien.timGiamDocCoPhanCaoNhat();
				break;
			case 12:
				System.out.println("Tong thu nhap cua tung giam doc:");
				quanLyNhanVien.inLoiNhuanGiamDoc(this.doanhThuThang);
				break;
			case 0:
				
				System.out.println("Goodbye!!!");
				break;
			default:
				System.out.println("Lua chon sai !!!");
			}
		}while(luaChon  != 0);
	}
	public void nhapThongTin(Scanner scanner) {
		System.out.println("NHAP THONG TIN CONG TY: ");
		System.out.print("Ten cong ty		: ");
		this.tenCongTy = scanner.nextLine();
		System.out.print("Ma so thue 		: ");
		this.maSoThue = scanner.nextLine();
		System.out.print("Doanh thu thang		: ");
		this.doanhThuThang = Float.parseFloat(scanner.nextLine());
	}
	
	public void  xuatThongTin() {
		System.out.println(String.format("%12s","") + "THONG TIN CONG TY" + String.format("%12s", ""));
		System.out.println(String.format("%12s", "| Ten cong ty |") +
						   String.format("%12s", "Ma so thue |")  +
						   String.format("%12s", "Doanh Thu Thang |"));
		
		System.out.println(String.format("12s", "|" + tenCongTy + " |") +
				   String.format("%12s", maSoThue + " |" )  +
				   String.format("%12.2s", doanhThuThang + " |"));
		
	}
	
	public void showMenu() {
		int spaceNum = 20;
		System.out.println();
		System.out.println(String.format("%" + spaceNum + "s", "") + "QUẢN LÝ NHÂN SỰ" + String.format("%" + spaceNum + "s", ""));
		System.out.println("Menu:");
		System.out.println("\t1. Nhập thông tin công ty");
		System.out.println("\t2. Phân bổ Nhân viên vào Trưởng phòng");
		System.out.println("\t3. Thêm thông tin một nhân sự bat ky");
		System.out.println("\t4. Xóa thông tin một nhân sự");
		System.out.println("\t5. Xuất ra thông tin toàn bộ người trong công ty");
		System.out.println("\t6. Tính và xuất tổng lương cho toàn công ty");
		System.out.println("\t7. Tìm Nhân viên thường có lương cao nhất");
		System.out.println("\t8. Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất");
		System.out.println("\t9. Sắp xếp nhân viên toàn công ty theo thứ tự abc");
		System.out.println("\t10. Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần");
		System.out.println("\t11. Tìm Giám Đốc có số lượng cổ phần nhiều nhất");
		System.out.println("\t12. Tính và Xuất tổng THU NHẬP của từng Giám Đốc");
		System.out.println("\t0. Thoát.");
		System.out.print("Lựa chọn: ");

	}
	
	public void taoDummyData() {
		quanLyNhanVien.Them(new NhanVien("Dang Thanh Nhan", "MS01", "11212861566", "Nhan Vien", 34f, 34f));
		quanLyNhanVien.Them(new GiamDoc("Nguyen Van A", "MS02", "01212861555", "Giam Doc",  78.5f, 2332.23f, 25.5f));
		quanLyNhanVien.Them(new TruongPhong("Dan Van Tinh", "MS03", "11212861544", "Truong Phong", 35f, 35f));
	}
}
