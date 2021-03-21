package com.java.object.model;
import java.util.Scanner;


public class TruongPhong extends NhanSu{
	private int soNhanVien;
	
	public int getSoNhanVien() {
		return this.soNhanVien;
	}
	public TruongPhong(int soNhanVien) {
		super();
		this.soNhanVien = soNhanVien;
	}

	public TruongPhong( ) {
		super();
	}
	
	public TruongPhong(String tenNhanVien, String maNhanVien, String soDienThoai, String chucVu, float ngayLamViec, float luongMotNgay) {
		super(tenNhanVien, maNhanVien, soDienThoai, chucVu, ngayLamViec, luongMotNgay);
	}
	@Override
	public void setChucVu(String chucVu) {
		super.setChucVu(chucVu);
	}
	
	
	@Override
	public void themThongTin(Scanner scanner) {
		super.themThongTin(scanner);
		setLuongMotNgay(200);
		setChucVu("Truong Phong");
	}
	@Override
	public void inThongTin() {
		super.inThongTin();
		System.out.print(String.format("%20.2f |", tinhLuong()));
		System.out.print(String.format("%21d |", this.soNhanVien));
		System.out.println();
	}
	@Override
	public float tinhLuong() {
		return (super.tinhLuong() + (100 * this.soNhanVien));
	}
	
	public void tangNhanVien() {
		this.soNhanVien++;
	}
	
	public void giamNhanVien() {
		this.soNhanVien--;
	}
}


