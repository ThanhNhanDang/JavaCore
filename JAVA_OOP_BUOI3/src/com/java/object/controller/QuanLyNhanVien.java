package com.java.object.controller;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import com.java.object.model.GiamDoc;
import com.java.object.model.NhanSu;
import com.java.object.model.NhanVien;
import com.java.object.model.TruongPhong;

import java.util.Scanner;

public class QuanLyNhanVien {
	private List <NhanSu> dsNhanSu;
	private float tongCoPhan;
	
	public QuanLyNhanVien() {
		dsNhanSu = new ArrayList<NhanSu>();
	}
	
	public float getTongCoPhan() {
		return this.tongCoPhan;
	}
	
	public boolean Them(NhanSu nhanSu) { 
		if (kiemTraTonTaiNhanSu(nhanSu))
			return false;
		else
			return dsNhanSu.add(nhanSu);
	}
	
	public void inDanhSachNhanSu() {
		int sTT  = 0;
		System.out.println("DANH SACH NHAN SU:");
		System.out.println("THONG TIN TUONG UNG*\n- Nhan Vien   : Ma so nhan vien cua truong phong"
											 + "\n- Truong Phong: So luong nhan vien Quan Ly"
											 + "\n- Giam Doc    : Co phan trong cong ty(%)");
		drawLine(154);
		System.out.print(String.format("|%3s |", "STT"));
		inTieuDeTable();
		System.out.println(String.format("%22s|", "THONG TIN TUONG UNG*"));
		for(NhanSu nhanSu : dsNhanSu) {
			sTT++;
			System.out.print(String.format("|%3d |", sTT));
			nhanSu.inThongTin();
			if (nhanSu instanceof GiamDoc) {
				System.out.println();
			}
		}
		drawLine(154);
	}
	
	public void inTieuDeTable() {
		System.out.print(String.format("%13s |", "CHUC VU")
						+String.format("%20s |", "MA SO")
						+String.format("%20s |", "HO TEN")
						+String.format("%20s |", "SO DIEN THOAI")
						+String.format("%20s |", "NGAY LAM VIEC")
						+String.format("%20s |", "LUONG 1 THANG"));
	}
	
	public boolean kiemTraTonTaiNhanSu(NhanSu  nhanSu) {
		for(NhanSu ns : dsNhanSu) {
			if (ns.getMaNhanVien().equalsIgnoreCase(nhanSu.getMaNhanVien())){
				return true;
			}
		}
		return false;
	}

	public void phanBoNhanVien() {
		int luaChon;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		List <NhanVien> dsNhanVienChuaPhanBo 	= new ArrayList <NhanVien>();
		List <TruongPhong> dsTruongPhong 		= new ArrayList <TruongPhong>();
		//add list
		for(NhanSu ns : dsNhanSu) {
			if (ns instanceof NhanVien && ((NhanVien)ns).getMaTruongPhong().equalsIgnoreCase("Rong")){ //ép kiểu
				dsNhanVienChuaPhanBo.add((NhanVien)ns);
			}
			else if (ns instanceof TruongPhong)
				dsTruongPhong.add((TruongPhong)ns);
		}
		
		System.out.println("PHAN BO NHAN VIEN");
		System.out.println("+ Danh sach nhan vien chua phan bo:");
		for(NhanVien nhanVien : dsNhanVienChuaPhanBo) {
			System.out.println("Thong tin nhan vien:");
			drawLine(148);
			inTieuDeTable();
			System.out.println(String.format("%20s  |", "MA TRUONG PHONG"));
			nhanVien.inThongTin();
			drawLine(148);
			System.out.println("Danh sach truong phong:");
			drawLine(154);
			System.out.print(String.format("|%3s |", "STT"));
			inTieuDeTable();
			System.out.println(String.format("%20s  |", "SO NHAN VIEN"));
			for(int  i = 0; i < dsTruongPhong.size(); i++) {
				System.out.print(String.format("|%3s |", (i+1)));
				dsTruongPhong.get(i).inThongTin();
				
			}
			drawLine(154);
			System.out.println();
			System.out.println("0. Khong phan bo");
			System.out.println("Nhap STT cua truong phong muon phan bo:");
			luaChon = Integer.parseInt(scanner.nextLine());
			if (luaChon == 0)
				continue;
			if(luaChon < 0 || luaChon > dsTruongPhong.size()) {
				System.err.println("Khong tim thay truong phong");
				continue;
			}
			TruongPhong truongPhong;
			truongPhong = dsTruongPhong.get(luaChon - 1);
			nhanVien.setMaTruongPhong(truongPhong.getMaNhanVien());
			truongPhong.tangNhanVien();
		}
	}
	
	public boolean Xoa(String maNhanVien) {
		if(maNhanVien == null && "".equals(maNhanVien)) {
			return false;
		}
		else {
			int i = 0;
			List <TruongPhong> dsTruongPhong = new ArrayList <TruongPhong>();	
			List <NhanVien>	   dsNhanVien 	 = new ArrayList <NhanVien>   ();
			for(NhanSu ns : dsNhanSu) {
				if (ns instanceof TruongPhong) {
					dsTruongPhong.add((TruongPhong)ns);
				}
				else if(ns instanceof NhanVien){
					dsNhanVien.add((NhanVien)ns);
				}
			}
			for(NhanSu ns : dsNhanSu) {
				if(maNhanVien.equalsIgnoreCase(ns.getMaNhanVien())) {
					if (ns instanceof GiamDoc) {
						dsNhanSu.remove(ns);
						return true;
					}
					else if(ns instanceof TruongPhong) {
						NhanVien nhanVien;
						for (NhanVien nv: dsNhanVien) {
							if (ns.getMaNhanVien().equalsIgnoreCase(nv.getMaTruongPhong())) {
								nhanVien = dsNhanVien.get(i);
								nhanVien.setMaTruongPhong("Rong");
							}
							i++;
						}
						dsNhanSu.remove(ns);
						dsTruongPhong.remove(ns);
						return true;
					}
					else if(ns instanceof NhanVien && ((NhanVien) ns).getMaTruongPhong().equalsIgnoreCase("Rong")) {
						dsNhanSu.remove(ns);
						return true;
					}
					else if(ns instanceof NhanVien && ((NhanVien)ns).getMaTruongPhong().equalsIgnoreCase("Rong") == false) {
						i = 0;
						TruongPhong truongPhong;
						for(TruongPhong tp : dsTruongPhong) {
							if(((NhanVien)ns).getMaTruongPhong().equalsIgnoreCase(tp.getMaNhanVien())){
								truongPhong = dsTruongPhong.get(i);
								truongPhong.giamNhanVien();
								dsNhanVien.remove(ns);
								dsNhanSu.remove(ns);
								return true;
							}
							i++;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean tinhTongCoPhan() {
		float coPhan = 0;
		for(NhanSu nhanSu:dsNhanSu) {
			if(nhanSu instanceof GiamDoc)
				coPhan += ((GiamDoc)nhanSu).getSoCoPhan()*100;
			if(coPhan >= 100) {
				this.tongCoPhan = coPhan - ((GiamDoc)nhanSu).getSoCoPhan()*100 ;
				return false;
			}
		}
		return true;
	}
	
	public float tinhTongLuong() {
		float luong = 0;
		for(NhanSu nhanSu:dsNhanSu) {
			if(nhanSu instanceof TruongPhong)
				luong += ((TruongPhong)nhanSu).tinhLuong();
			else
				luong += nhanSu.tinhLuong();
		}
		return luong;
	}
	
	public void timNhanVienLuongMax() {
		if (dsNhanSu.size() == 0){
			return;
		}
		else if (dsNhanSu.size() == 1 && (dsNhanSu.get(0)instanceof NhanVien)) {
			drawLine(148);
			inTieuDeTable();
			System.out.println(String.format("%20s  |", "MA TRUONG PHONG"));
			dsNhanSu.get(0).inThongTin();
			drawLine(148);
		}
		else {
			boolean check = true;
			int max = 0;
			List <NhanVien> dsNhanVien  = new ArrayList <NhanVien>();
			for (NhanSu nhanSu:dsNhanSu) {
				if(nhanSu instanceof NhanVien) {
					dsNhanVien.add((NhanVien)nhanSu);
				}
			}
			for(int i = 1; i < dsNhanVien.size(); i++) {
				if(dsNhanVien.get(max).tinhLuong() < dsNhanVien.get(i).tinhLuong()){
					max = i;
				}
				if (i == dsNhanVien.size() - 1) {
					check = false;
				}
			}

			drawLine(148);
			inTieuDeTable();
			System.out.println(String.format("%20s  |", "MA TRUONG PHONG"));
			if (check == true) {
				dsNhanVien.get(max).inThongTin();
				drawLine(148);
			}
			else {
				dsNhanVien.get(max).inThongTin();
				for(int i = max + 1; i < dsNhanVien.size(); i++) {
					if(dsNhanVien.get(max).tinhLuong() == dsNhanVien.get(i).tinhLuong()) {
						dsNhanVien.get(i).inThongTin();
					}
				}	
				drawLine(148);
				
			}
		}
	}
	
	public void timTruongPhongCoSoLuongNhanVienCaoNhat() {
		if (dsNhanSu.isEmpty()) {
			return;
		}	
		else {
			boolean check = true;
			int  max = 0;
			List <TruongPhong> truongPhong	  = new ArrayList<TruongPhong>();
			
			for(NhanSu nhanSu : dsNhanSu) {
				if(nhanSu instanceof TruongPhong && ((TruongPhong)nhanSu).getSoNhanVien() != 0) {
					truongPhong.add((TruongPhong)nhanSu);
				}
			}
			for (int i = 1; i < truongPhong.size(); i++) {
				if(truongPhong.get(max).getSoNhanVien() < truongPhong.get(i).getSoNhanVien()) {
					max = i;
				}
				if (i == truongPhong.size() - 1) {
					check = false;
				}
			}
			drawLine(148);
			inTieuDeTable();
			System.out.println(String.format("%20s  |", "SO NHAN VIEN"));
			if (check == true) {
				truongPhong.get(max).inThongTin();
				drawLine(148);
			}
			else {
				truongPhong.get(max).inThongTin();
				for(int i = max + 1; i < truongPhong.size(); i++) {
					if(truongPhong.get(max).getSoNhanVien() == truongPhong.get(i).getSoNhanVien()) {
						truongPhong.get(i).inThongTin();
					}
				}
				drawLine(148);
			}
		}
	}
	
	class  TenComparator implements Comparator <NhanSu>{
		@Override
		public int compare(NhanSu ns1, NhanSu ns2) {
			return ns1.getTen().compareTo(ns2.getTen());
		}
	}
	class  LuongComparator implements Comparator <NhanSu>{
		@Override
		public int compare(NhanSu ns1, NhanSu ns2) {
			if (ns1.tinhLuong() == ns2.tinhLuong())
				return 0;
			else if (ns1.tinhLuong() < ns2.tinhLuong())
				return 1;
			else
				return -1;
		}
	}
	
	public void Sort(String value) {
		if ("Ten".equalsIgnoreCase(value))
			Collections.sort(dsNhanSu, new TenComparator());
		else if ("Luong".equalsIgnoreCase(value))
			Collections.sort(dsNhanSu, new LuongComparator());
			
	}
	
	public void timGiamDocCoPhanCaoNhat() {
		if (dsNhanSu.isEmpty()) {
			return;
		}	
		else {
			boolean check = true;
			int  max = 0; 
			List <GiamDoc> giamDoc	= new ArrayList<GiamDoc>();
			
			for(NhanSu nhanSu : dsNhanSu) {
				if(nhanSu instanceof GiamDoc && ((GiamDoc)nhanSu).getSoCoPhan() != 0) {
					giamDoc.add((GiamDoc)nhanSu);
				}
			}
			for (int i = 1; i < giamDoc.size(); i++) {
				if(giamDoc.get(max).getSoCoPhan() < giamDoc.get(i).getSoCoPhan()) {
					max = i;
				}
				if (i == giamDoc.size() - 1) {
					check = false;
				}
			}
			drawLine(148);
			inTieuDeTable();
			System.out.println(String.format("%20s  |", "SO CO PHAN"));
			if (check == true) {
				giamDoc.get(max).inThongTin();
				System.out.println();
				drawLine(148);
			}
			else {
				giamDoc.get(max).inThongTin();
				for(int i = max + 1; i < giamDoc.size(); i++) {
					if(giamDoc.get(max).getSoCoPhan() == giamDoc.get(i).getSoCoPhan()) {
						giamDoc.get(i).inThongTin();
					}
				}
				drawLine(148);
			}
		}
	}
	
	
	public void inLoiNhuanGiamDoc(float doanhThuThang) {
		if(doanhThuThang == 0)
			System.err.println("Ban chua nhap thong tin cong ty!\nLua chon \'1\' de nhap thong tin cong ty.");
		else {
			drawLine(171);
			inTieuDeTable();
			float loi = doanhThuThang - tinhTongLuong();
			System.out.print(String.format("%20s  |", "SO CO PHAN"));
			System.out.println(String.format("%20s  |", "LOI NHUAN"));
			for(NhanSu ns : dsNhanSu) {
				if(ns instanceof GiamDoc) {
					ns.inThongTin();
					System.out.println(String.format("%21.2f |", loiNhuan((GiamDoc)ns, loi))) ;
					
				}
			}
			drawLine(171);
		}
	}
	
	public float loiNhuan(GiamDoc giamDoc, float loiNhuan) {
		return (giamDoc.tinhLuong() + giamDoc.getSoCoPhan()*loiNhuan);
	}
	public void drawLine(int len) {
		for(int i = 0; i < len; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
