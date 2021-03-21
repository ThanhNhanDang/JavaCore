package com.java.object.model;

import java.util.Scanner;

public class NhanVien extends NhanSu {
	private String maTruongPhong;
	
	public NhanVien(String maTruongPhong) {
		super();
		this.maTruongPhong = maTruongPhong;
	}

	public NhanVien( ) {
		super();
		this.maTruongPhong = "Rong";
	}
	
	@Override
	public void setChucVu(String chucVu) {
		super.setChucVu(chucVu);
	}
	
	public void setMaTruongPhong(String maTruongPhong) {
		this.maTruongPhong = maTruongPhong;
	}
	
	public String getMaTruongPhong() {
		return this.maTruongPhong;
	}
	
	public NhanVien(String tenNhanVien, String maNhanVien, String soDienThoai, String chucVu, float ngayLamViec, float luongMotNgay) {
		super(tenNhanVien, maNhanVien, soDienThoai, chucVu, ngayLamViec, luongMotNgay);
	}
	
	@Override
	public void themThongTin(Scanner scanner) {
		setLuongMotNgay(100);
		super.themThongTin(scanner);
		setChucVu("Nhan Vien");
	}
	
	@Override
	public void inThongTin() {
		super.inThongTin();
		System.out.print(String.format("%20.2f |", tinhLuong()));
		System.out.print(String.format(" %20s |",this.maTruongPhong));
		System.out.println();
	}
	@Override
	public float tinhLuong() {
		return super.tinhLuong();
	}
}

