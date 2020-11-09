package com.checongbinh.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "chitiethoadon")
public class ChiTietHoaDon {
	
	@EmbeddedId
	ChiTietHoaDonid chiTietHoaDonid;
	
	int soluong;
	String giatien;
	
}
