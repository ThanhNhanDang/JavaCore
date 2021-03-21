package com.java.object.model;
import java.util.Scanner;

public abstract class NhanSu { // "abstract" đánh dấu class này là trừu tượng
								// nếu methot là abstract thì những thằng kế thừa sẽ không super() được,
									//lớp kế thừa sẽ khai báo methot đó
								//CÔNG DỤNG: nó sẽ giúp chúng ta không cần viết code sẵn cho lớp cha
										//	- mà sẽ xem chức năng nó là gì rồi viết cho lớp kế thừa (OUT SOURCE)
	protected 	String 	tenNhanVien;
	protected   String  ten;
	protected 	String 	maNhanVien;
	protected 	String 	soDienThoai;
	protected 	String 	chucVu;
	protected 	float 	ngayLamViec;
	protected 	float 	luongMotNgay;
	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	
	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public float getNgayLamViec() {
		return ngayLamViec;
	}

	public void setNgayLamViec(float ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}

	public float getLuongMotNgay() {
		return luongMotNgay;
	}

	public void setLuongMotNgay(float luongMotNgay) {
		this.luongMotNgay = luongMotNgay;
	}

	public String getTen() {
		return this.ten;
	}
	
	public void setTen(String ten) {
		String [] tenRef = ten.split(" ");
		this.ten = tenRef[tenRef.length - 1];
	}
	public NhanSu() {
		this.tenNhanVien	= "Rong";
		this.ten			= "Rong";
		this.chucVu			= "Rong";
		this.maNhanVien		= "Rong";
		this.soDienThoai 	= "Rong";
		this.ngayLamViec 	= 22;
	}

	public NhanSu(String tenNhanVien, String maNhanVien, String soDienThoai, String chucVu, float ngayLamViec, float luongMotNgay) {
		this.tenNhanVien 	= tenNhanVien;
		this.maNhanVien 	= maNhanVien;
		this.soDienThoai 	= soDienThoai;
		this.chucVu 		= chucVu;
		this.ngayLamViec 	= ngayLamViec;
		this.luongMotNgay 	= luongMotNgay;
	}

	public float tinhLuong() {
		return ngayLamViec * luongMotNgay;
	}
	
	public void themThongTin(Scanner scanner) {
		System.out.print("- Ten nhan vien	:");
		this.tenNhanVien = scanner.nextLine();
		setTen(this.tenNhanVien);
		System.out.print("- Ma so		:");
		this.maNhanVien = scanner.nextLine();
		System.out.print("- So dien thoai	:");
		this.soDienThoai = scanner.nextLine();
		System.out.print("- So ngay lam viec:");
		this.ngayLamViec = Float.parseFloat(scanner.nextLine());
	}
	
	
	public void inThongTin() {
		System.out.print(String.format("%13s |", this.chucVu));
		System.out.print(String.format("%20s |", this.maNhanVien));
		System.out.print(String.format("%20s |", this.tenNhanVien));
		System.out.print(String.format("%20s |", this.soDienThoai));
		System.out.print(String.format("%20.2f |", this.ngayLamViec));
	}
	
}
