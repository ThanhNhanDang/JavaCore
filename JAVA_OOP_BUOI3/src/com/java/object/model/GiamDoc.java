package com.java.object.model;

import java.util.Scanner;

public class GiamDoc extends NhanSu{
	private float soCoPhan;
	public float getSoCoPhan() {
		return this.soCoPhan;
	}
	public void setSoCoPhan(float soCoPhan) {
		this.soCoPhan = soCoPhan;
	}
	public GiamDoc(float soCoPhan) {
		super();
		this.soCoPhan = soCoPhan;
	}

	public GiamDoc() {
		super();
		
	}

	@Override
	public void setChucVu(String chucVu) {
		super.setChucVu(chucVu);
	}
	
	public GiamDoc(String tenNhanVien, String maNhanVien, String soDienThoai, String chucVu, float ngayLamViec, float luongMotNgay,
			float soCoPhan) {
		super(tenNhanVien, maNhanVien, soDienThoai, chucVu, ngayLamViec, luongMotNgay);
		this.soCoPhan= soCoPhan;
	}
	
	@Override
	public void themThongTin(Scanner scanner) {
		super.themThongTin(scanner);
		setLuongMotNgay(300);
		setChucVu("Giam Doc");
		System.out.print("So co phan (%): ");
		this.soCoPhan = Float.parseFloat(scanner.nextLine());
		while (this.soCoPhan > 100 || this.soCoPhan < 0) {
			System.err.println("Nhap sai!");
			System.out.print("So co phan (%): ");
			this.soCoPhan = Float.parseFloat(scanner.nextLine());
		}
		this.soCoPhan = this.soCoPhan/100;
		
	}
	
	@Override
	public void inThongTin() {
		super.inThongTin();
		System.out.print(String.format("%20.2f |", tinhLuong()));
		System.out.print(String.format("%21.2f |", this.soCoPhan*100));
	}
	@Override
	public float tinhLuong() {
		return super.tinhLuong();
	}
}

