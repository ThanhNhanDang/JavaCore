package com.cyber.java.object;
import java.util.Scanner;


public class QuanLySinhVien{
	private String name;
	private String maSo;
	private String ten;
	Scanner scanner = new Scanner(System.in);
	
	public QuanLySinhVien() {
		name	 = "Rong";
		ten 	 = "Rong";
		maSo 	 = "Rong";
	}
	public String getName() {
		return name;
	}
	
	public boolean setName(String name) {
		if (name != null && name.length() != 0) {
			this.name = name;
			return true;
		}
		else {
			System.err.println("ERROR!!");
			return false;
		}
		
	}
	public String getMaSo() {
		return maSo;
	}
	
	public boolean setMaSo(String maSo) {
		if (maSo != "null") {
			this.maSo = maSo;
			return true;
		}
		else {
			System.err.println("ERROR!!");
			return false;
		}
	}
	
	public String getTen() {
		return ten;
	}
	public void setTen() {
		String []name = this.name.split(" ");
		this.ten = name[name.length - 1];
	}
	public QuanLySinhVien(String name, String maSo, String ten) {
		this.name = name;
		this.maSo = maSo;
		this.ten = ten;
	}
	
	public void input() {	
		String name;
		String maSo;
		
		
		System.out.print("- Enter name: ");
		while (true){
			name = scanner.nextLine();
			if(setName(name)) {
				break;
			}
			System.out.print("  Enter name: ");
			
		}
		setTen();
		System.out.print("- Enter code: ");
		while (true){
			maSo = scanner.nextLine();
			if(setMaSo(maSo)) {
				break;
			}
			System.out.print("  Enter code: ");
			
		}
	}
	
	public void output() {
		System.out.println("- Name		   :"		+ name);
		System.out.println("- Code		   :" 		+ maSo);
	}
	
}
