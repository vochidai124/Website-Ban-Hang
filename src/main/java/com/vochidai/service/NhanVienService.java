package com.vochidai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vochidai.dao.NhanVienDAO;
import com.vochidai.daoimp.NhanVienImp;
import com.vochidai.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp{
	
	@Autowired
	NhanVienDAO nhanVienDAO;

	@Override
	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra = nhanVienDAO.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	@Override
	public boolean ThemNhanVien(NhanVien nhanVien) {
		boolean ktThem=nhanVienDAO.ThemNhanVien(nhanVien);
		return false;
	}
	
}
