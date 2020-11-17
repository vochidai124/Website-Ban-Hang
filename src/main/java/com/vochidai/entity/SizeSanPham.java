package com.vochidai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "sizesanpham")
public class SizeSanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int masize;
	String tenmau;
	public int getMasize() {
		return masize;
	}
	public void setMasize(int masize) {
		this.masize = masize;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	
}
